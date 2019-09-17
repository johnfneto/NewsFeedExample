package com.johnfneto.newsfeed.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.johnfneto.newsfeed.R
import com.johnfneto.newsfeed.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding

    companion object {
        private lateinit var url: String

        fun newInstance(url: String): DetailFragment {
            this.url = url
            return DetailFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
            binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)
            return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.apply {
            webView.loadUrl(url)
        }
    }
}
