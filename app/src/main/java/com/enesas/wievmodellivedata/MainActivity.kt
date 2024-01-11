package com.enesas.wievmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.enesas.wievmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        // Bir provider ürettik ve TestViewModel'a bağladık.
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {
            binding.textViewSayi.text = it.toString()
        })
        viewModel.currentBoolean.observe(this, Observer {
            binding.textViewBoolean.text = it.toString()
        })

        sayiyiArttir()
    }

    private fun sayiyiArttir(){
        binding.button.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
        }
    }
}