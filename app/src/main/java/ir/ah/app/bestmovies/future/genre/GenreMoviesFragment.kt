package ir.ah.app.bestmovies.future.genre

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.ah.app.bestmovies.R
import ir.ah.app.bestmovies.best.ObserverFragment
import ir.ah.app.bestmovies.model.data.movies.Data
import ir.ah.app.bestmovies.system.OnRvItemClickListener
import kotlinx.android.synthetic.main.fragment_genre_movies.*

class GenreMoviesFragment:ObserverFragment() {

    override val layoutRes= R.layout.fragment_genre_movies

    override fun setupViews() {

        genreViewModel = GenreViewModel(context!!)
    }
    private lateinit var genreViewModel: GenreViewModel


    override fun subscribe() {
/*
      compositeDisposable.add(
            genreViewModel.getGenresMovies(arguments?.getInt("id")!!.toInt())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{

                    logger(it.data.size)
                    val genreMoviesAdapter =
                        GenreMoviesAdapter(it.data)
                    rv_fragment_genre_movies.adapter = genreMoviesAdapter
                    genreMoviesAdapter.setOnRvItemClickListener(object :
                        OnRvItemClickListener<Data> {
                        override fun onItemClick(item: Data, position: Int) {
                            val bundle = Bundle()

                            bundle.putInt("movieId",item.id)
                            findNavController().navigate(R.id.action_genreMoviesFragment2_to_detailFragment2,bundle)

                                       // toast(item.title)

                        }
                    }
                    )
                    rv_fragment_genre_movies.layoutManager =
                        GridLayoutManager(context,2)







                }

        )

*/

      compositeDisposable.add(
          genreViewModel.getMoviesInLocal(arguments?.getInt("id")!!.toInt())
              .subscribeOn(Schedulers.newThread())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe{

                  logger(it.data.size)
                  val genreMoviesAdapter =
                      GenreMoviesAdapter(it.data)
                  rv_fragment_genre_movies.adapter = genreMoviesAdapter
                  genreMoviesAdapter.setOnRvItemClickListener(object :
                      OnRvItemClickListener<Data> {
                      override fun onItemClick(item: Data, position: Int) {
                          val bundle = Bundle()

                          bundle.putInt("movieId",item.id)
                          findNavController().navigate(R.id.action_genreMoviesFragment2_to_detailFragment2,bundle)

                                     // toast(item.title)

                      }
                  }
                  )
                  rv_fragment_genre_movies.layoutManager =
                      GridLayoutManager(context,2)







              }

      )





  }


}