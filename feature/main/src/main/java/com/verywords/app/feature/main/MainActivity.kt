package com.verywords.app.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.verywords.app.feature.home.HomeFragment
import com.verywords.app.feature.main.databinding.ActivityMainBinding
import com.verywords.app.feature.map.MapFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeFragment: HomeFragment
    private lateinit var mapFragment: MapFragment
    private var activeFragment: Fragment? = null

    private fun showFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (fragment.isAdded) {
            fragmentTransaction.hide(activeFragment!!).show(fragment)
        } else {
            fragmentTransaction.hide(activeFragment!!).add(R.id.fragmentContainer, fragment)
        }
        fragmentTransaction.commit()
        activeFragment = fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeFragment = HomeFragment()
        mapFragment = MapFragment()

        // Initialize the first fragment to show
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, homeFragment).commit()
            activeFragment = homeFragment
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    showFragment(homeFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.mapFragment -> {
//                    showFragment(MapFragment())
                    showFragment(mapFragment)
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}


// COMPOSE
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        window.decorView.apply {
////            systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
////                    or View.SYSTEM_UI_FLAG_FULLSCREEN
////                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
////        }
////        val isDarkTheme by viewModel.isDarkTheme.collectAsStateWithLifecycle(false, this)
//
//
//
////         compose
//        setContent {
//            val navigator: MainNavigator = rememberMainNavigator()
//            POPLETheme {
//                MainScreen(
//                    navigator = navigator,
//                    onChangeDarkTheme = { isDarkTheme -> false }
//                )
//            }
//        }
//    }
//}

