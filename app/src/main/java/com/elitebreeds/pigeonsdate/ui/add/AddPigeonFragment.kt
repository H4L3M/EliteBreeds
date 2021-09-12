package com.elitebreeds.pigeonsdate.ui.add

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.elitebreeds.pigeonsdate.databinding.AddPigeonFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.core.app.ActivityCompat.startActivityForResult
import com.bumptech.glide.Glide
import com.elitebreeds.pigeonsdate.R

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

    private var TYPES = listOf("Voiyageur", "Khinissi", "3anbar", "Tawssi Indian")

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

        val items = listOf(
            "Tippler",
            "Jacobin",
            "Roller",
            "Fantail",
            "Pouter",
            "English Carrier",
            "Old German Owl",
            "Chinese Own",
            "Homing",
            "Racing Pigeon",
            "Frill Back",
            "Helmet",
            "Dragoon",
            "Nun",
            "Modena",
            "Lahore",
            "Satinette",
            "Swift",
            "Indian Gola",
            "African Owl",
            "Archangel",
            "Armenian Tumbler",
            "Carneau",
            "Coburg Lark",
            "Damascene",
            "Ice Pigeon",
            "Lucerne Gold Collar",
            "Ukrainian Skycutter",
            "Saxon Shield",
            "Serbian Highflyer")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
        (binding.pigeonType.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        val items2 = listOf(
            "2014",
            "2015",
            "2016",
            "2017",
            "2018",
            "2019",
            "2020",
            "2021",
            "2022",
        )
        val adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items2)
        (binding.pigeonBirth.editText as? AutoCompleteTextView)?.setAdapter(adapter2)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

