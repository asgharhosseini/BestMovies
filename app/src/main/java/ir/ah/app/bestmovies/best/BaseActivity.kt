package ir.ah.app.bestmovies.best

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity:AppCompatActivity() {


    fun snackBAr(message: String) {
        Snackbar.make(findViewById(layoutRes),message, Snackbar.LENGTH_LONG).show()
    }

    abstract val layoutRes: Int

}