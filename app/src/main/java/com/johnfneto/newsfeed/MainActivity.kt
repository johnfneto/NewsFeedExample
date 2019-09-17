package com.johnfneto.newsfeed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.johnfneto.newsfeed.adapters.CustomOnClickListener
import com.johnfneto.newsfeed.databinding.MainActivityBinding
import com.johnfneto.newsfeed.ui.main.DetailFragment
import com.johnfneto.newsfeed.ui.main.MainFragment

class MainActivity : AppCompatActivity(), CustomOnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val binding: MainActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commit()
        }
    }

    fun showDetailFragment(url: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DetailFragment.newInstance(url))
            .commit()
    }

    override fun onItemClick(position: Int, mainFragment: MainFragment) {
        mainFragment.displayDetailFragment(position)
    }
}
