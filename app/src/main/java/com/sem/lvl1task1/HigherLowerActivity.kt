package com.sem.lvl1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sem.lvl1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun updateUI() {
        binding.tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> binding.ivDice.setImageResource(R.drawable.dice1)
            2 -> binding.ivDice.setImageResource(R.drawable.dice2)
            3 -> binding.ivDice.setImageResource(R.drawable.dice3)
            4 -> binding.ivDice.setImageResource(R.drawable.dice4)
            5 -> binding.ivDice.setImageResource(R.drawable.dice5)
            6 -> binding.ivDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun initViews() {
        binding.btnLower.setOnClickListener {
            onLowerClick()
        }
        binding.btnHigher.setOnClickListener {
            onHigherClick()
        }
        binding.btnEqual.setOnClickListener {
            onEqualClick()
        }
        updateUI()
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, "Incorrect!", Toast.LENGTH_LONG).show()
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show()
    }

    private fun onHigherClick() {
        rollDice()
        if(currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick() {
        rollDice()
        if(currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick() {
        rollDice()
        if(lastThrow == currentThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

}