package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.databinding.FragmentInfoDetailBinding
import kotlin.coroutines.coroutineContext

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
                getString(R.string.alsn_heading) -> binding?.descriptionView?.text = getString(R.string.alsn_description)
                getString(R.string.saut_heading) -> binding?.descriptionView?.text = getString(R.string.saut_description)
                getString(R.string.ktsm_heading) -> binding?.descriptionView?.text = getString(R.string.ktsm_description)

                getString(R.string.ks_zigzag_heading) -> binding?.descriptionView?.text = getString(R.string.ks_zigzag_description)
                getString(R.string.ks_bag2_heading) -> binding?.descriptionView?.text = getString(R.string.ks_bag2_description)

                getString(R.string.nk_bag1_heading) -> binding?.descriptionView?.text = getString(R.string.nk_bag1_description)
                getString(R.string.nk_bag2_heading) -> binding?.descriptionView?.text = getString(R.string.nk_bag2_description)
                getString(R.string.nk_bag3_heading) -> binding?.descriptionView?.text = getString(R.string.nk_bag3_description)
                getString(R.string.nk_bag4_heading) -> binding?.descriptionView?.text = getString(R.string.nk_bag4_description)

                getString(R.string.uroven_heading) -> binding?.descriptionView?.text = getString(R.string.uroven_description)
                getString(R.string.perecos_heading) -> binding?.descriptionView?.text = getString(R.string.perecos_description)
                getString(R.string.rihtovka_heading) -> binding?.descriptionView?.text = getString(R.string.rihtovka_description)
                getString(R.string.shablon_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.ushirenie_sushenie)
                    binding?.descriptionView?.text = getString(R.string.shablon_description)
                }
                getString(R.string.prosadka_heading) -> binding?.descriptionView?.text = getString(R.string.prosadka_description)

                getString(R.string.video_zazor_heading) -> binding?.descriptionView?.text = getString(R.string.video_zazor_description)
                getString(R.string.video_mark_heading) -> binding?.descriptionView?.text = getString(R.string.video_mark_description)
                getString(R.string.video_bolt_heading) -> binding?.descriptionView?.text = getString(R.string.video_bolt_description)
                getString(R.string.video_nakladka_heading) -> binding?.descriptionView?.text = getString(R.string.video_nakladka_description)
                getString(R.string.video_skrepleniya_heading) -> binding?.descriptionView?.text = getString(R.string.video_skrepleniya_description)
                getString(R.string.video_shpali_heading) -> binding?.ivDescriptionView?.setImageResource(R.drawable.shpaly)
            }
        }
    }
}

