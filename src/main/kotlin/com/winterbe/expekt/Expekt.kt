package com.winterbe.expekt

fun <T> expect(subject: T?, message: String? = null): ExpectAny<T?> {
    return ExpectAny(subject, Flavor.EXPECT, message)
}

fun expect(subject: Boolean?, message: String? = null): ExpectBoolean {
    return ExpectBoolean(subject, Flavor.EXPECT, message)
}

fun <T : Comparable<T>> expect(subject: T?, message: String? = null): ExpectComparable<T> {
    return ExpectComparable(subject, Flavor.EXPECT, message)
}

fun expect(subject: Double?, message: String? = null): ExpectDouble {
    return ExpectDouble(subject, Flavor.EXPECT, message)
}

fun expect(subject: String?, message: String? = null): ExpectString {
    return ExpectString(subject, Flavor.EXPECT, message)
}

fun <T> expect(subject: Collection<T>?, message: String? = null): ExpectCollection<T> {
    return ExpectCollection(subject, Flavor.EXPECT, message)
}

fun <T> expect(subject: Sequence<T>?, message: String? = null): ExpectCollection<T> {
    return ExpectCollection(subject?.toList(), Flavor.EXPECT, message)
}

fun <K, V> expect(subject: Map<K, V>?, message: String? = null): ExpectMap<K, V> {
    return ExpectMap(subject, Flavor.EXPECT, message)
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

val <T : Comparable<T>> T?.should: ExpectComparable<T> get() {
    return ExpectComparable(this, Flavor.SHOULD)
}

val Double?.should: ExpectDouble get() {
    return ExpectDouble(this, Flavor.SHOULD)
}

val <T> Collection<T>?.should: ExpectCollection<T> get() {
    return ExpectCollection(this, Flavor.SHOULD)
}

val <T> Sequence<T>?.should: ExpectCollection<T> get() {
    return ExpectCollection(this?.toList(), Flavor.SHOULD)
}

val <K, V> Map<K, V>?.should: ExpectMap<K, V> get() {
    return ExpectMap(this, Flavor.SHOULD)
}