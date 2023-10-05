package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.databinding.FragmentPsDetailBinding


class PsDetailFragment : Fragment() {
    //41
    private var _binding: FragmentPsDetailBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPsDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding?.root
    }

//    41 Получение аргумента от ПС
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = arguments
        if (arguments != null && arguments.containsKey("psHeading")) {
            val psHeading = arguments.getString("psHeading")
            binding?.psHeadingView?.text = psHeading
            when (psHeading) {
                "Уровень" -> binding?.psDescriptionView?.text = getString(R.string.uroven_description)
                "Перекос" -> binding?.psDescriptionView?.text = getString(R.string.perecos_description)
                "Угол в плане" -> binding?.psDescriptionView?.text = getString(R.string.rihtovka_description)
                "Шаблон" -> binding?.psDescriptionView?.text = getString(R.string.shablon_description)
                "Просадка" -> binding?.psDescriptionView?.text = getString(R.string.prosadka_description)
            }
        }
    }
}