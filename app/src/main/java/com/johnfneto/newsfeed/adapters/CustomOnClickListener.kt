package com.johnfneto.newsfeed.adapters

import com.johnfneto.newsfeed.ui.main.MainFragment

interface CustomOnClickListener {
    fun onItemClick(position: Int, mainFragment: MainFragment)
}
