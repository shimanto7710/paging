package com.example.pagging3

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagging3.databinding.ActivityMainBinding
import com.example.pagging3.paging.PassengerPagingAdapter
import com.example.pagging3.viewmodels.PassengerViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    lateinit var quoteViewModel: PassengerViewModel
    private val quoteViewModel by viewModels<PassengerViewModel>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: PassengerPagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)

        recyclerView = binding.quoteList


//        quoteViewModel = ViewModelProvider(this).get(PassengerViewModel::class.java)

        adapter = PassengerPagingAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        quoteViewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })

    }
}