package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.databinding.FragmentVideoDetailBinding

//46
class VideoDetailFragment : Fragment() {
    //46 Объявление binding
    private var _binding: FragmentVideoDetailBinding?= null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideoDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }
}