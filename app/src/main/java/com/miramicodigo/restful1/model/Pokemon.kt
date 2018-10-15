package com.miramicodigo.restful1.model

import java.io.Serializable

class Pokemon : Serializable {
    var name: String? = null
    var url: String? = null

    var number: Int = 0
        get() {
            val urlParse = url!!.split("/".toRegex())
                    .dropLastWhile { it.isEmpty() }.toTypedArray()
            return Integer.parseInt(urlParse[urlParse.size - 1])
        }
}