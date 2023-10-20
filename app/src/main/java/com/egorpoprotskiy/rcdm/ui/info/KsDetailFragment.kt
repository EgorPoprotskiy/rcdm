package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.databinding.FragmentKsDetailBinding
//46
class KsDetailFragment : Fragment() {
    //46 Объявление binding
    private var _binding: FragmentKsDetailBinding?=null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKsDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    //51 Получение аргумента
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = arguments
        if (arguments != null && arguments.containsKey("ksHeading")) {
            val nkHeading = arguments.getString("ksHeading")
            binding?.ksHeadingView?.text = nkHeading
            when (nkHeading) {
                "Зигзаг" -> binding?.ksDescriptionView?.text = getString(R.string.ks_zigzag_description)
                "Отступл 2" -> binding?.ksDescriptionView?.text = getString(R.string.ks_bag2_description)
            }

        }
    }
}