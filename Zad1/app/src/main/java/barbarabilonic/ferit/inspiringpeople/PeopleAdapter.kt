package barbarabilonic.ferit.inspiringpeople

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter (
    people: List<InspiringPearson>,
    private val listener: OnImageClickListener
    ) :
    RecyclerView.Adapter<PeopleViewHolder>() {

        private val  people: MutableList<InspiringPearson> = mutableListOf()
        init{
            refreshData(people)
        }

        public fun refreshData(people: List<InspiringPearson>) {
            this.people.clear()
            this.people.addAll(people)
            this.notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pearson, parent, false)
            return PeopleViewHolder(view)
        }

        override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
            val pearson = people[position]
            holder.bind(pearson,listener)

        }

        override fun getItemCount(): Int {
            return people.size
        }
}