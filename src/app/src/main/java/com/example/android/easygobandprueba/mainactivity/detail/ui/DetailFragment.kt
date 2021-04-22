package com.example.android.easygobandprueba.mainactivity.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.easygobandprueba.R
import com.example.android.easygobandprueba.commons.BaseFragment
import com.example.android.easygobandprueba.commons.fromSessionsToString
import com.example.android.easygobandprueba.databinding.FragmentDetailBinding
import com.example.android.easygobandprueba.utils.SharedEventVM
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DetailFragment : BaseFragment() {

    private val sharedEventVM: SharedEventVM by sharedViewModel()

    private var _binding: FragmentDetailBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun loadObservers() {
        sharedEventVM.event.observe(viewLifecycleOwner, {
            it.apply {
                //set Text from EventDTO Object
                binding.tvAccessGroupId.text = "${R.string.access_group_id}: $accessGroupId"
                binding.tvAccessGroupName.text = "Access Group Name: $accessGroupName"
                binding.tvBasicProductId.text = "Basic Product Id: $basicProductId"
                binding.tvEventId.text = "Event Id: $eventId"
                binding.tvId.text = "Id: $id"
                binding.tvModified.text = "Modified: $modified"
                binding.tvName.text = "Name: $name"
                val session = fromSessionsToString(sessions)
                binding.tvSessionsList.text = "Sessions: $session"
                binding.tvStructureDecode.text = "Structure Decode$structureDecode"
                binding.tvTotalUses.text = "Total Uses: $totalUses"
            }
        })
    }

    override fun loadListeners() {

    }
}



