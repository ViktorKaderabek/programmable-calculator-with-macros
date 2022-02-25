package com.example.programovatelna_kalkulacka.di

import com.example.programovatelna_kalkulacka.presentation.mainScreen_viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel()
    }
}

