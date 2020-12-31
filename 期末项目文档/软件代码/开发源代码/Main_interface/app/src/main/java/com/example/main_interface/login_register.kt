package com.example.main_interface

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*

var account3 = ""
var password3 = ""

class login_register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val dbhelper = Database(this, "Personal.db", 2)
        dbhelper.writableDatabase
        button1.setOnClickListener{
            val db = dbhelper.writableDatabase
            val account2 = editText1.text.toString()
            val password2 = editText2.text.toString()
            val cursor = db.query("user", null, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                do {
                    val account = cursor.getString(cursor.getColumnIndex("account"))
                    val password = cursor.getString(cursor.getColumnIndex("password"))
                    account3 = account
                    password3 = password
                } while (cursor.moveToNext())
            }
            cursor.close()
            if(account2 == "" || password2 == "")
            {
                Toast.makeText(this,"请输入账号或密码！",Toast.LENGTH_SHORT).show()
            }
            else if(account2 == account3  && password2 == password3)
            {
                Toast.makeText(this,"登陆成功！",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this,"账号或密码不正确！",Toast.LENGTH_SHORT).show()
            }
        }
        button2.setOnClickListener{
            val Intent = Intent(this,register::class.java)
            startActivity(Intent)
        }
    }

    fun initData() {

    }
}