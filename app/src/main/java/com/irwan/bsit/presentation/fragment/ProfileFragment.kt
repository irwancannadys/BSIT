package com.irwan.bsit.presentation.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.irwan.bsit.R
import com.irwan.bsit.databinding.FragmentProfileBinding
import com.irwan.bsit.model.ProfileResponse
import com.irwan.bsit.presentation.fragment.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    val binding get() = _binding

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return requireNotNull(binding?.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        viewModel.getProfile()
    }

    private fun observeViewModel() {
        viewModel.profile.observe(viewLifecycleOwner) {
            initViewProfile(it)
        }
    }

    private fun initViewProfile(data: ProfileResponse) {
        binding?.ivProfile?.let {
            Glide
                .with(context ?: return)
                .load(data.imageUrl)
                .centerCrop()
                .into(it)
        }
        binding?.tvName?.text = data.name
        binding?.tvJoinedDate?.text = data.joinedDate
        binding?.tvStatus?.text = if (data.status == 1)
            getString(R.string.available_title) else getString(R.string.not_available_title)
        binding?.tvPhoneNumber?.text = data.noTelp

        binding?.cardLocation?.setOnClickListener {
            seeLocation(data.lat.toString(), data.lng.toString())
        }
    }

    private fun seeLocation(lat : String, lng: String)  {
        val uri = Uri.parse("https://www.google.com/maps/search/?api=1&query=$lat,%20$lng")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context?.startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}