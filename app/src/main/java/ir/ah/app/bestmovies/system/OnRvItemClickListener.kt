package ir.ah.app.bestmovies.system

interface OnRvItemClickListener<T> {

    fun onItemClick(item:T,position:Int)
}