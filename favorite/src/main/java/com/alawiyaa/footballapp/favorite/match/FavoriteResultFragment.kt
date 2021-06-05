package com.alawiyaa.footballapp.favorite.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alawiyaa.footballapp.core.ui.MatchResultAdapter
import com.alawiyaa.footballapp.favorite.FavoriteFragmentDirections
import com.alawiyaa.footballapp.favorite.databinding.FragmentFavoriteResultBinding
import com.alawiyaa.footballapp.favorite.favoriteModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules


class FavoriteResultFragment : Fragment() {
    private  val favoriteMatchViewModel: FavoriteMatchViewModel by viewModel()

    private var _binding: FragmentFavoriteResultBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteResultBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    loadKoinModules(favoriteModule)
        if (activity != null) {

            val matchAdapter = MatchResultAdapter()
            matchAdapter.onItemClick = { selectedData ->
                val toDetail =  FavoriteFragmentDirections.actionNavigationFavoriteToDetailMatchFragment(selectedData)
                view.findNavController().navigate(toDetail)

            }


            favoriteMatchViewModel.favoriteMatch.observe(viewLifecycleOwner, { dataMatch ->
                matchAdapter.setData(dataMatch)
                binding?.tvEmpty?.visibility = if (dataMatch.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding?.rvFavoriteResult) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = matchAdapter
            }
        }
    }

    override fun onStop() {
        super.onStop()
        unloadKoinModules(favoriteModule)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}