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
@Database(entities = [Note::class], version = 3, exportSchema = false)
abstract class NoteRoomDatabase: RoomDatabase() {
    // 13.3 База данных должна знать о DAO. Внутри тела класса объявите абстрактную функцию, которая возвращает NoteDao. У вас может быть несколько DAO.
    abstract fun noteDao(): NoteDao
    // 13.4 Ниже абстрактной функции определите companion объект. Сопутствующий объект позволяет получить доступ к методам..
    // ..создания или получения базы данных с использованием имени класса в качестве квалификатора.
    companion object {
        // 13.5 Значение volatile переменной никогда не будет кэшироваться, и все записи и чтения будут выполняться в основную память и из нее..
        // ..Это помогает убедиться, что значение INSTANCE всегда актуален и одинаков для всех потоков выполнения..
        // ..Это означает, что изменения, внесенные одним потоком в INSTANCE немедленно видны всем другим потокам.
        @Volatile
        // 13.6 Внутри companion объект, объявите частную переменную, допускающую значение NULL INSTANCE для базы данных..
        // ..и инициализировать ее для null. INSTANCE переменная будет хранить ссылку на базу данных, когда она была создана..
        // ..Это помогает поддерживать один экземпляр базы данных, открытый в данный момент времени, что является дорогостоящим ресурсом для создания и обслуживания.
        private var INSTANCE: NoteRoomDatabase? = null
        // 13.7 Ниже INSTANCE, находясь еще внутри companionобъект, определите getDatabase()метод с Contextпараметр,..
        // который понадобится построителю базы данных. Вернуть тип ItemRoomDatabase. Вы увидите ошибку, потому что getDatabase()пока ничего не возвращает.
        fun getDatabase(context: Context): NoteRoomDatabase {
            // 13.8 Обертка кода для получения базы данных внутри synchronized block означает,..
            // что только один поток выполнения за раз может войти в этот блок кода, что гарантирует, что база данных будет инициализирована только один раз.
            return INSTANCE?: synchronized(this) {
                // 13.9 Внутри синхронизированного блока создайте val экземпляра и используйте построитель базы данных, чтобы получить базу данных. У вас все еще будут ошибки, которые вы исправите на следующих шагах.
                // 13.9.1 Используйте построитель базы данных, чтобы получить базу данных. Передайте контекст приложения, класс базы данных и имя базы данных, note_database к Room.databaseBuilder().
                // 13.9.2 Добавьте необходимую стратегию миграции в билдер. Использовать .fallbackToDestructiveMigration().
                // 13.9.3 Чтобы создать экземпляр базы данных, вызовите .build(). Это должно устранить ошибки Android Studio.
                val instance = Room.databaseBuilder(context.applicationContext, NoteRoomDatabase::class.java, "note_database").fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}