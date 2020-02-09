package ir.ah.app.bestimdb.feature.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import ir.ah.app.bestmovies.R
import ir.ah.app.bestmovies.system.RvAdapter
import ir.ah.app.bestmovies.system.RvViewHolder

class GenresMovieAdapter(genresMovie:ArrayList<String>) :
    RvAdapter<String, GenresMovieAdapter.GenresMovieViewHolder>(genresMovie )
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresMovieViewHolder {
        return GenresMovieViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genre,parent,false))

    }


    inner class  GenresMovieViewHolder(itemView: View): RvViewHolder<String>(itemView){

        private val itemWriterTitle : TextView

        init {
            itemWriterTitle=itemView.findViewById(R.id.tv_itemGenre_title)

        }


        override fun bind(item: String) {
            itemWriterTitle.text=item



        }


    }



}