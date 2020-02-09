package ir.ah.app.bestimdb.feature.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ir.ah.app.bestmovies.R
import ir.ah.app.bestmovies.system.RvAdapter
import ir.ah.app.bestmovies.system.RvViewHolder

class WriterAdapter(writer:ArrayList<String>) :
    RvAdapter<String, WriterAdapter.WriterViewHolder>(writer )
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WriterViewHolder {
        return WriterViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_writer,parent,false))

    }


    inner class  WriterViewHolder(itemView: View): RvViewHolder<String>(itemView){

        private val itemWriterTitle : TextView

        init {
            itemWriterTitle=itemView.findViewById(R.id.tv_itemWriter_title)

        }


        override fun bind(item: String) {
            itemWriterTitle.text=item



        }


    }



}