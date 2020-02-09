package ir.ah.app.bestmovies.future.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import ir.ah.app.bestmovies.R
import ir.ah.app.bestmovies.model.data.movies.Data
import ir.ah.app.bestmovies.service.image.ImageLoadingServiceProvider
import ir.ah.app.bestmovies.system.MyImageView
import ir.ah.app.bestmovies.system.RvAdapter
import ir.ah.app.bestmovies.system.RvViewHolder

class SearchMoviesAdapter(genresMovies:List<Data>) :
RvAdapter<Data, SearchMoviesAdapter.SearchMoviesViewHolder>(genresMovies as ArrayList<Data>)
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMoviesViewHolder {
        return SearchMoviesViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genres_movies,parent,false))

    }


    inner class  SearchMoviesViewHolder(itemView: View): RvViewHolder<Data>(itemView){

        private val itemMoviesTitle : TextView
        private val itemImdbRating : TextView
        private val itemMoviesYear : TextView
        private val itemMoviesCountry : TextView
        private val itemMovieImage : MyImageView


        init {
            itemMoviesTitle=itemView.findViewById(R.id.tv_itemMovie_title)
            itemImdbRating=itemView.findViewById(R.id.tv_itemMovie_imdb_rating)
            itemMoviesYear=itemView.findViewById(R.id.tv_itemMovie_year)
            itemMoviesCountry=itemView.findViewById(R.id.tv_itemMovie_country)
            itemMovieImage=itemView.findViewById(R.id.iv_itemMovie_image)

        }


        override fun bind(item: Data) {
            itemMoviesTitle.text=item.title
            itemImdbRating.text=item.imdbRating
            itemMoviesYear.text=item.year
            itemMoviesCountry.text=item.country

            ImageLoadingServiceProvider.provider()
                .show(item.poster,itemMovieImage)







        }


    }



}