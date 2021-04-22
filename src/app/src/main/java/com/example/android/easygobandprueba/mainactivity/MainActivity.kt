package com.example.android.easygobandprueba.mainactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.easygobandprueba.R
import com.example.android.easygobandprueba.commons.BaseActivity

class MainActivity : BaseActivity() {

    //Makes Activity Context public
    companion object {
            private var instance: MainActivity? = null
            //put everything public here

            fun applicationContext() : Context {
                return instance!!.applicationContext
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.myNavHostFragment)

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, null)
    }
}