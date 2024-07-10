package com.verywords.app.feature.map

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.verywords.app.feature.mpa.databinding.FragmentMapBinding

class MapFragment : Fragment() {
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("++##", "MapFragment onCreateView")
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            loadUrl("https://www.naver.com")
        }
        return view
    }

    override fun onPause() {
        super.onPause()
        Log.d("++##", "MapFragment onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("++##", "MapFragment onResume")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("++##", "MapFragment onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("++##", "MapFragment onDetach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("++##", "MapFragment onDestroy")
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentMapBinding.inflate(inflater, container, false)
//        val view = binding.root
//        binding.composeView.apply {
//            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
//            setContent {
//                POPLETheme {
//                    MapRoute()
//                }
//            }
//        }
//        return view
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}