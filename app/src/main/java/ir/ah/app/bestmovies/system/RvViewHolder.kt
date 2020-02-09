package ir.ah.app.bestmovies.system

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class RvViewHolder<T>(item : View): RecyclerView.ViewHolder(item) {


    abstract fun bind(item:T)
}