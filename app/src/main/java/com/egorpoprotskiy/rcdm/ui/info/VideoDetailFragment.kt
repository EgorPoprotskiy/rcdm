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

    //51 Получение аргумента для Видео от IndoFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = arguments
        if (arguments != null && arguments.containsKey("videoHeading")) {
            val videoHeading = arguments.getString("videoHeading")
            binding?.videoHeadingView?.text = videoHeading
            when (videoHeading) {
                "Зазор" -> binding?.videoDescriptionView?.text = getString(R.string.video_zazor_description)
                "Метка" -> binding?.videoDescriptionView?.text = getString(R.string.video_mark_description)
                "Болты" -> binding?.videoDescriptionView?.text = getString(R.string.video_bolt_description)
            }
        }
    }
}