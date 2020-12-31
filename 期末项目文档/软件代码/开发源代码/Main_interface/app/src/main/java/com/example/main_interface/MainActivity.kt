package com.example.main_interface

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

private val taskList = ArrayList<Task>()
var count = 0
var user3 = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        initData()
        val dbhelper = Database(this, "Personal.db", 2)
        val db = dbhelper.writableDatabase
        val cursor = db.query("user", null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                user3 = cursor.getString(cursor.getColumnIndex("account"))
            } while (cursor.moveToNext())
        }
        cursor.close()
        var note = intent.getStringExtra("content").toString()
        var price = intent.getStringExtra("price").toString()

        var image1 = R.drawable.touxiang
        if(count == 0)
        {
            note = "临近期末，大家注意作业完成情况！"
            price = " "
            user3 = "公告"
            count++
        }
        taskList.add(Task(note, price,image1,user3))
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = TaskAdapter(taskList)
        recyclerView.adapter = adapter
        recyclerView.scrollToPosition(taskList.size - 1)
        release.setOnClickListener() {
            val intent = Intent(this, Release::class.java)
            startActivity(intent)
        }
    }
}

//    fun initData() {
//        val dbhelper = Database(this, "Personal.db", 2)
//        val db = dbhelper.writableDatabase
//        val cursor = db.query("Information", null, null, null, null, null, null)
//        if (cursor.moveToFirst()) {
//            do {
//                val content = cursor.getString(cursor.getColumnIndex("content"))
//                val price = cursor.getString(cursor.getColumnIndex("price"))
//                taskList.add(Task(content, price))
//            } while (cursor.moveToNext())
//        }
//        cursor.close()
//    }
//}


