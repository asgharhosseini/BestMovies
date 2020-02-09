package ir.ah.app.bestmovies.best

import io.reactivex.disposables.CompositeDisposable

abstract class ObserverFragment:BaseFragment() {


    private var isSubscribeCall: Boolean = false
    protected val compositeDisposable = CompositeDisposable()



    abstract fun subscribe()

    fun unSsubscribe(){

        compositeDisposable.clear()
    }

    override fun onStart() {
        super.onStart()
        if(!isSubscribeCall){
            subscribe()
        }
        isSubscribeCall=true

    }

    override fun onStop() {
        super.onStop()
        unSsubscribe()
    }

}