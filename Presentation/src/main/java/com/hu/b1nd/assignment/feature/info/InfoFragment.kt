package com.hu.b1nd.assignment.feature.info

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hu.b1nd.assignment.base.BaseFragment
import com.hu.b1nd.assignment.databinding.FragmentInfoBinding
import com.hu.b1nd.assignment.feature.info.InfoViewModel.Companion.ON_CLICK_BACK_ICON
import com.hu.b1nd.assignment.feature.info.InfoViewModel.Companion.ON_CLICK_SUBMIT
import com.hu.b1nd.assignment.utiles.shortToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment: BaseFragment<FragmentInfoBinding, InfoViewModel>() {

    override val viewModel: InfoViewModel by viewModels()
    private val args: InfoFragmentArgs by navArgs()

    override fun observerViewModel() {
        initScreen()
        bindingViewEvent { event ->
            when(event) {
                ON_CLICK_SUBMIT -> {
                    context?.shortToast("이 소식을 알릴게요!")
                }
                ON_CLICK_BACK_ICON -> findNavController().popBackStack()
            }
        }
    }
    private fun initScreen() {
        with(mBinding) {
            newThumbnail.setImageBitmap(args.thumbnail)
            newTitle.text = args.title
            newContent.text = args.content
            newAuthor.text = args.author
            newDate.text = args.date
        }
    }
}