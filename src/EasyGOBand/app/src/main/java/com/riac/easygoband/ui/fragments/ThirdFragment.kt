package com.riac.easygoband.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.riac.easygoband.adapters.SessionAdapter
import com.riac.easygoband.databinding.FragmentThirdBinding
import com.riac.easygoband.models.APIResponseItem
import com.riac.easygoband.util.Constants.Companion.TAG_TF
import com.riac.easygoband.util.Resource
import com.riac.easygoband.viewmodels.MainViewModel

class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    private lateinit var rvDetSessions: SessionAdapter
    lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = arguments?.get("item") as APIResponseItem
        binding.itemDetail.text = item.allFormattedData()

        setupRecyclerView()


        viewModel.retrievedData.observe(viewLifecycleOwner, { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG_TF, "An error ocurred: $message")
                    }
                }
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { rvDetSessions.differ.submitList(item.sessions) }
                }
            }
        })

    }

    private fun setupRecyclerView() {
        rvDetSessions = SessionAdapter()
        binding.rvDetSessions.apply {
            adapter = rvDetSessions
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun hideProgressBar() {
        binding.rvDetProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.rvDetProgressBar.visibility = View.VISIBLE
    }

}