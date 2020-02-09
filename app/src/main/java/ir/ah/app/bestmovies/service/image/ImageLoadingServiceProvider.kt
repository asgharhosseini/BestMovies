package ir.ah.app.bestmovies.service.image

import ir.ah.app.bestmovies.system.MyImageView

object ImageLoadingServiceProvider {

    fun provider():ImageLoadingService<MyImageView>{
        return FrescoImageLoadingService()
    }

}