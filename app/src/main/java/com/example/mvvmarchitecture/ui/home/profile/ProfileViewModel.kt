package com.example.mvvmarchitecture.ui.home.profile

import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.data.reposistries.UserReposotory

class ProfileViewModel(
    repository :UserReposotory
) : ViewModel() {
    val user =repository.getUser()

}