package com.egorpoprotskiy.rcdm.ui.easd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.egorpoprotskiy.rcdm.adapter.ExpandableListAdapter
import com.egorpoprotskiy.rcdm.data.EasdChapterDataSource
import com.egorpoprotskiy.rcdm.databinding.FragmentEasdBinding
import com.egorpoprotskiy.rcdm.model.EasdChapter

//50
class EasdFragment : Fragment() {

    private var _binding: FragmentEasdBinding? = null
    private val binding get() = _binding!!

    private lateinit var listViewAdapter: ExpandableListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEasdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chapters = EasdChapterDataSource(requireContext()).loadEasdChapterDataSource()
        listViewAdapter = ExpandableListAdapter(requireContext(), chapters)
        binding.expandableListViewEasd.setAdapter(listViewAdapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}