package com.example.todolist.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.model.Country

@Dao
interface CountryDao {
    @Query("SELECT * FROM country")
    fun getAll(): List<Country>
    @Query("SELECT * FROM country WHERE id=:id")
    fun getById(id: Int): List<Country>
//    @Insert()
//    fun insert(country: Country): Long
//    @Update()
//    fun update(country: Country): Unit
}