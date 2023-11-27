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
//СЦБ
                getString(R.string.alsn_interval_heading) -> binding?.descriptionView?.text = getString(R.string.alsn_interval_description)
                getString(R.string.alsn_tok_post_heading) -> binding?.descriptionView?.text = getString(R.string.alsn_tok_post_description)
                getString(R.string.alsn_tok_per_heading) -> binding?.descriptionView?.text = getString(R.string.alsn_tok_per_description)
                getString(R.string.alsn_tok_auto_heading) -> binding?.descriptionView?.text = getString(R.string.alsn_tok_auto_description)
                getString(R.string.alsen_tok_heading) -> binding?.descriptionView?.text = getString(R.string.alsen_tok_description)
                getString(R.string.pam_heading) -> binding?.descriptionView?.text = getString(R.string.pam_description)
                getString(R.string.saut_heading) -> binding?.descriptionView?.text = getString(R.string.saut_description)
                getString(R.string.ktsm_heading) -> binding?.descriptionView?.text = getString(R.string.ktsm_description)
                getString(R.string.ktsm_pkl_heading) -> binding?.descriptionView?.text = getString(R.string.ktsm_pkl_description)
// Контактная сеть
                getString(R.string.ks_zigzag_heading) -> binding?.descriptionView?.text = getString(R.string.ks_zigzag_description)
                getString(R.string.ks_bag2_heading) -> binding?.descriptionView?.text = getString(R.string.ks_bag2_description)
//Дефектоскопия
                getString(R.string.nk_bag1_heading) -> binding?.descriptionView?.text = getString(R.string.nk_bag1_description)
                getString(R.string.nk_bag2_heading) -> binding?.descriptionView?.text = getString(R.string.nk_bag2_description)
                getString(R.string.nk_bag3_heading) -> binding?.descriptionView?.text = getString(R.string.nk_bag3_description)
                getString(R.string.nk_bag4_heading) -> binding?.descriptionView?.text = getString(R.string.nk_bag4_description)
//Путеизмерение
                getString(R.string.shirina_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.ushirenie_sushenie)
                    binding?.descriptionView?.text = getString(R.string.shirina_description)
                }
                getString(R.string.oshk_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.oshk)
                    binding?.descriptionView?.text = getString(R.string.oshk_description)
                }
                getString(R.string.uroven_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.uroven)
                    binding?.descriptionView?.text = getString(R.string.uroven_description)
                }
                getString(R.string.perecos_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.perekos)
                    binding?.descriptionView?.text = getString(R.string.perecos_description)
                }
                getString(R.string.prosadka_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.prosadka)
                    binding?.descriptionView?.text = getString(R.string.prosadka_description)
                }
                getString(R.string.rihtovka_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.rihtovka)
                    binding?.descriptionView?.text = getString(R.string.rihtovka_description)
                }
                getString(R.string.sochetaniya_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.sochetaniya)
                    binding?.descriptionView?.text = getString(R.string.sochetaniya_description)
                }
                getString(R.string.prosadka_is_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.prosadkais)
                }
                getString(R.string.most_and_tonnel_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.mostandtonnel)
                    binding?.descriptionView?.text = getString(R.string.most_and_tonnel_description)
                }
                getString(R.string.bi_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.bi)
                    binding?.descriptionView?.text = getString(R.string.bi_description)
                }
                getString(R.string.dl_nerovnosti_heading) -> {
                    binding?.descriptionView?.text = getString(R.string.dl_nerovnosti_description)
                }
                getString(R.string.ocenka_km_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.ocenka_km)
                }
                getString(R.string.ocenka_uch_heading) -> {
                    binding?.ivDescriptionView?.setImageResource(R.drawable.ocenka_uch)
                }

//Видеоконтроль
                getString(R.string.video_zazor_heading) -> {
                    binding?.descriptionView?.text = getString(R.string.video_zazor_description)
                }
                getString(R.string.video_mark_heading) -> binding?.descriptionView?.text = getString(R.string.video_mark_description)
                getString(R.string.video_bolt_heading) -> binding?.descriptionView?.text = getString(R.string.video_bolt_description)
                getString(R.string.video_nakladka_heading) -> binding?.descriptionView?.text = getString(R.string.video_nakladka_description)
                getString(R.string.video_skrepleniya_heading) -> binding?.descriptionView?.text = getString(R.string.video_skrepleniya_description)
                getString(R.string.video_shpali_heading) -> binding?.ivDescriptionView?.setImageResource(R.drawable.shpaly)
            }
        }
    }
}

