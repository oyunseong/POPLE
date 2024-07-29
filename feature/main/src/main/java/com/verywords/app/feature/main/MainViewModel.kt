package com.verywords.app.feature.main

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.verywords.app.feature.home.HomeFragment
import com.verywords.app.feature.login.LoginFragment
import com.verywords.app.feature.map.MapFragment

class MainViewModel : ViewModel() {
    override fun onCleared() {
        super.onCleared()
        Log.d("++##", "MainViewModel onCleared")
    }

    private var homeFragment: HomeFragment? = null// by lazy { HomeFragment() }
    private var mapFragment: MapFragment? = null// by lazy { MapFragment() }
    private var loginFragment: LoginFragment? = null//by lazy { LoginFragment() }
    private var lastVisibleFragment: Fragment? = null

    init {
        Log.d("++##", "MainViewModel init")
        homeFragment = HomeFragment()
        lastVisibleFragment = homeFragment
    }

    fun test(bottomNavigationView: BottomNavigationView) {
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            Log.d("++##", "menuItem.itemId :${menuItem.itemId}")
            when (menuItem.itemId) {
                R.id.homeFragment -> {
                    Log.d("++##", "homeFragment")
                    return@setOnItemSelectedListener true
                }

                R.id.mapFragment -> {
                    Log.d("++##", "mapFragment")
                    return@setOnItemSelectedListener true
                }

                R.id.loginFragment -> {
                    Log.d("++##", "loginFragment")
                    return@setOnItemSelectedListener true
                }

                else -> return@setOnItemSelectedListener false

            }

        }

        fun initBottomNavigation(
            fragmentManager: FragmentManager,
            bottomNavigationView: BottomNavigationView
        ) {
            if (lastVisibleFragment != null) {
                fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, lastVisibleFragment!!).commit()
            }

            bottomNavigationView.setOnItemSelectedListener { menuItem ->
//            if(menuItem.itemId == currentFragment.id) return@setOnItemSelectedListener false
                Log.d("++##", "menuItem.itemId :${menuItem.itemId}")
                when (menuItem.itemId) {
                    R.id.homeFragment -> {
                        fragmentManager.fragments.forEach {
                            if (R.id.homeFragment != it.id) {
                                fragmentManager.beginTransaction().hide(it).commit()
                            }
                        }
//                    if (fragmentManager.findFragmentById(R.id.homeFragment) == null) {
                        if (homeFragment == null) {
                            fragmentManager.beginTransaction()
                                .add(R.id.fragmentContainer, homeFragment!!)
                                .commit()
                        } else {
                            fragmentManager.beginTransaction().show(homeFragment!!).commit()
                        }
                        lastVisibleFragment = homeFragment
                        return@setOnItemSelectedListener true
                    }

                    R.id.mapFragment -> {
                        fragmentManager.fragments.forEach {
                            if (R.id.mapFragment != it.id) {
                                fragmentManager.beginTransaction().hide(it).commit()
                            }
                        }
//                    if (fragmentManager.findFragmentById(R.id.mapFragment) == null) {
                        if (mapFragment == null) {
                            mapFragment = MapFragment()
                            fragmentManager.beginTransaction()
                                .add(R.id.fragmentContainer, mapFragment!!)
                                .commit()
                        } else {
                            fragmentManager.beginTransaction().show(mapFragment!!).commit()
                        }
                        lastVisibleFragment = mapFragment
                        return@setOnItemSelectedListener true
                    }

                    R.id.loginFragment -> {
                        fragmentManager.fragments.forEach {
                            if (R.id.loginFragment != it.id) {
                                fragmentManager.beginTransaction().hide(it).commit()
                            }
                        }
//                    if (fragmentManager.findFragmentById(R.id.loginFragment) == null) {
                        if (loginFragment == null) {
                            loginFragment = LoginFragment()
                            fragmentManager.beginTransaction()
                                .add(R.id.fragmentContainer, loginFragment!!)
                                .commit()
                        } else {
                            fragmentManager.beginTransaction().show(loginFragment!!).commit()
                        }
                        lastVisibleFragment = loginFragment
                        return@setOnItemSelectedListener true
                    }

                    else -> return@setOnItemSelectedListener false

                }
            }
        }
    }
}