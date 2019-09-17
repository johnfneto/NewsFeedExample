package com.johnfneto.newsfeed.ui.main

import androidx.lifecycle.ViewModel
import NewsResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.johnfneto.newsfeed.services.Factory

class NewsViewModel : ViewModel() {
    private var mutableLiveData: MutableLiveData<NewsResponse>? = null
    private var newsFactory: Factory? = null

    fun init() {
        if (mutableLiveData != null) {
            return
        }
        newsFactory = Factory
        mutableLiveData = newsFactory!!.getNews("google-news", "aedc86b833e3463aab906de1033d19a9")
    }

    fun getNews(): LiveData<NewsResponse>? {
        return mutableLiveData
    }
}
