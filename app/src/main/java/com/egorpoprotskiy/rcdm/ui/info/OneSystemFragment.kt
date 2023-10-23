package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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
        //55 Получение аргумента от InfoFragment
        val arguments = arguments
        if (arguments != null && arguments.containsKey("allSystem")) {
            val allSystem = arguments.getString("allSystem")
            //55 Навигация для фрагмента с деталями
            when (allSystem) {
                "АВТОМАТИКА И ТЕЛЕМЕХАНИКА" -> {
                    //35 При создании объекта AitDataSource в параметрах необходимо указать requireContext(), если это фрагмент, А если это активити, то надо указать context().
                    val myDatasetPs = AitDataSource(requireContext()).loadAitDataSourse()
                    val adapter = AitListAdapter(myDatasetPs) {
                        //33 Навигация во фрагмент деталей
                        val action =
                            OneSystemFragmentDirections.actionOneSystemFragmentToInfoDetailFragment(
                                it.aitHeading
                            )
                        this.findNavController().navigate(action)
                    }
                    binding?.recyclerViewOneSystem?.adapter = adapter
                    binding?.recyclerViewOneSystem?.setHasFixedSize(true)
                    binding?.tvOneSystem?.text = allSystem
                }

                "ПУТЕИЗМЕРЕНИЕ" -> {
                    //35 При создании объекта AitDataSource в параметрах необходимо указать requireContext(), если это фрагмент, А если это активити, то надо указать context().
                    val myDatasetPs = PsDataSource(requireContext()).loadPsDataSource()
                    val adapter = PsListAdapter(myDatasetPs) {
                        //33 Навигация во фрагмент деталей
                        val action =
                            OneSystemFragmentDirections.actionOneSystemFragmentToInfoDetailFragment(
                                it.psHeading
                            )
                        this.findNavController().navigate(action)
                    }
                    binding?.recyclerViewOneSystem?.adapter = adapter
                    binding?.recyclerViewOneSystem?.setHasFixedSize(true)
                    binding?.tvOneSystem?.text = allSystem
                }

                "ДЕФЕКТОСКОПИЯ" -> {
                    //35 При создании объекта AitDataSource в параметрах необходимо указать requireContext(), если это фрагмент, А если это активити, то надо указать context().
                    val myDatasetPs = NkDataSource(requireContext()).loadNkDataSource()
                    val adapter = NkListAdapter(myDatasetPs) {
                        //33 Навигация во фрагмент деталей
                        val action =
                            OneSystemFragmentDirections.actionOneSystemFragmentToInfoDetailFragment(
                                it.nkHeading
                            )
                        this.findNavController().navigate(action)
                    }
                    binding?.recyclerViewOneSystem?.adapter = adapter
                    binding?.recyclerViewOneSystem?.setHasFixedSize(true)
                    binding?.tvOneSystem?.text = allSystem
                }

                "КОНТАКТНАЯ СЕТЬ" -> {
                    //35 При создании объекта AitDataSource в параметрах необходимо указать requireContext(), если это фрагмент, А если это активити, то надо указать context().
                    val myDatasetPs = KsDataSource(requireContext()).loadKsDataSource()
                    val adapter = KsListAdapter(myDatasetPs) {
                        //33 Навигация во фрагмент деталей
                        val action =
                            OneSystemFragmentDirections.actionOneSystemFragmentToInfoDetailFragment(
                                it.ksHeading
                            )
                        this.findNavController().navigate(action)
                    }
                    binding?.recyclerViewOneSystem?.adapter = adapter
                    binding?.recyclerViewOneSystem?.setHasFixedSize(true)
                    binding?.tvOneSystem?.text = allSystem
                }

                "ВИДЕОКОНТРОЛЬ" -> {
                    //35 При создании объекта AitDataSource в параметрах необходимо указать requireContext(), если это фрагмент, А если это активити, то надо указать context().
                    val myDatasetPs = VideoDataSource(requireContext()).loadVideoDataSource()
                    val adapter = VideoListAdapter(myDatasetPs) {
                        //33 Навигация во фрагмент деталей
                        val action =
                            OneSystemFragmentDirections.actionOneSystemFragmentToInfoDetailFragment(
                                it.videoHeading
                            )
                        this.findNavController().navigate(action)
                    }
                    binding?.recyclerViewOneSystem?.adapter = adapter
                    binding?.recyclerViewOneSystem?.setHasFixedSize(true)
                    binding?.tvOneSystem?.text = allSystem
                }
            }
        }
    }
}