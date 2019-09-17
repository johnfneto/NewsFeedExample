package com.johnfneto.newsfeed.services

import NewsResponse
import androidx.lifecycle.MutableLiveData

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Factory {
    private val newsApi: NewsApi = Service().createService(NewsApi::class.java)

    fun getNews(source: String, key: String): MutableLiveData<NewsResponse> {
        val newsData = MutableLiveData<NewsResponse>()
        newsApi.getNewsList(source, key).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    newsData.value = response.body()
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                newsData.value = null
            }
        })
        return newsData
    }
}
