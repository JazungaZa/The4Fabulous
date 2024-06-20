package com.example.the4fabulous

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    var personNameList = ArrayList<String>()
    var personDetailList = ArrayList<String>()
    var imageList = ArrayList<Int>()

    lateinit var adapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        personNameList.add(getString(R.string.person_name1))
        personNameList.add(getString(R.string.person_name2))
        personNameList.add(getString(R.string.person_name3))
        personNameList.add(getString(R.string.person_name4))

        personDetailList.add(getString(R.string.person_detail1))
        personDetailList.add(getString(R.string.person_detail2))
        personDetailList.add(getString(R.string.person_detail3))
        personDetailList.add(getString(R.string.person_detail4))

        imageList.add(R.drawable.ja)
        imageList.add(R.drawable.moj_kiki)
        imageList.add(R.drawable.draga_monika)
        imageList.add(R.drawable.rog_nova)

        adapter = PeopleAdapter(personNameList, personDetailList, imageList, this@MainActivity)
        recyclerView.adapter = adapter
    }
}