package com.egorpoprotskiy.rcdm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//10.1 Создание сущности, имя БД
@Entity(tableName = "note")
data class Note (
    //главное поле, по которому ориентируется БД, id генерируется автоматически
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "heading2")
    val heading: String,
    @ColumnInfo(name = "description2")
    val description: String,
    @ColumnInfo(name = "color")
    val color: String
)