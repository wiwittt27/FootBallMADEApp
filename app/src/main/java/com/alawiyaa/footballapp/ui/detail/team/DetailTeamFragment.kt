package com.alawiyaa.footballapp.ui.detail.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.alawiyaa.footballapp.R
import com.alawiyaa.footballapp.core.domain.model.Team
import com.alawiyaa.footballapp.databinding.FragmentDetailTeamBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.viewmodel.ext.android.viewModel


class DetailTeamFragment : Fragment() {
    private val detailTeamViewModel: DetailTeamViewModel by viewModel()
    private var _binding: FragmentDetailTeamBinding? = null
    private val binding get() = _binding
    private var dataTeam: Team? = null
    private var navBar: BottomNavigationView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailTeamBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navBar = requireActivity().findViewById(R.id.bottom_nav)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
        setHasOptionsMenu(true)
        setupToolbar()

        dataTeam = DetailTeamFragmentArgs.fromBundle(arguments as Bundle).detailTeamFragment
        dataTeam.let {
            if (it != null) {
                showDetailTeam(it)
            }
        }

    }

    private fun showDetailTeam(dataTeam: Team) {
        binding?.tvStadiumName?.text = dataTeam.stadiumName
        binding?.imgPosterDetailTeam?.let {
            Glide.with(requireContext())
                .load(dataTeam.stadiumThumb)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(it)
        }
        binding?.contentDetailTeam?.imgTeamBadge?.let {
            Glide.with(requireContext())
                .load(dataTeam.teamBadge)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(it)
        }
        binding?.contentDetailTeam?.tvTeamName?.text = dataTeam.teamName
        binding?.contentDetailTeam?.tvTeamYear?.text = dataTeam.formedYear
        binding?.contentDetailTeam?.tvTeamDescription?.text = dataTeam.descriptionTeam

        var statusFavorite = dataTeam.isFavorite
        setStatusFavorite(statusFavorite)
        binding?.fabFavorite?.setOnClickListener {
            statusFavorite = !statusFavorite
            detailTeamViewModel.setFavoriteTeam(dataTeam, statusFavorite)
            setStatusFavorite(statusFavorite)
        }

    }


    override fun onStart() {
        super.onStart()
        navBar?.visibility = View.GONE
    }

    override fun onStop() {
        super.onStop()
        navBar?.visibility = View.VISIBLE
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

    private fun setupToolbar() {

        binding?.toolbarLayout?.setCollapsedTitleTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.white
            )
        )
        binding?.toolbarLayout?.setExpandedTitleColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.transparent
            )
        )
    }
}