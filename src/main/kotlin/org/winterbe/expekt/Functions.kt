package org.winterbe.expekt


val <T> T?.should: ExpectAny<T> get() {
    return ExpectAny(this)
}

val Boolean?.should: ExpectBoolean get() {
    return ExpectBoolean(this)
}

val String?.should: ExpectString get() {
    return ExpectString(this)
}

val <T: Comparable<T>> T?.should: ExpectComparable<T> get() {
    return ExpectComparable(this)
}

val <T> Collection<T>?.should: ExpectCollection<T> get() {
    return ExpectCollection(this)
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