package com.winterbe.expekt

fun <T> expect(subject: T?): ExpectAny<T?> {
    return ExpectAny(subject, Flavor.EXPECT)
}

fun expect(subject: Boolean?): ExpectBoolean {
    return ExpectBoolean(subject, Flavor.EXPECT)
}

fun <T: Comparable<T>> expect(subject: T?): ExpectComparable<T> {
    return ExpectComparable(subject, Flavor.EXPECT)
}

fun expect(subject: Double?): ExpectDouble {
    return ExpectDouble(subject, Flavor.EXPECT)
}

fun expect(subject: String?): ExpectString {
    return ExpectString(subject, Flavor.EXPECT)
}

fun <T> expect(subject: Iterable<T>?): ExpectIterable<T> {
    return ExpectIterable(subject, Flavor.EXPECT)
}

fun <T> expect(subject: Sequence<T>?): ExpectIterable<T> {
    return ExpectIterable(subject?.toList(), Flavor.EXPECT)
}

fun <K, V> expect(subject: Map<K, V>?): ExpectMap<K, V> {
    return ExpectMap(subject, Flavor.EXPECT)
}

val <T> T?.should: ExpectAny<T> get() {
    return ExpectAny(this, Flavor.SHOULD)
}

val Boolean?.should: ExpectBoolean get() {
    return ExpectBoolean(this, Flavor.SHOULD)
}

val String?.should: ExpectString get() {
    return ExpectString(this, Flavor.SHOULD)
}

val <T: Comparable<T>> T?.should: ExpectComparable<T> get() {
    return ExpectComparable(this, Flavor.SHOULD)
}

val Double?.should: ExpectDouble get() {
    return ExpectDouble(this, Flavor.SHOULD)
}

val <T> Iterable<T>?.should: ExpectIterable<T> get() {
    return ExpectIterable(this, Flavor.SHOULD)
}

val <T> Sequence<T>?.should: ExpectIterable<T> get() {
    return ExpectIterable(this?.toList(), Flavor.SHOULD)
}

val <K, V> Map<K, V>?.should: ExpectMap<K, V> get() {
    return ExpectMap(this, Flavor.SHOULD)
}