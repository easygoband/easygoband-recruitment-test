package com.example.android.easygobandprueba.mainactivity.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.data.models.EventDTO
import com.example.android.easygobandprueba.R
import com.example.android.easygobandprueba.commons.BaseFragment
import com.example.android.easygobandprueba.databinding.FragmentListBinding
import com.example.android.easygobandprueba.mainactivity.list.vm.ListViewModel
import com.example.android.easygobandprueba.utils.SharedEventVM
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : BaseFragment(), CellClickListener {

    private val presenter: ListViewModel by viewModel()
    private val sharedEventVM: SharedEventVM by sharedViewModel()

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.assignValueToEventListFiltered()
    }

    override fun loadObservers() {

        presenter.eventListFiltered.observe(viewLifecycleOwner, { eventList ->
            val adapter = AdapterEventList(eventList, this)
            binding.rvEventList.adapter = adapter
        })

    }

    override fun loadListeners() {
        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            //Executes every time text is changed
            override fun onQueryTextChange(newText: String?): Boolean {
                presenter.filterEventListByName(newText ?: "")
                return false
            }
        })
    }

    override fun onCellClickListener(event: EventDTO) {
        //add object to sharedVM
        sharedEventVM.setEvent(event)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment)
    }

}