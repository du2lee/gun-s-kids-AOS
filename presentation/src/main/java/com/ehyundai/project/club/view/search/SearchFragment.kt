package com.ehyundai.project.club.view.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.viewModels
import com.ehyundai.project.club.R
import com.ehyundai.project.club.base.BaseFragment
import com.ehyundai.project.club.databinding.FragmentSearchBinding
import com.ehyundai.project.club.view.Club
import com.ehyundai.project.club.view.ClubAdapter
import com.ehyundai.project.club.view.club.ClubActivity
import com.ehyundai.project.club.view.main.MainActivity

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private var parentActivity: MainActivity? = null
    private val viewModel: SearchViewModel by viewModels()
    override val TAG: String = "SearchFragment"

    lateinit var context: MainActivity

    /** dummy Data -> API 생성 시 삭제 */

    var groupList = arrayListOf<Club>(
        Club(R.drawable.ic_shinchan, "슛솔랭", "2022.10.10", "안녕하세요"),
        Club(R.drawable.ic_shinchan, "스뚝파", "2022.10.16", "안녕하세요"),
        Club(R.drawable.ic_shinchan, "러닝", "2011.09.10", "안녕하세요"),
        Club(R.drawable.ic_shinchan, "자바락", "2022.11.04", "안녕하세요"),
        Club(R.drawable.ic_shinchan, "밴드", "2022.11.04", "안녕하세요"),
        Club(R.drawable.ic_shinchan, "뀨르", "2022.11.04", "안녕하세요"),
    )

    /** dummy Data -> API 생성 시 삭제 */

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = activity as MainActivity
        this.context = context as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 0 until 10){
            val view = LayoutInflater.from(context).inflate(R.layout.item_company_view, null)
            binding.llSortCompany.addView(view)
        }
        val adapter = ClubAdapter(context, groupList)
        binding.lvClub.adapter = adapter

        binding.lvClub.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            val item = groupList.get(position)

            val intent = Intent(context, ClubActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("date", item.date)
            startActivity(intent)
        }

        binding.viewModel = viewModel
    }

    override fun onDetach() {
        super.onDetach()
        parentActivity = null
    }
}