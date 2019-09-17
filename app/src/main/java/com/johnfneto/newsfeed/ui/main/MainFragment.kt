package com.johnfneto.newsfeed.ui.main

import com.johnfneto.newsfeed.models.Articles
import NewsResponse
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.johnfneto.newsfeed.MainActivity
import com.johnfneto.newsfeed.R
import com.johnfneto.newsfeed.adapters.ArticleAdapter
import com.johnfneto.newsfeed.databinding.MainFragmentBinding

class MainFragment: Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding : MainFragmentBinding
    private lateinit var viewModel: NewsViewModel
    private var articlesList: ArrayList<Articles> = ArrayList()
    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel.init()
        viewModel.getNews()?.observe(this, Observer { processNews(it) })
        setupRecyclerView()
    }

    private fun processNews(newsResponse: NewsResponse?) {
        val newsArticles = newsResponse?.articles
        newsArticles?.let { articlesList.addAll(it) }
        binding.newsList.adapter?.notifyDataSetChanged()
    }

    private fun setupRecyclerView() {
        if (::articleAdapter.isInitialized) {
            articleAdapter.notifyDataSetChanged()
        } else {
            articleAdapter = ArticleAdapter(activity, articlesList, this)
            binding.newsList.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = articleAdapter
                itemAnimator = DefaultItemAnimator()
                isNestedScrollingEnabled = true
            }
        }
    }

    fun displayDetailFragment(position: Int) {
        (activity as MainActivity).showDetailFragment(articlesList[position].url)
    }
}
