package com.egorpoprotskiy.rcdm.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.egorpoprotskiy.rcdm.databinding.FragmentNoteDetailBinding

class NoteDetailFragment : Fragment() {
    //9.1 Объявление переменной navArgs(). Аргументы должны присутствовать в nav_graph этих фрагментов
    private val navigationArgs: NoteDetailFragmentArgs by navArgs()
    // 9.2 Объявление binding
    private var _binding: FragmentNoteDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    //9.8 Вызывается, когда фрагмент уничтожен
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}