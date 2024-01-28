package com.ehyundai.project.club.view.club

import android.os.Bundle
import com.ehyundai.project.club.R
import com.ehyundai.project.club.base.BaseActivity
import com.ehyundai.project.club.databinding.ActivityClubBinding
import com.ehyundai.project.club.view.club.ViewPager2Adapter
import com.google.android.material.tabs.TabLayoutMediator

class ClubActivity : BaseActivity<ActivityClubBinding>(R.layout.activity_club) {
    override val TAG: String = "ClubActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.tvClubTitle.text = intent.getStringExtra("name")
        binding.tvClubSubtitle.text = "Since " + intent.getStringExtra("date")

        binding.vpClub.adapter = ViewPager2Adapter(supportFragmentManager, lifecycle)
        drawTabLayout()
    }

    private fun drawTabLayout() {
        // connect ViewPager2
        TabLayoutMediator(binding.tlClub, binding.vpClub) { _, _ -> }.attach()

        // set tabIcon
        binding.tlClub.getTabAt(0)!!.setText("홈")
        binding.tlClub.getTabAt(1)!!.setText("게시판")
        binding.tlClub.getTabAt(2)!!.setText("일정")
        binding.tlClub.getTabAt(3)!!.setText("채팅")
    }
}