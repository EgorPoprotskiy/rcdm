package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.adapter.AitListAdapter
import com.egorpoprotskiy.rcdm.adapter.KsListAdapter
import com.egorpoprotskiy.rcdm.adapter.NkListAdapter
import com.egorpoprotskiy.rcdm.adapter.PsListAdapter
import com.egorpoprotskiy.rcdm.adapter.VideoListAdapter
import com.egorpoprotskiy.rcdm.data.AitDataSource
import com.egorpoprotskiy.rcdm.data.KsDataSource
import com.egorpoprotskiy.rcdm.data.NkDataSource
import com.egorpoprotskiy.rcdm.data.PsDataSource
import com.egorpoprotskiy.rcdm.data.VideoDataSource
import com.egorpoprotskiy.rcdm.databinding.FragmentAitDetailBinding
import com.egorpoprotskiy.rcdm.databinding.FragmentOneSystemBinding

class OneSystemFragment : Fragment() {

    // 54 Объявление binding
    private var _binding: FragmentOneSystemBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneSystemBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationAitToAitDetailFragment()
        navigationPsToPsDetailFragment()
        navigationKsToKsDetailFragment()
        navigationNkToNkDetailFragment()
        navigationVideoToVideoDetailFragment()
    }

    //    31.2 Привязка адаптера к АиТ и вызов этой функции в onViewCrated
    private fun navigationAitToAitDetailFragment() {
        //35 При создании объекта AitDataSource в параметрах необходимо указать requireContext(), если это фрагмент, А если это активити, то надо указать context().
        val myDatasetAit = AitDataSource(requireContext()).loadAitDataSourse()
        val adapter = AitListAdapter(myDatasetAit) {
            //33 Навигация во фрагмент деталей АиТ
            val action =
                OneSystemFragmentDirections.actionOneSystemFragmentToAitDetailFragment(it.aitHeading)
            this.findNavController().navigate(action)
        }
        binding?.recyclerViewAit?.adapter = adapter
        binding?.recyclerViewAit?.setHasFixedSize(true)
    }

    //    41 Привязка адаптера к ПС и вызов этой функции в onViewCrated + Переход на фрагмент с деталями
    private fun navigationPsToPsDetailFragment() {
        val myDatasetPs = PsDataSource(requireContext()).loadPsDataSource()
        val adapter = PsListAdapter(myDatasetPs) {
            val action = OneSystemFragmentDirections.actionOneSystemFragmentToPsDetailFragment(it.psHeading)
            this.findNavController().navigate(action)
        }
        binding?.recyclerViewPs?.adapter = adapter
        binding?.recyclerViewPs?.setHasFixedSize(true)
    }

    //    47 Привязка адаптера к КС и вызов этой функции в onViewCrated + Переход на фрагмент с деталями
    private fun navigationKsToKsDetailFragment() {
        val myDatasetKs = KsDataSource(requireContext()).loadKsDataSource()
        val adapter = KsListAdapter(myDatasetKs) {
            val action = OneSystemFragmentDirections.actionOneSystemFragmentToKsDetailFragment(it.ksHeading)
            this.findNavController().navigate(action)
        }
        binding?.recyclerViewKs?.adapter = adapter
        binding?.recyclerViewKs?.setHasFixedSize(true)
    }

    //    48 Привязка адаптера к НК и вызов этой функции в onViewCrated + Переход на фрагмент с деталями
    private fun navigationNkToNkDetailFragment() {
        val myDatasetNk = NkDataSource(requireContext()).loadNkDataSource()
        val adapter = NkListAdapter(myDatasetNk) {
            val action = OneSystemFragmentDirections.actionOneSystemFragmentToNkDetailFragment(it.nkHeading)
            this.findNavController().navigate(action)
        }
        binding?.recyclerViewNk?.adapter = adapter
        binding?.recyclerViewNk?.setHasFixedSize(true)
    }

    //    49 Привязка адаптера к Видео и вызов этой функции в onViewCrated + Переход на фрагмент с деталями
    private fun navigationVideoToVideoDetailFragment() {
        val myDatasetVideo = VideoDataSource(requireContext()).loadVideoDataSource()
        val adapter = VideoListAdapter(myDatasetVideo) {
            val action = OneSystemFragmentDirections.actionOneSystemFragmentToVideoDetailFragment(it.videoHeading)
            this.findNavController().navigate(action)
        }
        binding?.recyclerViewVideo?.adapter = adapter
        binding?.recyclerViewVideo?.setHasFixedSize(true)
    }
}