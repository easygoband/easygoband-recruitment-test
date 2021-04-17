package com.riac.easygoband.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.riac.easygoband.R
import com.riac.easygoband.databinding.FragmentFirstBinding
import com.riac.easygoband.databinding.FragmentSelectionBinding
import com.riac.easygoband.viewmodels.MainViewModel

class SelectionFragment : Fragment() {

    lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentSelectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectionBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fsOption1.setOnClickListener {
            viewModel.setServerSelection(0)
            findNavController().navigate(R.id.from_selection_to_provided_server_options)
        }

        binding.fsOption2.setOnClickListener {
            viewModel.setServerSelection(1)
            findNavController().navigate(R.id.from_selection_to_local_server)
        }
    }
}