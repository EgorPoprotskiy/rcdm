package com.egorpoprotskiy.rcdm.ui.easd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.egorpoprotskiy.rcdm.databinding.FragmentEasdBinding

class EasdFragment : Fragment() {

    private var _binding: FragmentEasdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val easdViewModel =
            ViewModelProvider(this).get(EasdViewModel::class.java)

        _binding = FragmentEasdBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textEasd
        easdViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}