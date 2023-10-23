package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.databinding.FragmentInfoDetailBinding

class InfoDetailFragment : Fragment() {
    //56
    private var _binding: FragmentInfoDetailBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInfoDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = arguments
        if (arguments != null && arguments.containsKey("heading")) {
            val heading = arguments.getString("heading")
            binding?.headingView?.text = heading
            when (heading) {
                "АЛСН" -> binding?.descriptionView?.text = getString(R.string.alsn_description)
                "САУТ" -> binding?.descriptionView?.text = getString(R.string.saut_description)
                "КТСМ" -> binding?.descriptionView?.text = getString(R.string.ktsm_description)

                "Зигзаг" -> binding?.descriptionView?.text = getString(R.string.ks_zigzag_description)
                "Отступл 2" -> binding?.descriptionView?.text = getString(R.string.ks_bag2_description)

                "Отступл 1" -> binding?.descriptionView?.text = getString(R.string.nk_bag1_description)
                "Отступл 2" -> binding?.descriptionView?.text = getString(R.string.nk_bag2_description)
                "Отступл 3" -> binding?.descriptionView?.text = getString(R.string.nk_bag3_description)
                "Отступл 4" -> binding?.descriptionView?.text = getString(R.string.nk_bag4_description)

                "Уровень" -> binding?.descriptionView?.text = getString(R.string.uroven_description)
                "Перекос" -> binding?.descriptionView?.text = getString(R.string.perecos_description)
                "Угол в плане" -> binding?.descriptionView?.text = getString(R.string.rihtovka_description)
                "Шаблон" -> {
                    binding?.descriptionView?.text = getString(R.string.shablon_description)
                }
                "Просадка" -> binding?.descriptionView?.text = getString(R.string.prosadka_description)

                "Зазор" -> binding?.descriptionView?.text = getString(R.string.video_zazor_description)
                "Метка" -> binding?.descriptionView?.text = getString(R.string.video_mark_description)
                "Болты" -> binding?.descriptionView?.text = getString(R.string.video_bolt_description)
            }
        }
    }
}