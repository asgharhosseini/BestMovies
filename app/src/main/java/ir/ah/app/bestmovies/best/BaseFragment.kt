package ir.ah.app.bestmovies.best

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment:Fragment() {

    private var rootView:View?=null
    abstract fun setupViews()
    abstract val layoutRes :Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     if (rootView==null){
         rootView=inflater.inflate(layoutRes,container,false)

     }
        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }


    fun logger(message: Any) {
        Log.i("LOGGER", "" + message)
    }
    fun snackBAr(message: String) {
        rootView?.let { Snackbar.make(it,message, Snackbar.LENGTH_LONG).show() }
    }

    fun toast(message: Any) {
        Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show()
    }

}