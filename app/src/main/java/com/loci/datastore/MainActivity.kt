package com.loci.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val save1 = findViewById<Button>(R.id.save1)

        save1.setOnClickListener {
            val editText = findViewById<EditText>(R.id.editText1)

            val insertText = editText.text.toString()

            viewModel.insert(insertText)
        }

        val read1 = findViewById<Button>(R.id.read1)

        read1.setOnClickListener {
            val readText1 = findViewById<TextView>(R.id.readText1)

            viewModel.read.observe(this, Observer {
                readText1.text = it.toString()
            })

        }
    }
}