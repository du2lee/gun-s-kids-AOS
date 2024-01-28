package com.ehyundai.project.club.view.club

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import com.ehyundai.project.club.R
import com.ehyundai.project.club.base.BaseFragment
import com.ehyundai.project.club.databinding.FragmentSearchBinding
import com.ehyundai.project.club.view.Club
import com.ehyundai.project.club.view.ClubAdapter
import com.ehyundai.project.club.view.main.MainActivity

class BoardFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_board) {
    private var parentActivity: ClubActivity? = null
    //    private val viewModel: SearchViewModel by viewModels()
    override val TAG: String = "BoardFragment"

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