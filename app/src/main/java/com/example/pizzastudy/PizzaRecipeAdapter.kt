package com.example.pizzastudy

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzastudy.databinding.PizzaRecipeItemBinding

class PizzaRecipeAdapter(private val pizzaRecipeItems : ArrayList<PizzaRecipeltem> , val context: Context) : RecyclerView.Adapter<PizzaRecipeAdapter.PizzaHolder>(){
    inner class PizzaHolder(item : View ) : RecyclerView.ViewHolder(item), OnClickListener {
        private val binding = PizzaRecipeItemBinding.bind(item)
        init {
            item.setOnClickListener(this)
        }
        fun bind(itemPizza: PizzaRecipeltem) = with(binding){
            pizzaImageView.setImageResource(itemPizza.imageResource)
            titleImageView.text = itemPizza.title
            descriptionImageView.text = itemPizza.description
        }

        override fun onClick(v: View? ) {

            val position = adapterPosition
            val intent = Intent( context , RecipeActivity::class.java)
            val pizzaRecipeltem = pizzaRecipeItems[position]
            intent.putExtra("title", pizzaRecipeltem.title)
            intent.putExtra("descr", pizzaRecipeltem.description)

            context.startActivity(intent)
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