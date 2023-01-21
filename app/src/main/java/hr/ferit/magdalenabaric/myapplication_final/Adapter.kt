package hr.ferit.magdalenabaric.myapplication_final

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val items : ArrayList<Dog>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DogViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_view, parent,
                    false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is DogViewHolder -> {  //provjeravamo da je holder iskljucivo PersonViewHolder, a ne neki drugi
                val currentItem=items[position]

                holder.dogName.text=currentItem.name
                holder.dogBreed.text=currentItem.breed
                holder.dogColor.text=currentItem.color
                holder.dogHeight.text=currentItem.height
                holder.dogPersonality.text=currentItem.personality
            }
        }
    }

    override fun getItemCount(): Int {
        return this.items.size
    }



    class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogName : TextView= itemView.findViewById<TextView>(R.id.dogName)
        val dogBreed : TextView= itemView.findViewById<TextView>(R.id.dogBreed)
        val dogColor : TextView= itemView.findViewById<TextView>(R.id.dogColor)
        val dogHeight : TextView= itemView.findViewById<TextView>(R.id.dogHeight)
        val dogPersonality : TextView= itemView.findViewById<TextView>(R.id.dogPersonality)

        fun bind(dog: Dog){
                dogName.text = dog.name
                dogBreed.text = dog.breed
                dogColor.text = dog.color
                dogHeight.text = dog.height
                dogPersonality.text = dog.personality

        }

    }

}