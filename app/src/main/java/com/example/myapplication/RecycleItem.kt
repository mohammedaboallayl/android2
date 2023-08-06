package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels

class RecycleItem : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var titel:TextView
    private lateinit var description:TextView
    private lateinit var views:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_item)
        init()
        var intent:Intent=intent
        imageView.setImageResource(intent.getIntExtra("img",R.drawable.comming_1))
        titel.text=intent.getStringExtra("title")
        description.text=intent.getStringExtra("description")
        views.text=intent.getIntExtra("view",0).toString()+" Views"
    }
    fun init(){
        imageView=findViewById(R.id.itemimg)
        titel=findViewById(R.id.itemtitle)
        description=findViewById(R.id.itemdescription)
        views=findViewById(R.id.itemview)
    }
}