package com.example.android.easygobandprueba.mainactivity.starting.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.easygobandprueba.R
import com.example.android.easygobandprueba.commons.BaseFragment
import com.example.android.easygobandprueba.databinding.FragmentStartingBinding
import com.example.android.easygobandprueba.mainactivity.starting.vm.StartingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartingFragment : BaseFragment() {

    private val presenter: StartingViewModel by viewModel()

    private var _binding: FragmentStartingBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun loadObservers() {
        presenter.showError.observe(viewLifecycleOwner, {
            showToast(it)
        })

        presenter.isLoading.observe(viewLifecycleOwner, {
            binding.progressBar.visibility = showProgressBar(it)
        })

        presenter.navigate.observe(viewLifecycleOwner, {
            enableBtnToList(true)
            if (it){
                this.findNavController().navigate(R.id.action_startingFragment_to_listFragment)
            }
        })
    }

    override fun loadListeners() {
        binding.btnToList.setOnClickListener {
            enableBtnToList(false)
            val value = binding.etNumberId.text.toString()
            if (hasContent(value)){
                presenter.startSearch(value.toInt())
            }
        }
    }

    private fun hasContent(value: String): Boolean{
        if (value.isNullOrEmpty()){
            presenter.setShowError("Type a number")
            enableBtnToList(true)
            return false
        }
        return true
    }

    private fun enableBtnToList(bool: Boolean){
        binding.btnToList.isEnabled = bool
    }

}