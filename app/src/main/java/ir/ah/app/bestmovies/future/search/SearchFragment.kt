package ir.ah.app.bestmovies.future.search

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.ah.app.bestmovies.R
import ir.ah.app.bestmovies.best.ObserverFragment
import ir.ah.app.bestmovies.model.data.movies.Data
import ir.ah.app.bestmovies.system.OnRvItemClickListener
import kotlinx.android.synthetic.main.fargment_search.*

class SearchFragment:ObserverFragment() {


    override val layoutRes=R.layout.fargment_search


    override fun setupViews() {
    searchViewModel= SearchViewModel()
    }
    private lateinit var searchViewModel: SearchViewModel

    override fun subscribe() {

        iv_search.setOnClickListener {


            compositeDisposable.add(
                searchViewModel.getSearchMovies(et_search.text.toString())
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe{
                        logger(it.data.size)



                        val moviesAdapter = SearchMoviesAdapter(it.data)
                        rv_fragmentSearch_movies.adapter=moviesAdapter
                        moviesAdapter.setOnRvItemClickListener(object :
                            OnRvItemClickListener<Data> {
                            override fun onItemClick(item: Data, position: Int) {
                                val bundle = Bundle()

                                bundle.putInt("movieId",item.id)
                                findNavController().navigate(R.id.action_searchFragment_to_detailFragment3,bundle)


                            }
                        })
                        rv_fragmentSearch_movies.layoutManager=
                            GridLayoutManager(context,2)







                    })

        }






    }
}