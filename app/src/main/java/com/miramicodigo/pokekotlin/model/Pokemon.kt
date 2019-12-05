package com.miramicodigo.pokekotlin.model

class Pokemon {
    var name = ""
    var url = ""

    var number = 0
        get() {
            val urlParse = url.split("/".toRegex()).dropLastWhile {
                it.isEmpty()
            }.toTypedArray()
            return urlParse[urlParse.size - 1].toInt()
        }
}