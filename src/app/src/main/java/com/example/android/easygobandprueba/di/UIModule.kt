package com.example.android.easygobandprueba.di

import com.example.android.easygobandprueba.mainactivity.list.vm.ListViewModel
import com.example.android.easygobandprueba.mainactivity.starting.vm.StartingViewModel
import com.example.android.easygobandprueba.utils.SharedEventVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { ListViewModel(get()) }
    viewModel { StartingViewModel(get()) }
    viewModel { SharedEventVM() }
}