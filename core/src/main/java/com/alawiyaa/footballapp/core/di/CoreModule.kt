package com.alawiyaa.footballapp.core.di

import androidx.room.Room
import com.alawiyaa.footballapp.core.BuildConfig
import com.alawiyaa.footballapp.core.data.FootBallRepository
import com.alawiyaa.footballapp.core.data.source.local.LocalDataSource
import com.alawiyaa.footballapp.core.data.source.local.room.FootBallDatabase
import com.alawiyaa.footballapp.core.data.source.remote.RemoteDataSource
import com.alawiyaa.footballapp.core.data.source.remote.network.ApiService
import com.alawiyaa.footballapp.core.domain.repository.IFootBallRepository
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<FootBallDatabase>().matchDao() }
    factory { get<FootBallDatabase>().teamDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("football".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            FootBallDatabase::class.java, "FootBall.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "www.thesportsdb.com"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/ctt1haazs8U6LJbBhG1dMDCxflw6Q5LRFqlJP+iCf3E=")
            .add(hostname, "sha256/FEzVOUp4dF3gI0ZVPRJhFbSJVXR+uQmMH65xhs1glH4=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = when (BuildConfig.DEBUG) {
                    true -> HttpLoggingInterceptor.Level.BODY
                    false -> HttpLoggingInterceptor.Level.NONE
                }
            })
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get(), get()) }
    single { RemoteDataSource(get()) }
    single<IFootBallRepository> { FootBallRepository(get(), get()) }
}