package com.egorpoprotskiy.rcdm.ui.notes

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.egorpoprotskiy.rcdm.R
import com.egorpoprotskiy.rcdm.adapter.NoteListAdapter
import com.egorpoprotskiy.rcdm.databinding.FragmentNotesBinding
import com.egorpoprotskiy.rcdm.model.Note
import kotlin.math.roundToInt

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
            this.findNavController().navigate(action)
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
        deleteItemSwipe(binding.recyclerView)
        editItemSwipe(binding.recyclerView)
    }
    //22.2 Удаление заметки с помощью свапа
    private fun deleteItemSwipe(recyclerViewNote: RecyclerView) {
        val callback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = noteAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteNote(item)
            }
            //---------------------
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {

                c.clipRect(
                    0f,
                    viewHolder.itemView.top.toFloat(),
                    dX,
                    viewHolder.itemView.bottom.toFloat()
                )

                val trashIcon = resources.getDrawable(R.drawable.baseline_delete_forever_24, null)
                val textMargin = resources.getDimension(R.dimen.marginAll2).roundToInt()
                trashIcon.bounds = Rect(
                    textMargin,
                    viewHolder.itemView.top + textMargin,
                    textMargin + trashIcon.intrinsicWidth,
                    viewHolder.itemView.top + trashIcon.intrinsicHeight + textMargin
                )
                trashIcon.draw(c)

                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerViewNote)
    }
    //24.1 Редактирование заметки с помощью свайпа
    private fun editItemSwipe(recyclerViewNote: RecyclerView) {
        val callback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = noteAdapter.currentList[viewHolder.adapterPosition]
                bind(item)
            }
            //---------------------
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                c.clipRect(
                    viewHolder.itemView.right.toFloat() + dX,
                    viewHolder.itemView.top.toFloat(),
                    viewHolder.itemView.right.toFloat(),
                    viewHolder.itemView.bottom.toFloat()
                )
//                c.drawColor(Color.GREEN)

                val editIcon = resources.getDrawable(R.drawable.baseline_edit_24, null)
                val textMargin = resources.getDimension(R.dimen.marginAll2).roundToInt()
                editIcon.bounds = Rect(
                    viewHolder.itemView.right - editIcon.intrinsicWidth - textMargin,
                    viewHolder.itemView.top + textMargin,
                    viewHolder.itemView.right - textMargin,
                    viewHolder.itemView.top + editIcon.intrinsicHeight + textMargin
                )
                editIcon.draw(c)
                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }
//--------------------
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerViewNote)
    }
    //24.2 функция для перехода на экран редактирования(он же являетяс экраном добавления нового элемента)
    private fun bind(note: Note) {
        val action = NotesFragmentDirections.actionNavigationNotesToNoteAddFragment(
            getString(R.string.edit_fragment_note), note.id
        )
        this.findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}