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

fun <T> expect(subject: Collection<T>?): ExpectCollection<T> {
    return ExpectCollection(subject, Flavor.EXPECT)
}

fun <T> expect(subject: Sequence<T>?): ExpectCollection<T> {
    return ExpectCollection(subject?.toList(), Flavor.EXPECT)
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

val <T> Collection<T>?.should: ExpectCollection<T> get() {
    return ExpectCollection(this, Flavor.SHOULD)
}

val <T> Sequence<T>?.should: ExpectCollection<T> get() {
    return ExpectCollection(this?.toList(), Flavor.SHOULD)
}

val <K, V> Map<K, V>?.should: ExpectMap<K, V> get() {
    return ExpectMap(this, Flavor.SHOULD)
}