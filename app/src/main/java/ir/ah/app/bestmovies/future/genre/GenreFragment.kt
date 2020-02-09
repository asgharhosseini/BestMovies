package ir.ah.app.bestmovies.future.genre

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.ah.app.bestmovies.R
import ir.ah.app.bestmovies.best.ObserverFragment
import ir.ah.app.bestmovies.model.data.genre.Genre
import ir.ah.app.bestmovies.system.OnRvItemClickListener
import kotlinx.android.synthetic.main.fragment_genre.*

class GenreFragment : ObserverFragment() {

    override val layoutRes = R.layout.fragment_genre
    override fun setupViews() {
        genreViewModel = GenreViewModel(context!!)

    }

    private lateinit var genreViewModel: GenreViewModel


    override fun subscribe() {
        compositeDisposable.add(

            genreViewModel.getGenres()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    logger(it.size)
                    val genreAdapter =
                        GenreAdapter(it)
                    rv_categoryFragment.adapter = genreAdapter
                    genreAdapter.setOnRvItemClickListener(object :
                        OnRvItemClickListener<Genre> {
                        override fun onItemClick(item: Genre, position: Int) {
                            val bundle = Bundle()

                            bundle.putInt("id",item.id)
                            findNavController().navigate(R.id.action_genreFragment_to_genreMoviesFragment2,bundle)



                        }
                    }
                    )
                    rv_categoryFragment.layoutManager =
                        LinearLayoutManager(
                            context,
                            RecyclerView.VERTICAL, false
                        )


                }


        )

    }

}