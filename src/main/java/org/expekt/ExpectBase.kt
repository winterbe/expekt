package org.expekt

abstract class ExpectBase<T>(val subject: T?) {

    // Language chains
    open val to: ExpectBase<T> get() = this
    open val be: ExpectBase<T> get() = this
    open val been: ExpectBase<T> get() = this
    open val that: ExpectBase<T> get() = this
    open val which: ExpectBase<T> get() = this
    open val and: ExpectBase<T> get() = this
    open val has: ExpectBase<T> get() = this
    open val have: ExpectBase<T> get() = this
    open val with: ExpectBase<T> get() = this
    open val at: ExpectBase<T> get() = this
    open val an: ExpectBase<T> get() = this
    open val of: ExpectBase<T> get() = this
    open val same: ExpectBase<T> get() = this
    open val the: ExpectBase<T> get() = this
    open val `is`: ExpectBase<T> get() = this

    var negated = false

    open val not: ExpectBase<T> get() {
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