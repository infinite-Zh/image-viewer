package com.infinite.imageviewer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import layout.ImageViewerFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val frg = ImageViewerFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, frg, "")
        ft.commit()
        val paths = mutableListOf<String>()
        for (index in 0..20) {
            paths.add("http://pics.sc.chinaz.com/files/pic/pic9/201804/wpic511.jpg")
        }
        frg.setPaths(paths)
    }
}
