package com.riac.easygoband.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.riac.easygoband.R
import com.riac.easygoband.databinding.FragmentFirstBinding
import com.riac.easygoband.databinding.FragmentLocalServerBinding
import com.riac.easygoband.viewmodels.MainViewModel

class LocalServerFragment : Fragment() {

    private lateinit var binding: FragmentLocalServerBinding
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocalServerBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lsShowAll.setOnClickListener {
            findNavController().navigate(R.id.from_ls_to_list)
        }
    }

}