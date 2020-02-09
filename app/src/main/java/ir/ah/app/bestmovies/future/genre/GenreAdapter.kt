package ir.ah.app.bestmovies.future.genre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ir.ah.app.bestmovies.R
import ir.ah.app.bestmovies.model.data.genre.Genre
import ir.ah.app.bestmovies.system.RvAdapter
import ir.ah.app.bestmovies.system.RvViewHolder

class GenreAdapter(genre :List<Genre> ):
    RvAdapter<Genre, GenreAdapter.GenresViewHolder>(genre as ArrayList<Genre>) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        return GenresViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_genres,parent,false))

    }



    inner class  GenresViewHolder(itemView: View): RvViewHolder<Genre>(itemView){

        private val itemGenresTitle : TextView

        init {
            itemGenresTitle=itemView.findViewById(R.id.tv_itemGenres_title)

        }


        override fun bind(item: Genre) {
            itemGenresTitle.text=item.name



        }


    }








}