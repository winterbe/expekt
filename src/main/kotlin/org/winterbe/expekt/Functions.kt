package org.winterbe.expekt


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

val <T> Collection<T>?.should: ExpectCollection<T> get() {
    return ExpectCollection(this, Flavor.SHOULD)
}

fun <T> expect(subject: T?): ExpectAny<T?> {
    return ExpectAny(subject, Flavor.EXPECT)
}

fun expect(subject: Boolean): ExpectBoolean {
    return ExpectBoolean(subject, Flavor.EXPECT)
}

fun <T: Comparable<T>> expect(subject: T?): ExpectComparable<T> {
    return ExpectComparable(subject, Flavor.EXPECT)
}

fun expect(subject: String): ExpectString {
    return ExpectString(subject, Flavor.EXPECT)
}

fun <T> expect(subject: Collection<T>): ExpectCollection<T> {
    return ExpectCollection(subject, Flavor.EXPECT)
}