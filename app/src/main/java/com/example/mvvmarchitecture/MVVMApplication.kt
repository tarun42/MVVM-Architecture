package com.example.mvvmarchitecture

import android.app.Application
import com.example.mvvmarchitecture.data.db.AppDatabase
import com.example.mvvmarchitecture.data.network.MyApi
import com.example.mvvmarchitecture.data.network.NetworkConnectionInterceptor
import com.example.mvvmarchitecture.data.reposistries.UserReposotory
import com.example.mvvmarchitecture.ui.auth.AuthViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(),KodeinAware{
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))
        bind() from singleton {
            NetworkConnectionInterceptor(instance())
        }
        bind() from singleton { MyApi(instance())}
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserReposotory(instance(),instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
    }


}