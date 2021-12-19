package com.example.homework4

import android.os.Bundle
import android.widget.Toast
import com.example.homework4.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.subscribe()
        initButton()
    }

    private fun initButton() {
        binding.calculateButton.setOnClickListener {
            with(binding.numberToCalculateField) {
                val numberToCalculate =
                    if (!this.text.isNullOrEmpty()) this.text.toString() else null
                presenter.calculate(numberToCalculate)
            }
        }
    }

    override fun setCalculateResult(result: Long) {
        binding.calculateResult.text = result.toString()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}