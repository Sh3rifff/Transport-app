package com.sharif.transportapp.view.mainView

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sharif.transportapp.R
import com.sharif.transportapp.databinding.FragmentNewAdsBinding

class NewAdsFragment : Fragment(R.layout.fragment_new_ads) {

    private lateinit var binding: FragmentNewAdsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewAdsBinding.bind(view)
    }

}