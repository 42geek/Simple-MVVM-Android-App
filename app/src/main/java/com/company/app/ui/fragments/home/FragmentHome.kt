package com.company.app.ui.fragments.home

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.app.R
import com.company.app.appbase.injection.AppComponent
import com.company.app.data.apis.github.model.GithubRepo
import com.company.app.databinding.FragmentHomeBinding
import com.company.app.ui.fragments.base.BaseFragment
import com.company.app.ui.fragments.home.di.FragmentHomeModule
import javax.inject.Inject


class FragmentHome: BaseFragment<FragmentHomeBinding>(false) {

    @Inject
    internal lateinit var viewModel: FragmentHomeViewModel

    private val reposRecyclerViewData = mutableListOf<GithubRepo>()
    private lateinit var reposRecyclerViewAdapter: ReposRecyclerViewAdapter

    /**
     * Android lifecycle and super class functions:
     */
    override fun getToolbarView(): View? {
        return null
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(FragmentHomeModule()).inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initFragmentViews() {
        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        getData(0)
    }




    /**
     * Private functions:
     */
    private fun initRecyclerView() {
        dataBinding.reposRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        reposRecyclerViewAdapter = ReposRecyclerViewAdapter(requireContext(), reposRecyclerViewData, getReposRecyclerViewListener())
        dataBinding.reposRecyclerView.adapter = reposRecyclerViewAdapter
    }

    private fun getData(lastRepoId: Int) {
        viewModel.getGitDataFromRepository(lastRepoId).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                updateRepoRecyclerViewWithNewData(it)
            } else {
                Toast.makeText(requireContext(), "Failed to load new data!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateRepoRecyclerViewWithNewData(data: List<GithubRepo>) {
        reposRecyclerViewData.addAll(data)
        reposRecyclerViewAdapter.notifyDataSetChanged()
    }

    private fun getReposRecyclerViewListener(): ReposRecyclerViewAdapter.ReposRecyclerViewListener {
        return object: ReposRecyclerViewAdapter.ReposRecyclerViewListener{
            override fun loadMoreData(lastRepoId: Int) {
                //The +1 is to make sure to not get the last item in the list again.
                getData(lastRepoId + 1)
            }

            override fun onItemClicked(githubRepo: GithubRepo) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(githubRepo.htmlUrl)
                startActivity(intent)
            }
        }
    }
}