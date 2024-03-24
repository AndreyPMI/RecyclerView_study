package com.example.pizzastudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pizzastudy.databinding.ActivityRecipeBinding

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityRecipeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val title = binding.titleTextView
        val descipt = binding.descriptionTextView
        val intent = intent
        intent?.getStringExtra("title").also {title.text = it }
        intent?.getStringExtra("descr").also {descipt.text = it }
    }
}