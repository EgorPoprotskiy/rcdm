package com.egorpoprotskiy.rcdm.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {
    //7.1 Объявление binding
    private var _binding: FragmentNotesBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 7.2 Раздувание макета через binding
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 7.4 Переход на на другой фрагмент
        binding.addNote.setOnClickListener {
            val action = NotesFragmentDirections.actionNavigationNotesToNoteAddFragment(
                // 7.5 передача в другой фрагмент заголовка.(Чтобы добавить этот ресурс надо в navGraph добавить аргумент(label)
                getString(R.string.add_fragment_note)
            )
            this.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}