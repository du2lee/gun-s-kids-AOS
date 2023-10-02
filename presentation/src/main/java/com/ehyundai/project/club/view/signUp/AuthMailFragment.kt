package com.ehyundai.project.club.view.signUp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.ehyundai.project.club.R
import com.ehyundai.project.club.base.BaseFragment
import com.ehyundai.project.club.databinding.FragmentAuthMailBinding

class AuthMailFragment : BaseFragment<FragmentAuthMailBinding>(R.layout.fragment_auth_mail) {
    private var parentActivity: SignUpActivity? = null
    private val viewModel: SignUpViewModel by activityViewModels()
    override val TAG: String = "AuthMailFragment"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = activity as SignUpActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        goSignUp()
    }

    override fun onDetach() {
        super.onDetach()
        parentActivity = null
    }

    private fun goSignUp(){
        binding.btnSignUp.setOnClickListener {
            if(parentActivity != null) parentActivity?.setFragment(1) }
    }

}