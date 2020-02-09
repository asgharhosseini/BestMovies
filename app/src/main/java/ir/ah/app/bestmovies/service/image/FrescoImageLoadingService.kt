package ir.ah.app.bestmovies.service.image

import android.net.Uri
import ir.ah.app.bestmovies.system.MyImageView

class FrescoImageLoadingService : ImageLoadingService<MyImageView> {
    override fun show(res: Int, target: MyImageView) {

        return target.setImageResource(res)
    }

    override fun show(res: Uri, target: MyImageView) {

        return target.setImageURI(res)
    }

    override fun show(res: String, target: MyImageView) {
        return target.setImageURI(res)
    }


}