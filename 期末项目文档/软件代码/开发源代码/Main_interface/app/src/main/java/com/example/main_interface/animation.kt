package com.example.main_interface

import android.R
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Window
import com.ant.liao.GifView
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream


class animation : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(com.example.main_interface.R.layout.animation)
        val intent = Intent(this, login_register::class.java)
        Thread(Runnable {
            try {
                Thread.sleep(2000)
                startActivity(intent)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }).start()
    }

    /**
     * GifView获取图片资源
     */
//    private fun gifView() {
//        try {
//            val `is`: InputStream =
//                this.resources.openRawResource(R.drawable.che) //获取动图资源
//            val baos = ByteArrayOutputStream()
//            val b = ByteArray(2048)
//            var len = 0
//            while (`is`.read(b, 0, 2048).also({ len = it }) != -1) {
//                baos.write(b, 0, len)
//            }
//            baos.flush() //刷新流，确保传递完全
//            val bytes: ByteArray = baos.toByteArray() //转换成Byte数组
//            mGif.setGifImage(bytes)
//            // 添加监听器
//            //gif.setOnClickListener(this);
//            // 设置显示的大小，拉伸或者压缩,由于GiftView在布局文件中设置宽和高无效，所以要设置宽和高
//            mGif.setShowDimension(500, 200)
//            // 设置加载方式：先加载后显示、边加载边显示、只显示第一帧再显示
//            mGif.setGifImageType(GifView.GifImageType.WAIT_FINISH)
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
    
}