package com.egorpoprotskiy.rcdm.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.adapter.AllSystemListAdapter
import com.egorpoprotskiy.rcdm.data.AllSystemDataSource
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
//    54 Привязка адаптера к общему RecyclerView
    private fun navigationInfoAllSystemToOneSystem() {
        val myDataset = AllSystemDataSource(requireContext()).loadAllSystemDataSource()
        val adapter = AllSystemListAdapter(myDataset) {

                val action =
                    InfoFragmentDirections.actionNavigationInfoToOneSystemFragment(it.allSystem)
                this.findNavController().navigate(action)
        }
        binding.recyclerViewAllSystem.adapter = adapter
        binding.recyclerViewAllSystem.setHasFixedSize(true)
    }

//    //58 Код для Landscape(не работает дальнейший переход в описание отступлений)
//    private fun navigationInfoAllSystemToOneSystem() {
//        val myDataset = AllSystemDataSource(requireContext()).loadAllSystemDataSource()
//        val adapter = AllSystemListAdapter(myDataset) {
//            if (isOnePaneMode()) {
//                val action =
//                    InfoFragmentDirections.actionNavigationInfoToOneSystemFragment(it.allSystem)
//                this.findNavController().navigate(action)
//            } else {
//                launchFragment(OneSystemFragment.newInstance(it.allSystem))
//            }
//        }
//        binding.recyclerViewAllSystem.adapter = adapter
//        binding.recyclerViewAllSystem.setHasFixedSize(true)
//    }
//    //58 После создания макета, реализовать метод, который отвечает за true или false, чтобы приложение понимало в какой ориентации оно сейчас находится
//    private fun isOnePaneMode(): Boolean {
//        return binding.oneSystemContainer == null
//    }
//    //58 Создаем метод, который запускает этот контейнер
//    private fun launchFragment(fragment: Fragment) {
//        childFragmentManager.popBackStack()
//        childFragmentManager.beginTransaction().replace(R.id.one_system_container, fragment).addToBackStack(null).commit()
//    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}