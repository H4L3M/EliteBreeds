package com.elitebreeds.pigeonsdate.ui.add

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.elitebreeds.pigeonsdate.databinding.AddPigeonFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.core.app.ActivityCompat.startActivityForResult
import com.bumptech.glide.Glide

//hello 1.5M

class AddPigeonFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = AddPigeonFragment()
    }

    private lateinit var viewModel: AddPigeonViewModel
    private var _binding: AddPigeonFragmentBinding? = null
    private val binding get() = _binding!!

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val uri: Uri = result.data?.data!!
                Glide.with(requireActivity()).load(uri).into(binding.pigeonImage)
            }
        }

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                val intent = Intent()
                intent.type = "image/*"
                intent.action = Intent.ACTION_GET_CONTENT
                resultLauncher.launch(intent)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AddPigeonFragmentBinding.inflate(inflater, container, false)

        val root = binding.root

        binding.pigeonImage.setOnClickListener {
            requestPermission.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddPigeonViewModel::class.java)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}