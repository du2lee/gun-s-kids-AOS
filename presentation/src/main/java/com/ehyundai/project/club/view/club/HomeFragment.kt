package com.ehyundai.project.club.view.club

import android.content.Context
import android.os.Bundle
import android.view.View
import com.ehyundai.project.club.R
import com.ehyundai.project.club.base.BaseFragment
import com.ehyundai.project.club.databinding.FragmentSearchBinding

class HomeFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_home) {
    private var parentActivity: ClubActivity? = null
//    private val viewModel: SearchViewModel by viewModels()
    override val TAG: String = "HomeFragment"

    lateinit var context: ClubActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = activity as ClubActivity
        this.context = context as ClubActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.viewModel = viewModel
    }

    override fun onDetach() {
        super.onDetach()
        parentActivity = null
    }
}