package com.egorpoprotskiy.rcdm.ui.notes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.databinding.FragmentNoteDetailBinding
import com.egorpoprotskiy.rcdm.model.Note

class NoteDetailFragment : Fragment() {
    //9.1 Объявление переменной navArgs(). Аргументы должны присутствовать в nav_graph этих фрагментов
    private val navigationArgs: NoteDetailFragmentArgs by navArgs()
    // 9.2 Объявление binding
    private var _binding: FragmentNoteDetailBinding? = null
    private val binding get() = _binding!!

    //21.1 Привязка данных к TextView
    lateinit var note: Note
    //21.2 Использовать by activityViewModels() делегат свойства Kotlin для совместного использования ViewModel по фрагментам
    private val viewModel: NotesViewModel by activityViewModels {
        // 21.3 вызовите NoteViewModelFactory() конструктор и передать в ItemDao экземпляр. Использовать database экземпляр, созданный вами в одной из предыдущих задач, для вызова itemDao конструктор.
        NoteViewModelFactory((activity?.application as NoteApplication).database.noteDao())
    }
    //21.4 создать private функция называется bind() который принимает экземпляр Note entity в качестве параметра и ничего не возвращает.
    private fun bind(note: Note) {
        binding.apply {
            //21.5 Заполнение данными(название, описание)
            noteHeading.text = note.heading
            noteDescription.text = note.description
            noteColor.setBackgroundColor(note.color.toInt())
            //Нажатие кнопки "поделиться"
            shareButton.setOnClickListener { sendNote() }
        }
    }
    //Добавления функции отправки заметки другому человеку
    fun sendNote() {
        val noteAll = getString(R.string.note_details, binding.noteHeading.text, binding.noteDescription.text)
        val intent = Intent(Intent.ACTION_SEND).setType("text/plain").putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name)).putExtra(Intent.EXTRA_TEXT, noteAll)
        if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
            startActivity(intent)
        }
    }
    //21.6 Создать onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //21.7 под вызовом функции суперкласса создайте неизменяемую переменную с именем id. Получите и назначьте аргумент навигации этой новой переменной.
        val id = navigationArgs.itemId
        viewModel.retrieveNote(id).observe(this.viewLifecycleOwner) {selectedNote ->
            note = selectedNote
            bind(note)
        }
    }

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