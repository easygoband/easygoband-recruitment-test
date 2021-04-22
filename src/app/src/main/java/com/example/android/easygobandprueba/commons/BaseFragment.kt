package com.example.android.easygobandprueba.commons

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(){

    abstract fun loadObservers()
    abstract fun loadListeners()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadObservers()
        loadListeners()
    }

    fun showToast(str: String){
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }

    fun showProgressBar(bool: Boolean): Int = if(bool) View.VISIBLE else View.GONE

}