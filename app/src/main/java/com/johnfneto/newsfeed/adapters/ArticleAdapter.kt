package com.johnfneto.newsfeed.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.johnfneto.newsfeed.MainActivity
import com.johnfneto.newsfeed.R
import com.johnfneto.newsfeed.databinding.NewsItemBinding
import com.johnfneto.newsfeed.models.Articles
import com.johnfneto.newsfeed.ui.main.MainFragment
import com.squareup.picasso.Picasso

class ArticleAdapter(
    private val activity: FragmentActivity?,
    private val articlesList: ArrayList<Articles>,
    private val mainFragment: MainFragment
)
    : RecyclerView.Adapter<ArticleAdapter.DataBindingViewHolder>() {

    private lateinit var binding: NewsItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(inflater, R.layout.news_item, parent, false)
        return DataBindingViewHolder(binding)
    }

    override fun getItemCount() = articlesList.size

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        holder.bind(articlesList[position])
    }

    inner class DataBindingViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Articles) {
            binding.article = item
            Picasso.get().load(item.urlToImage).into(binding.ivNews)
            binding.relativeLayout.setOnClickListener {
                (activity as MainActivity).onItemClick(adapterPosition, mainFragment)
            }
        }
    }
}