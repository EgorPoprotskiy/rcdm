package com.egorpoprotskiy.rcdm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.egorpoprotskiy.rcdm.model.Note

// 11.7 Создание базы данных
// 11.8 Создать класс и аннотировать его как @Database
/*
    * Укажите Item как единственный класс со списком entities.
    * Установить version в качестве 1. Всякий раз, когда вы меняете схему таблицы базы данных, вам придется увеличивать номер версии.
    * Поставил exportSchema к false, чтобы не хранить резервные копии истории версий схемы.
*/
@Database(entities = [Note::class], version = 2, exportSchema = false)
abstract class NoteRoomDatabase: RoomDatabase() {
    // 13.3 База данных должна знать о DAO. Внутри тела класса объявите абстрактную функцию, которая возвращает NoteDao. У вас может быть несколько DAO.
    abstract fun noteDao(): NoteDao
    // 13.4 Ниже абстрактной функции определите companion объект. Сопутствующий объект позволяет получить доступ к методам..
    // ..создания или получения базы данных с использованием имени класса в качестве квалификатора.
    companion object {
        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null
        fun getDatabase(context: Context): NoteRoomDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, NoteRoomDatabase::class.java, "note_database").fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}