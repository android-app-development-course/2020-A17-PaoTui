package com.example.main_interface

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class Database(val context : Context,name:String,version:Int):SQLiteOpenHelper(context,name,null,version)
{
    private val createAccount = "create table user (" +
                            "account text primary key," +
                            "password text)"

    private val createInformation = "create table Information (" +
                                 "content text primary key," +
                                 "price text)"

    private val createPersonal = "create table Person (" +
                                "Name text primary key)"


    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(createAccount)
            db.execSQL(createInformation)
            db.execSQL(createPersonal)
            Toast.makeText(context,"创建成功！",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL("drop table if exists user")
            db.execSQL("drop table if exists Information")
            db.execSQL("drop table if exists Person")
            onCreate(db)
        }
    }

}