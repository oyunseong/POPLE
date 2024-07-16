package com.verywords.app.feature.map

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.verywords.app.core.designsystem.theme.POPLETheme
import com.verywords.app.feature.map.databinding.FragmentMapBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MapFragment : Fragment() {
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<MapViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("++##", "MapFragment onCreateView")
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val view = binding.root

        lifecycleScope.launch {
            viewModel.uiState.collectLatest {
                binding.webView.loadUrl(it.currentUrl)
            }
        }

        initWebView()

        binding.composeView.apply {
            setContent {
                val uiState by viewModel.uiState.collectAsState()
                val html by viewModel.currentPageHtml.collectAsState()
                POPLETheme {
                    HtmlViewer(
                        html = html,
                        isVisible = uiState.isVisibleHtmlViewer,
                        onClickFloating = {
                            viewModel.toggleHtmlViewer()
                        },
                        onChange = {

                        }
                    )
                }
            }
        }
        return view
    }

    private fun initWebView() {
        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    Log.d("++##", "onPageFinished url : $url")
                    view?.loadUrl("javascript:window.Android.getHtml(document.getElementsByTagName('html')[0].innerHTML);")
//                    view?.loadUrl("javascript:window.Android.getHtml(document.body.innerHTML);")
                }
            }
            addJavascriptInterface(viewModel.MapJavascriptInterface(), "Android")
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}