package ir.ah.app.bestmovies.system

import androidx.recyclerview.widget.RecyclerView

abstract class RvAdapter<T, E : RvViewHolder<T>> : RecyclerView.Adapter<E> {

    private var onRvItemClickListener : OnRvItemClickListener<T>?=null
    private var items = arrayListOf<T>()

    constructor()
    constructor(items:ArrayList<T>){
        this.items=items

    }

    constructor(onRvItemClickListener : OnRvItemClickListener<T>?,items: ArrayList<T>):super() {
        this.items = items
        this.onRvItemClickListener=onRvItemClickListener
    }




    override fun getItemCount(): Int {
        return items.size


    }

    override fun onBindViewHolder(holder: E, position: Int) {

        holder.bind(items[position])
        if (onRvItemClickListener !=null){
            holder.itemView.setOnClickListener {

                onRvItemClickListener!!.onItemClick(items[position],position)
            }
        }



    }


    fun  setOnRvItemClickListener(onRvItemClickListener: OnRvItemClickListener<T>){
        this.onRvItemClickListener=onRvItemClickListener
    }


}