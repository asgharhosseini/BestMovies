package ir.ah.app.bestimdb.feature.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ir.ah.app.bestmovies.R
import ir.ah.app.bestmovies.system.RvAdapter
import ir.ah.app.bestmovies.system.RvViewHolder


class ActorsAdapter(actors:ArrayList<String>) :
    RvAdapter<String, ActorsAdapter.ActorsViewHolder>(actors )
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        return ActorsViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_actor,parent,false))

    }


    inner class  ActorsViewHolder(itemView: View): RvViewHolder<String>(itemView){

        private val itemActorsTitle : TextView

        init {
            itemActorsTitle=itemView.findViewById(R.id.itemActor_name)

        }


        override fun bind(item: String) {
            itemActorsTitle.text=item



        }


    }



}