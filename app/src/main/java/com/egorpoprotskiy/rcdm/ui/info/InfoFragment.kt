package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.egorpoprotskiy.rcdm.adapter.AitListAdapter
import com.egorpoprotskiy.rcdm.adapter.AllSystemListAdapter
import com.egorpoprotskiy.rcdm.adapter.KsListAdapter
import com.egorpoprotskiy.rcdm.adapter.NkListAdapter
import com.egorpoprotskiy.rcdm.adapter.PsListAdapter
import com.egorpoprotskiy.rcdm.adapter.VideoListAdapter
import com.egorpoprotskiy.rcdm.data.AitDataSource
import com.egorpoprotskiy.rcdm.data.AllSystemDataSource
import com.egorpoprotskiy.rcdm.data.KsDataSource
import com.egorpoprotskiy.rcdm.data.NkDataSource
import com.egorpoprotskiy.rcdm.data.PsDataSource
import com.egorpoprotskiy.rcdm.data.VideoDataSource
import com.egorpoprotskiy.rcdm.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    //31.1 Объявление binding
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

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
        navigationInfoAllSystemToOneSystem()
    }
    //54 Привязка адаптера к общему RecyclerView
    private fun navigationInfoAllSystemToOneSystem() {
        val myDataset = AllSystemDataSource(requireContext()).loadAllSystemDataSource()
        val adapter = AllSystemListAdapter(myDataset) {
            val action = InfoFragmentDirections.actionNavigationInfoToOneSystemFragment(it.allSystem)
            this.findNavController().navigate(action)
        }
        binding.recyclerViewAllSystem.adapter = adapter
        binding.recyclerViewAllSystem.setHasFixedSize(true)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}