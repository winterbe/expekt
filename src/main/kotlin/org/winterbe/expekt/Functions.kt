package org.winterbe.expekt


fun <T> T?.should(): ExpectAny<T> {
    return ExpectAny(this)
}

fun <T> expect(subject: T?): ExpectAny<T?> {
    return ExpectAny(subject)
}

fun expect(subject: Boolean): ExpectBoolean {
    return ExpectBoolean(subject)
}

fun <T: Comparable<T>> expect(subject: T?): ExpectComparable<T> {
    return ExpectComparable(subject)
}

fun expect(subject: String): ExpectString {
    return ExpectString(subject)
}

fun <T> expect(subject: Collection<T>): ExpectCollection<T> {
    return ExpectCollection(subject)
}