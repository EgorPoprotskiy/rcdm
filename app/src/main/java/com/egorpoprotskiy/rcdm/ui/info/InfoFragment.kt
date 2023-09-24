package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.egorpoprotskiy.rcdm.adapter.AitListAdapter
import com.egorpoprotskiy.rcdm.data.AitDataSource
import com.egorpoprotskiy.rcdm.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    //31.1 Объявление binding
    private var _binding: FragmentInfoBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var aitListAdapter: AitListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //31.2 Привязка адаптера к АиТ
        val myDataset = AitDataSource().loadAitDataSourse()
        val adapter = AitListAdapter(myDataset) { selectedItem ->
            val action = InfoFragmentDirections.actionNavigationInfoToAitDetailFragment()
            this.findNavController().navigate(action)
        }
        binding.recyclerViewAit.adapter = adapter
        binding.recyclerViewAit.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}