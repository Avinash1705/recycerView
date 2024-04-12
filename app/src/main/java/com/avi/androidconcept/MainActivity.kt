package com.avi.androidconcept

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var rv: RecyclerView
    lateinit var sv: SearchView
    lateinit var et: EditText
    lateinit var userRecyclerView: UserRecyclerView
    lateinit var userAdapterDiffutil: userAdapterDiffutil
    var itemList: List<String> =
        arrayListOf("Apple", "Banana", "Orange", "Grapes", "Mango", "Pineapple")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
//        userRecyclerView = UserRecyclerView(applicationContext,itemList)
//        rv.layoutManager = LinearLayoutManager(this)
//        rv.adapter = userRecyclerView
//        checkingCode()
        diffutil()
//        userAdapterDiffutil = userAdapterDiffutil(applicationContext,itemList)
//        rv.layoutManager = LinearLayoutManager(applicationContext)
//        rv.setHasFixedSize(true)
//        rv.adapter = userAdapterDiffutil
        et.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                userRecyclerView.filter.filter(p0)
//                userAdapterDiffutil.filter.filter(p0)
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun init() {
        rv = findViewById(R.id.rv)
        sv = findViewById(R.id.sv)
        et = findViewById(R.id.et_search)
    }

    private fun checkingCode() {
//        print("check TestCode");
        Log.d("TAG", "checkingCode: ")
    }
    private fun diffutil(){
        Log.d("rawat", "diffutil(): ")
        val adapter = userAdapterDiffutil()
        val p1 = userModel("a")
        val p2 = userModel("ab")
        val p3 = userModel("abc")
        val p4 = userModel("d")
        val p5 = userModel("e")
        adapter.submitList(listOf(p1,p2,p3,p4,p5))

        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.adapter = adapter
    }
}
