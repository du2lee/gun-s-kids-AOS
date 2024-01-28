package com.ehyundai.project.club.view.club

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ehyundai.project.club.view.myclub.MyClubFragment
import com.ehyundai.project.club.view.profile.ProfileFragment
import com.ehyundai.project.club.view.search.SearchFragment


class ViewPager2Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> BoardFragment()
            2 -> DateFragment()
            3 -> ChatFragment()
            else -> MyClubFragment()
        }
    }

    override fun getItemCount(): Int {
        return 4 // 페이지 수
    }
}