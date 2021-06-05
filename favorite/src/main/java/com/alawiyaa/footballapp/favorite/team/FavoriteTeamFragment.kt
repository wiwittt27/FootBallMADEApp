package com.alawiyaa.footballapp.favorite.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alawiyaa.footballapp.core.ui.TeamAdapter
import com.alawiyaa.footballapp.favorite.FavoriteFragmentDirections
import com.alawiyaa.footballapp.favorite.databinding.FragmentFavoriteTeamBinding
import com.alawiyaa.footballapp.favorite.favoriteModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class FavoriteTeamFragment : Fragment() {

    private val favoriteTeamViewModel: FavoriteTeamViewModel by viewModel()

    private var _binding: FragmentFavoriteTeamBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteTeamBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(favoriteModule)
        if (activity != null) {

            val teamAdapter = TeamAdapter()
            teamAdapter.onItemClick = { selectedData ->
                val toDetail =
                    FavoriteFragmentDirections.actionNavigationFavoriteToDetailTeamFragment(
                        selectedData
                    )
                view.findNavController().navigate(toDetail)
            }

            favoriteTeamViewModel.footballTeam.observe(viewLifecycleOwner, { dataMatch ->
                teamAdapter.setData(dataMatch)
                binding?.tvEmpty?.visibility =
                    if (dataMatch.isNotEmpty()) View.GONE else View.VISIBLE

            })

            with(binding?.rvFavoriteTeam) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = teamAdapter
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