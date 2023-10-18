package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.egorpoprotskiy.rcdm.adapter.AitListAdapter
import com.egorpoprotskiy.rcdm.adapter.KsListAdapter
import com.egorpoprotskiy.rcdm.adapter.PsListAdapter
import com.egorpoprotskiy.rcdm.data.AitDataSource
import com.egorpoprotskiy.rcdm.data.KsDataSource
import com.egorpoprotskiy.rcdm.data.PsDataSource
import com.egorpoprotskiy.rcdm.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    //31.1 Объявление binding
    private var _binding: FragmentInfoBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
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
        navigationAitToAitDetailFragment()
        navigationPsToPsDetailFragment()
        navigationKsToKsDetailFragment()
    }
//    31.2 Привязка адаптера к АиТ и вызов этой функции в onViewCrated
    private fun navigationAitToAitDetailFragment() {
        //35 При создании объекта AitDataSource в параметрах необходимо указать requireContext(), если это фрагмент, А если это активити, то надо указать context().
        val myDatasetAit = AitDataSource(requireContext()).loadAitDataSourse()
        val adapter = AitListAdapter(myDatasetAit) {
            //33 Навигация во фрагмент деталей АиТ
            val action = InfoFragmentDirections.actionNavigationInfoToAitDetailFragment(it.aitHeading)
            this.findNavController().navigate(action)
        }
        binding.recyclerViewAit.adapter = adapter
        binding.recyclerViewAit.setHasFixedSize(true)
    }

//    41 Привязка адаптера к ПС и вызов этой функции в onViewCrated + Переход на фрагмент с деталями
    private fun navigationPsToPsDetailFragment() {
        val myDatasetPs = PsDataSource(requireContext()).loadPsDataSource()
        val adapter = PsListAdapter(myDatasetPs) {
            val action = InfoFragmentDirections.actionNavigationInfoToPsDetailFragment(it.psHeading)
            this.findNavController().navigate(action)
        }
    binding.recyclerViewPs.adapter = adapter
    binding.recyclerViewPs.setHasFixedSize(true)
    }

//    47 Привязка адаптера к КС и вызов этой функции в onViewCrated + Переход на фрагмент с деталями
    private fun navigationKsToKsDetailFragment() {
        val myDatasetKs = KsDataSource(requireContext()).loadKsDataSource()
    val adapter = KsListAdapter(myDatasetKs) {
        val action = InfoFragmentDirections.actionNavigationInfoToKsDetailFragment(it.ksHeading)
        this.findNavController().navigate(action)
    }
    binding.recyclerViewKs.adapter = adapter
    binding.recyclerViewKs.setHasFixedSize(true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}