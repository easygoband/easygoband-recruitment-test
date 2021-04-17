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
import com.riac.easygoband.viewmodels.MainViewModel
import com.riac.easygoband.util.toast


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.MASendRequest.setOnClickListener {
            val id = binding.etMAField.text.toString().toIntOrNull()
            if (id == 1) {
                viewModel.setRequestId(id)
                findNavController().navigate(R.id.from_id_to_list)
            } else {
                context?.toast(resources.getString(R.string.input_id_error))
            }
        }

    }
}