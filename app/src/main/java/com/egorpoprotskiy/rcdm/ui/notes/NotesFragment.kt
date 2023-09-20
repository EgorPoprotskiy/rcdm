package com.egorpoprotskiy.rcdm.ui.notes

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.adapter.NoteListAdapter
import com.egorpoprotskiy.rcdm.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {
    //19.1 Использовать by activityViewModels() делегат свойства Kotlin для совместного использования ViewModel по фрагментам
    private val viewModel: NotesViewModel by activityViewModels{
        // 19.2 вызовите NoteViewModelFactory() конструктор и передать в NoteDao экземпляр. Использовать database экземпляр, созданный вами в одной из предыдущих задач, для вызова noteDao конструктор.
        NoteViewModelFactory((activity?.application as NoteApplication).database.noteDao())
    }
    //7.1 Объявление binding
    private var _binding: FragmentNotesBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    //19.0 переменные для адаптера
    private lateinit var noteAdapter: NoteListAdapter
    lateinit var note: Note

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
        super.onViewCreated(view, savedInstanceState)
        // 7.4 Переход на на другой фрагмент
        binding.addNote.setOnClickListener {
            val action = NotesFragmentDirections.actionNavigationNotesToNoteAddFragment(
                // 7.5 передача в другой фрагмент заголовка.(Чтобы добавить этот ресурс надо в navGraph добавить аргумент(label)
                getString(R.string.add_fragment_note)
            )
            this.findNavController().navigate(action)
        }
        //19.3 объявить val названный adapter. Инициализировать новый adapter свойство с помощью конструктора по умолчанию, NoteListAdapter{} переходя в ничто(т.е.сначала сделать его пустым).
        noteAdapter = NoteListAdapter {
            //19.4 добавить переход на фрагмент с деталями одного продукта. Далее в InventoryViewModel.
            val action = NotesFragmentDirections.actionNavigationNotesToNoteDetailFragment(it.id)
            this.findNavController().navigateUp()
        }
        //19.5 Привязать только что созданный adapter к recyclerView cледующим образом
        binding.recyclerView.adapter = noteAdapter
        //19.6 Прикрепите наблюдателя на allItems для прослушивания изменений данных..
        // ..Внутри наблюдателя вызовите submitList() на adapter и перейти в новый список. Это обновит RecyclerView новыми элементами в списке.
        viewModel.allItems.observe(this.viewLifecycleOwner) { items ->
            items.let {
                noteAdapter.submitList(it)
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}