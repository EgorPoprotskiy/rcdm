package com.egorpoprotskiy.rcdm.ui.easd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.egorpoprotskiy.rcdm.adapter.ExpandableListAdapter
import com.egorpoprotskiy.rcdm.data.EasdGroupeDataSource
import com.egorpoprotskiy.rcdm.databinding.FragmentEasdBinding
//50
class EasdFragment : Fragment() {

    private var _binding: FragmentEasdBinding? = null
    private val binding get() = _binding!!

    private lateinit var listViewAdapter: ExpandableListAdapter
    private lateinit var chapterlist: List<String>
    private lateinit var topicList: HashMap<String, List<String>>
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
//        val groups = EasdGroupeDataSource(requireContext()).loadEasdGroupDataSource()
//        val groups1 = listOf<String>("Group1", "Group2", "Group3")
//        val childItems = listOf(
//            listOf("1.1", "1.2", "1.3"),
//            listOf("2.1", "2.2", "2.3"),
//            listOf("3.1", "3.2", "3.3"),
//            listOf("3.1", "3.2", "3.3"),
//            listOf("3.1", "3.2", "3.3"),
//
//        )
//        val adapter = ExpandableListAdapter(requireContext(), groups, childItems)
//        binding.expandableListViewEasd.setAdapter(adapter)
        showList()
        listViewAdapter = ExpandableListAdapter(requireContext(), chapterlist, topicList)
        binding.expandableListViewEasd.setAdapter(listViewAdapter)
    }

    private fun showList() {
        chapterlist = ArrayList()
        topicList = HashMap()
        (chapterlist as ArrayList<String>).add("Chapter 1")
        (chapterlist as ArrayList<String>).add("Chapter 2")
        (chapterlist as ArrayList<String>).add("Chapter 3")
        (chapterlist as ArrayList<String>).add("Chapter 4")

        val topic1 : MutableList<String> = ArrayList()
        topic1.add("Topic 1")
        topic1.add("Topic 2")
        topic1.add("Topic 3")

        val topic2 : MutableList<String> = ArrayList()
        topic2.add("Topic 1")
        topic2.add("Topic 2")
        topic2.add("Topic 3")

        val topic3 : MutableList<String> = ArrayList()
        topic3.add("Topic 1")
        topic3.add("Topic 2")
        topic3.add("Topic 3")

        val topic4 : MutableList<String> = ArrayList()
        topic4.add("Topic 1")
        topic4.add("Topic 2")
        topic4.add("Topic 3")

        topicList[chapterlist[0]] = topic1
        topicList[chapterlist[1]] = topic2
        topicList[chapterlist[2]] = topic3
        topicList[chapterlist[3]] = topic4
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}