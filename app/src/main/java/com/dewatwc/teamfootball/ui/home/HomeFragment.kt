package com.dewatwc.teamfootball.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.dewatwc.teamfootball.R
import com.dewatwc.teamfootball.core.data.Resource
import com.dewatwc.teamfootball.core.ui.TeamAdapter
import com.dewatwc.teamfootball.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_error.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val teamAdapter = TeamAdapter()
            teamAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.team.observe(viewLifecycleOwner, {
                if (it != null) {
                    when (it) {
                        is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            progress_bar.visibility = View.GONE
                            teamAdapter.setData(it.data)
                        }
                        is Resource.Error -> {
                           progress_bar.visibility = View.GONE
                            view_error.visibility = View.VISIBLE
                            view_error.tv_error.text = it.message ?: getString(R.string.data_error)

                        }
                    }
                }
            })

            with(rv_home){
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = teamAdapter
            }
        }
    }
}