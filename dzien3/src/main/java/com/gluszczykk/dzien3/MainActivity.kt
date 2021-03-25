package com.gluszczykk.dzien3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.actionStream.observe(this, Observer<Brightness> {
            Toast.makeText(this, "Kliknięto: $it", Toast.LENGTH_SHORT).show()
        })
        setContentView(R.layout.activity_main)
    }
}