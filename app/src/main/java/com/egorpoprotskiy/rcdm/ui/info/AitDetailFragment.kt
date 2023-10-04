package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.navArgs
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.data.AitDataSource
import com.egorpoprotskiy.rcdm.databinding.FragmentAitDetailBinding
import com.egorpoprotskiy.rcdm.model.Ait

//32
class AitDetailFragment : Fragment() {
    // 32 Объявление binding
    private var _binding: FragmentAitDetailBinding? = null
    private val binding get() = _binding
    //32 Объявление переменной navArgs(). Аргументы должны присутствовать в nav_graph этих фрагментов
    private val navigationArgs: AitDetailFragmentArgs by navArgs()
    //32 Привязка данных к TextView
    lateinit var ait: Ait
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAitDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //34
        val arguments = arguments
        if (arguments != null && arguments.containsKey("aitHeading")) {
            val aitHeading = arguments.getString("aitHeading")
            binding?.aitHeadingView?.text = aitHeading
        }
    }
}