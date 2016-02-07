package org.expekt

abstract class ExpectBase<T>(val subject: T?) {

    var negated = false

    val `null`: Unit get() {
        if (subject != null && !negated) {
            throw AssertionError()
        }
        if (subject == null && negated) {
            throw AssertionError()
        }
    }

    fun equal(other: T?) {
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
}