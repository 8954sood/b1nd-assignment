package com.hu.b1nd.assignment.feature.create

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.graphics.decodeBitmap
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hu.b1nd.assignment.R
import com.hu.b1nd.assignment.base.BaseFragment
import com.hu.b1nd.assignment.databinding.FragmentNewBinding
import com.hu.b1nd.assignment.databinding.ListHomeBinding
import com.hu.b1nd.assignment.feature.create.CreateViewModel.Companion.EVENT_CREATE_FAILED
import com.hu.b1nd.assignment.feature.create.CreateViewModel.Companion.EVENT_CREATE_SUCCESS
import com.hu.b1nd.assignment.feature.create.CreateViewModel.Companion.ON_CLICK_IMAGE
import com.hu.b1nd.assignment.feature.create.CreateViewModel.Companion.ON_CLICK_SUBMIT
import com.hu.b1nd.assignment.utiles.shortToast
import com.hu.b1nd.domain.model.ListHome
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.IOException

@AndroidEntryPoint
class CreateFragment: BaseFragment<FragmentNewBinding, CreateViewModel>() {
    override val viewModel: CreateViewModel by viewModels()

    private lateinit var thumbnail: Bitmap

    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                ON_CLICK_SUBMIT -> {
                    with(mBinding) {
                        if (newEditAuthor.text?.isEmpty() == true) { return@bindingViewEvent }
                        if (newEditTitle.text?.isEmpty() == true) { return@bindingViewEvent }
                        if (newEditContent.text?.isEmpty() == true) { return@bindingViewEvent }
                        if (thumbnail == null) { return@bindingViewEvent }
                        viewModel.createLost(
                            thumbnail = thumbnail,
                            title =newEditTitle.text.toString(),
                            content = newEditContent.text.toString(),
                            author = newEditAuthor.text.toString()
                        )
                    }
                }
                ON_CLICK_IMAGE -> {
                    startGallery()
                    Log.d("TAG", "observerViewModel: called")
                }
                EVENT_CREATE_SUCCESS -> {
                    context?.shortToast("분실물을 등록했어요!")
                    findNavController().navigate(R.id.action_createFragment_to_homeFragment)
                }
                EVENT_CREATE_FAILED -> {
                    context?.shortToast("분실물을 등록에 실패했어요.")
                    findNavController().navigate(R.id.action_createFragment_to_homeFragment)
                }
            }
        }
    }

    private fun startGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startForResult.launch(intent)
    }


    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {

            val imageUri: Uri = it.data?.data ?: return@registerForActivityResult
            val bitmap = try{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    ImageDecoder.decodeBitmap(ImageDecoder.createSource(requireContext().contentResolver, imageUri))
                } else {
                    MediaStore.Images.Media.getBitmap(requireContext().contentResolver, imageUri)
                }
            } catch (e: IOException) {
                e.printStackTrace()
                return@registerForActivityResult
            }
            thumbnail = bitmap
            Log.d("TAG", ": $bitmap")
            setImage(bitmap = bitmap)
        }
    }

    private fun setImage(bitmap: Bitmap?) {
        mBinding.newEditThumbnail.setImageBitmap(bitmap)
    }

}