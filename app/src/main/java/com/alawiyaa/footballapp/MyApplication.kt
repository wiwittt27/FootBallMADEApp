package com.alawiyaa.footballapp

import android.app.Application
import com.alawiyaa.footballapp.core.di.databaseModule
import com.alawiyaa.footballapp.core.di.networkModule
import com.alawiyaa.footballapp.core.di.repositoryModule
import com.alawiyaa.footballapp.di.useCaseModule
import com.alawiyaa.footballapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }

}