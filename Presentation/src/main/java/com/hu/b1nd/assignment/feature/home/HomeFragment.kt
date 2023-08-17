package com.hu.b1nd.assignment.feature.home

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.Layout.Directions
import android.util.Log
import android.widget.LinearLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hu.b1nd.assignment.R
import com.hu.b1nd.assignment.base.BaseFragment
import com.hu.b1nd.assignment.databinding.FragmentHomeBinding
import com.hu.b1nd.assignment.feature.home.HomeViewModel.Companion.ON_CLICK_ADD
import com.hu.b1nd.assignment.utiles.shortToast
import com.hu.b1nd.assignment.utiles.toBitmap
import com.hu.b1nd.domain.model.ListHome
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: ListHomeAdapter
    override fun observerViewModel() {
        initRecyclerView(listOf())
        collectGetAllHomeState()

        bindingViewEvent { event ->
            when (event) {
                ON_CLICK_ADD -> findNavController().navigate(R.id.action_homeFragment_to_createFragment)
            }
        }

    }
    private fun initRecyclerView(list: List<ListHome>) {
        adapter = ListHomeAdapter(list) {

        }
        with(mBinding) {
            homeRv.adapter = adapter
            homeRv.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LOG", "onCreate: 콜")
    }

    override fun onStart() {
        super.onStart()
        viewModel.getLostList(ContextCompat.getDrawable(requireContext(), R.drawable.iu)!!.toBitmap())
    }


    private fun collectGetAllHomeState() = lifecycleScope.launchWhenStarted {
        viewModel.getAllHomeState.collect { state ->
            adapter = ListHomeAdapter(state.list) {
                val navigate = HomeFragmentDirections.actionHomeFragmentToInfoFragment(
                    it.title!!, it.content!!, it.author!!, it.date!!, it.thumbnail!!
                )
                findNavController().navigate(navigate)
            }
            with(mBinding) {
                homeRv.adapter = adapter
                homeRv.layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

}