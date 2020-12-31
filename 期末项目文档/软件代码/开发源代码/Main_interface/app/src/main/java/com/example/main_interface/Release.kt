package com.example.main_interface

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.release_lay.*
import java.util.ArrayList

class Release : AppCompatActivity() {
    private val taskList = ArrayList<Task>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.release_lay)
        val dbhelper = Database(this,"Personal.db",2)
        release0.setOnClickListener() {
            val db = dbhelper.writableDatabase
            if(note.text.toString() != null && money.text.toString() != null){
                val note1 = note.text.toString()
                val money1 = money.text.toString()
                val Informations = ContentValues().apply {
                    put("content",note1)
                    put("price",money1)
                }
                db.insert("Information",null,Informations)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("content", note1)
                intent.putExtra("price", money1)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(parent,"请输入内容！",Toast.LENGTH_SHORT).show()
            }
        }
    }
}