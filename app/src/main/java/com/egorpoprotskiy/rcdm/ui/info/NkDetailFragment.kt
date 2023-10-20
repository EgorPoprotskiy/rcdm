package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.databinding.FragmentNkDetailBinding

//46
class NkDetailFragment : Fragment() {
    //46 Объявление binding
    private var _binding: FragmentNkDetailBinding?= null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNkDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    // 51 Получение аргумента при навигации от InfoFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = arguments
        if (arguments != null && arguments.containsKey("nkHeading")) {
            val nkHeading = arguments.getString("nkHeading")
            binding?.nkHeadingView?.text = nkHeading
            when (nkHeading) {
                "Отступл 1" -> binding?.nkDescriptionView?.text = getString(R.string.nk_bag1_description)
                "Отступл 2" -> binding?.nkDescriptionView?.text = getString(R.string.nk_bag2_description)
                "Отступл 3" -> binding?.nkDescriptionView?.text = getString(R.string.nk_bag3_description)
                "Отступл 4" -> binding?.nkDescriptionView?.text = getString(R.string.nk_bag4_description)
            }
        }
    }
}