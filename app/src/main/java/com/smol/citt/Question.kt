package com.smol.citt

class Question(
    val q: String,
    val a: MutableList<String>?
) {

    operator fun plusAssign(b: String): Unit { a?.add(b) }

}