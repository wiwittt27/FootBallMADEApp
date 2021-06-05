package com.alawiyaa.footballapp.ui.match

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alawiyaa.footballapp.R
import com.alawiyaa.footballapp.core.data.Resource
import com.alawiyaa.footballapp.core.ui.MatchResultAdapter
import com.alawiyaa.footballapp.databinding.FragmentResultMatchBinding
import org.koin.android.viewmodel.ext.android.viewModel


class ResultMatchFragment : Fragment() {

    private var _binding: FragmentResultMatchBinding? = null
    private val binding get() = _binding
    private val homeViewModel: ResultMatchViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultMatchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val resultAdapter = MatchResultAdapter()
            resultAdapter.onItemClick = { selectData ->
                val toDetail =
                    ResultMatchFragmentDirections.actionNavigationResultToDetailMatchFragment(
                        selectData
                    )
                view.findNavController().safeNavigate(toDetail)


            }
            homeViewModel.resultMatch.observe(viewLifecycleOwner, { match ->
                if (match != null) {
                    when (match) {

                        is Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                        is Resource.Success -> {
                            DividerItemDecoration(
                                activity,
                                DividerItemDecoration.VERTICAL
                            )
                            binding?.progressBar?.visibility = View.GONE
                            resultAdapter.setData(match.data)

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

            with(binding?.rvResultMatch) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = resultAdapter
            }
        }
    }

    private fun NavController.safeNavigate(direction: NavDirections) {
        Log.d("clickTag", "Click happened")
        currentDestination?.getAction(direction.actionId)?.run {
            Log.d("clickTag", "Click Propagated")
            navigate(direction)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}