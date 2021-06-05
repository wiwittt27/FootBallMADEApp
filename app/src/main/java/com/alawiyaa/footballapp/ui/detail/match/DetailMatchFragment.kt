package com.alawiyaa.footballapp.ui.detail.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.alawiyaa.footballapp.R
import com.alawiyaa.footballapp.core.domain.model.Match
import com.alawiyaa.footballapp.databinding.FragmentDetailMatchBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.viewmodel.ext.android.viewModel


class DetailMatchFragment : Fragment() {
    private val detailMatchViewModel : DetailMatchViewModel by viewModel()
    private  var _binding: FragmentDetailMatchBinding? = null
    private val binding get() = _binding
    private var dataMatch: Match? = null
    private var navBar: BottomNavigationView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailMatchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navBar = requireActivity().findViewById(R.id.bottom_nav)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
         dataMatch = DetailMatchFragmentArgs.fromBundle(arguments as Bundle).detailMatch
        dataMatch.let {
            if (it != null) {
                showDetailMatch(it)
            }
        }
        setHasOptionsMenu(true)




    }

    override fun onStart() {
        super.onStart()
        navBar?.visibility = View.GONE
    }

    override fun onStop() {
        super.onStop()
        navBar?.visibility = View.VISIBLE
    }

    private fun showDetailMatch(dataMatch: Match) {
        binding?.tvLeagueName?.text = dataMatch.league
        binding?.tvMatchName?.text = dataMatch.eventName
        binding?.tvHomeScore?.text = dataMatch.homeScore
        binding?.tvLeagueTime?.text = dataMatch.dateEvent
        binding?.tvTeamAway?.text = dataMatch.awayTeam
        binding?.tvTeamHome?.text = dataMatch.homeTeam
        binding?.tvAwayScore?.text = dataMatch.awayScore
        binding?.tvSeason?.text = dataMatch.season
        binding?.tvVenue?.text = dataMatch.venue
        binding?.tvLeagueStatus?.text = dataMatch.status


        var statusFavorite = dataMatch.isFavorite
        setStatusFavorite(statusFavorite)
        binding?.fabFavorite?.setOnClickListener {
            statusFavorite = !statusFavorite
            detailMatchViewModel.setFavoriteMatch(dataMatch, statusFavorite)
            setStatusFavorite(statusFavorite)
        }


    }


    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding?.fabFavorite?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.ic_favorite_yellow
                )
            )
        } else {
            binding?.fabFavorite?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.ic_favorite_white
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}