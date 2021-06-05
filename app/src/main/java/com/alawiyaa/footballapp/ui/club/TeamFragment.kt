package com.alawiyaa.footballapp.ui.club

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alawiyaa.footballapp.R
import com.alawiyaa.footballapp.core.data.Resource
import com.alawiyaa.footballapp.core.ui.TeamAdapter
import com.alawiyaa.footballapp.databinding.FragmentTeamBinding
import org.koin.android.viewmodel.ext.android.viewModel


class TeamFragment : Fragment() {

    private var _binding: FragmentTeamBinding? = null
    private val binding get() = _binding
    private val homeViewModel: TeamViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

           val teamAdapter = TeamAdapter()
            teamAdapter.onItemClick = { selectData ->
                val toDetail =
                    TeamFragmentDirections.actionNavigationClubToDetailTeamFragment(selectData)
                view.findNavController().navigate(toDetail)


            }

            homeViewModel.team.observe(viewLifecycleOwner, { match ->
                if (match != null) {
                    when (match) {
                        is Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                        is Resource.Success -> {
                            DividerItemDecoration(
                                activity,
                                DividerItemDecoration.VERTICAL
                            )
                            binding?.progressBar?.visibility = View.GONE
                            teamAdapter.setData(match.data)
                        }
                        is Resource.Error -> {
                            binding?.progressBar?.visibility = View.GONE
                            binding?.viewErrorData?.root?.visibility = View.VISIBLE
                            binding?.viewErrorData?.tvError?.text =
                                match.message ?: getString(R.string.something_wrong)


                        }
                    }
                }
            })
            with(binding?.rvClub) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = teamAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}