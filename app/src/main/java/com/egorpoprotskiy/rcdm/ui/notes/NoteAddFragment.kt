package com.egorpoprotskiy.rcdm.ui.notes

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.navArgs
import com.egorpoprotskiy.rcdm.databinding.FragmentNoteAddBinding


class NoteAddFragment : Fragment() {
    //8.1 Объявление переменной navArgs(). Аргументы должны присутствовать в navGraph этих фрагментов
    private val navigationArgs: NoteDetailFragmentArgs by navArgs()
    // 8.2 Объявление binding
    private var _binding: FragmentNoteAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // 8.3 Раздувание макета через binding
        _binding = FragmentNoteAddBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // 8.4 Скрыть клавиатуру
        val inputMethotManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethotManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }
}