package com.miramicodigo.restful1.model

import java.io.Serializable

class Pokemon : Serializable {
    var name = ""
    var url = ""

    var number = 0
        get() {
            val urlParse = url.split("/".toRegex())
                    .dropLastWhile {
                        it.isEmpty()
                    }.toTypedArray()
            return Integer.parseInt(urlParse[urlParse.size -1])
        }
}