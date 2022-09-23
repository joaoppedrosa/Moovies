package com.jppedrosa.moovies.common.utils

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 23/09/2022.
 */
class ImageUtils {

    companion object {
        public fun getTmdbUrlImage(path: String) =
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/$path"
    }
}