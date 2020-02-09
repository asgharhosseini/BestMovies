package ir.ah.app.bestmovies.future.detail

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.ah.app.bestimdb.feature.detail.ActorsAdapter
import ir.ah.app.bestimdb.feature.detail.GenresMovieAdapter
import ir.ah.app.bestimdb.feature.detail.WriterAdapter
import ir.ah.app.bestmovies.R
import ir.ah.app.bestmovies.best.ObserverFragment
import ir.ah.app.bestmovies.service.image.ImageLoadingServiceProvider
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : ObserverFragment() {
    override val layoutRes = R.layout.fragment_detail


    override fun setupViews() {
        detailViewModel = DetailViewModel()

    }

    private lateinit var detailViewModel: DetailViewModel

    override fun subscribe() {
        compositeDisposable.add(
            detailViewModel.getMovie(arguments?.getInt("movieId")!!.toInt())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{


                    tv_fragmentDetail_title.text=it.title
                    tv_fragmentDetail_imdbVotes.text=it.imdbVotes
                    tv_fragmentDetail_imdb.text=it.imdbRating
                    tv_fragmentDetail_runtime.text=it.runtime
                    tv_fragmentDetail_released.text=it.released
                    tv_fragmentDetail_director.text=it.director
                    tv_fragmentDetail_country.text=it.country
                    tv_fragmentDetail_plot.text=it.plot
                    tv_fragmentDetail_awards.text=it.awards

                    ImageLoadingServiceProvider.provider()
                        .show(it.poster,app_bar_image)



                        val writer=it.writer.split(',')
                    rv_fragmentDetail_writer.layoutManager=  GridLayoutManager(context,3)

                    val writerAdapter = WriterAdapter(writer as ArrayList<String>)
                    rv_fragmentDetail_writer.adapter=writerAdapter


                        val actors=it.actors.split(',')
                    rv_fragmentDetail_actors.layoutManager=
                        GridLayoutManager(context,3)
                    val actorsAdapter = ActorsAdapter(actors as ArrayList<String>)
                    rv_fragmentDetail_actors.adapter=actorsAdapter



                    val genresMovie=it.genres
                    rv_fragmentDetail_genre.layoutManager=
                        LinearLayoutManager(context, RecyclerView.HORIZONTAL,false)
                    val genresMovieAdapter= GenresMovieAdapter(genresMovie as ArrayList<String>)
                    rv_fragmentDetail_genre.adapter=genresMovieAdapter



                }



        )





    }


}