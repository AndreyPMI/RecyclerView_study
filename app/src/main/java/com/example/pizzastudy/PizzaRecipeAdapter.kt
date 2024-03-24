package com.example.pizzastudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzastudy.databinding.PizzaRecipeItemBinding

class PizzaRecipeAdapter(private val pizzaRecipeItems : ArrayList<PizzaRecipeltem>) : RecyclerView.Adapter<PizzaRecipeAdapter.PizzaHolder>(){
    class PizzaHolder(item : View) : RecyclerView.ViewHolder(item){
        private val binding = PizzaRecipeItemBinding.bind(item)
        fun bind(itemPizza: PizzaRecipeltem) = with(binding){
            pizzaImageView.setImageResource(itemPizza.imageResource)
            titleImageView.text = itemPizza.title
            descriptionImageView.text = itemPizza.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.pizza_recipe_item,parent,false)
        return PizzaHolder(view)
    }

    override fun getItemCount(): Int {
        return pizzaRecipeItems.size
    }

    override fun onBindViewHolder(holder: PizzaHolder, position: Int) {
        holder.bind(pizzaRecipeItems[position])
    }
}