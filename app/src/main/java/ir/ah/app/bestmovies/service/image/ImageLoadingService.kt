package ir.ah.app.bestmovies.service.image

import android.net.Uri
import android.view.View

interface ImageLoadingService<T:View> {

    fun show(res:Int ,target:T)
    fun show(res:Uri ,target:T)
    fun show(res:String ,target:T)


}