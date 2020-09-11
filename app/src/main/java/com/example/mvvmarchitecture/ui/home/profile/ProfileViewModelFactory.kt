package com.example.mvvmarchitecture.ui.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarchitecture.data.reposistries.UserReposotory

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory(
    private val repository : UserReposotory
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }
}