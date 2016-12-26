package com.winterbe.expekt

fun <T> Iterable<T>.empty(): Boolean {
    return this.count() == 0
}
