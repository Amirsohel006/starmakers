package com.starmakers.app.modules.studiobookong1.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.starmakers.app.R
import com.starmakers.app.appcomponents.di.MyApp
import com.starmakers.app.modules.studiobookong.ui.StudioBookongFragment
import com.starmakers.app.modules.studiobookongone.ui.StudioBookongOneFragment
import com.starmakers.app.modules.studiobookongtwo.ui.StudioBookongTwoFragment
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class StudioBookong1ActivityPagerAdapter(
    val fragmentManager: FragmentManager,
    val lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = viewPages.size

    override fun createFragment(position: Int): Fragment = viewPages[position]

    companion object AdapterConstant {
        val title: List<String> =
                listOf(MyApp.getInstance().resources.getString(R.string.lbl_editing_dubbing),MyApp.getInstance().resources.getString(R.string.msg_music_recordin),MyApp.getInstance().resources.getString(R.string.msg_house_location))

        val viewPages: List<Fragment> =
                listOf(StudioBookongFragment(),StudioBookongOneFragment(),StudioBookongTwoFragment())

    }
}
