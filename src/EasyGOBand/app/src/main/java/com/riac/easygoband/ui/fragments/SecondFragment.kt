package com.riac.easygoband.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.riac.easygoband.R
import com.riac.easygoband.adapters.EntryAdapter
import com.riac.easygoband.databinding.FragmentSecondBinding
import com.riac.easygoband.models.APIResponse
import com.riac.easygoband.models.APIResponseItem
import com.riac.easygoband.util.Constants.Companion.SF_SPINNER_ID
import com.riac.easygoband.util.Constants.Companion.TAG_SF
import com.riac.easygoband.util.Resource
import com.riac.easygoband.viewmodels.MainViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var spinnerOptions: Array<String>
    private lateinit var spinnedIDs: ArrayList<Int>
    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var rvAdapter: EntryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupRecyclerView()

        viewModel.requestData()

        viewModel.retrievedData.observe(viewLifecycleOwner, { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG_SF, "An error ocurred: $message")
                    }
                }
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { apiResponse ->
                        setupFilters(apiResponse)
                        rvAdapter.differ.submitList(apiResponse)
                    }
                }
            }
        })


        rvAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("item", it)
            }
            findNavController().navigate(R.id.from_list_to_detail, bundle)
        }

    }

    private fun setupFilters(apiResponse: List<APIResponseItem>) {
        val tempOptions = ArrayList<String>()
        val tempIDs = ArrayList<Int>()
        tempOptions.add("Todos")
        tempIDs.add(0)
        for (item in apiResponse) {
            for (session in item.sessions) {
                if (!tempOptions.contains(session.name)) {
                    tempOptions.add(session.name)
                    tempIDs.add(session.id)
                }
            }
        }
        spinnerOptions = tempOptions.toTypedArray()
        spinnedIDs = tempIDs
        val aa =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                tempOptions.toTypedArray()
            )
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        with(binding.filterOptions) {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = this@SecondFragment
            prompt = "Filtros por ID de session"
            gravity = Gravity.CENTER
        }

        binding.filterOptions.id = SF_SPINNER_ID

    }

    private fun hideProgressBar() {
        binding.rvProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.rvProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        rvAdapter = EntryAdapter()
        binding.rvEntries.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedItem = id.toInt()
        val relatedID = spinnedIDs[selectedItem]
        if (relatedID == 0) {
            rvAdapter.differ.submitList(viewModel.retrievedData.value!!.data)
        } else {
            rvAdapter.differ.submitList(
                filterByID(
                    relatedID,
                    viewModel.retrievedData.value!!.data!!
                )
            )
        }
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected")
    }

    private fun filterByID(id: Int, data: APIResponse): List<APIResponseItem> {
        val temp = ArrayList<APIResponseItem>()
        for (item in data) {
            for (session in item.sessions) {
                if (session.id == id) {
                    temp.add(item)
                }
            }
        }
        return temp.toList()
    }

    private fun showToast(message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }
}