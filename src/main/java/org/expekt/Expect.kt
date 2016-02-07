package org.expekt

open class Expect<T>(val subject: T?) {
    var negated: Boolean = false

    // language chains
    val to: Expect<T> get() = this
    val be: Expect<T> get() = this
    val been: Expect<T> get() = this
    val that: Expect<T> get() = this
    val which: Expect<T> get() = this
    val and: Expect<T> get() = this
    val has: Expect<T> get() = this
    val have: Expect<T> get() = this
    val with: Expect<T> get() = this
    val at: Expect<T> get() = this
    val an: Expect<T> get() = this
    val of: Expect<T> get() = this
    val same: Expect<T> get() = this
    val the: Expect<T> get() = this
    val `is`: Expect<T> get() = this


    val length: Expect<T> get() = this
    val ok: Unit get() = Unit
    val exist: Unit get() = Unit
    val empty: Unit get() = Unit
    val `throw`: Unit get() = Unit

    val not: Expect<T> get() {
        this.negated = !this.negated
        return this
    }

    val `null`: Unit get() {
        if (subject != null && !negated) {
            throw AssertionError()
        }
        if (subject == null && negated) {
            throw AssertionError()
        }
    }

    fun equal(other: Any?) {
        if (subject != other && !negated) {
            throw AssertionError()
        }
        if (subject == other && negated) {
            throw AssertionError()
        }
    }

    fun satisfy(predicate: (a: T) -> Boolean) {
        if (subject == null) {
            throw AssertionError()
        }
        val satisfied = predicate(subject)
        if (!satisfied && !negated) {
            throw AssertionError()
        }
        if (satisfied && negated) {
            throw AssertionError()
        }
    }

    fun length(other: Any?) {

    }

    fun `throw`(other: Any?) {

    }

    fun instanceof(other: Any?) {

    }
}

//public class ExpectBoolean(subject: Boolean?) : Expect(subject) {
//    val `true`: Unit get() {
//        if (subject != true) {
//            throw AssertionError()
//        }
//    }
//
//    val `false`: Unit get() {
//        if (subject != false) {
//            throw AssertionError()
//        }
//    }
//}
//
//class ExpectNumber(subject: Number?) : Expect(subject) {
//    fun above(other: Any?): Expect {
//        return this
//    }
//
//    fun below(other: Any?): Expect {
//        return this
//    }
//}

fun <T> T?.should(): Expect<T> {
    return Expect(this)
}

fun <T> expect(subject: T?): Expect<T> {
    return Expect(subject)
}

//fun expect(subject: Boolean?): ExpectBoolean {
//    return ExpectBoolean(subject)
//}