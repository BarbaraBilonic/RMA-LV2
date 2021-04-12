package barbarabilonic.ferit.zad2.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import barbarabilonic.ferit.zad2.model.InspiringPearson
import barbarabilonic.ferit.zad2.listeners.OnImageClickListener
import barbarabilonic.ferit.zad2.databinding.ItemPearsonBinding
import com.squareup.picasso.Picasso

class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pearson: InspiringPearson, listener: OnImageClickListener) {
        val itemBinding = ItemPearsonBinding.bind(itemView)
        itemBinding.tvName.text = pearson.name
        itemBinding.tvDateOfBirthDeath.text = pearson.dateBirthDeath
        itemBinding.tvDescription.text = pearson.description
        Picasso.get().load(pearson.imageUrl).into(itemBinding.ivPearsonPicture)
        itemBinding.ivPearsonPicture.isClickable
        itemBinding.ivPearsonPicture.setOnClickListener {
            listener.onImageClick(pearson.quote)
        }


    }
}
