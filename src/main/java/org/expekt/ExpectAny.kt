package org.expekt

/**
 * @author Benjamin Winterberg
 */
open class ExpectAny<T>(val value: T?) {
    open val to: ExpectAny<T> get() = this
    open val be: ExpectAny<T> get() = this
    open val been: ExpectAny<T> get() = this
    open val that: ExpectAny<T> get() = this
    open val which: ExpectAny<T> get() = this
    open val and: ExpectAny<T> get() = this
    open val has: ExpectAny<T> get() = this
    open val have: ExpectAny<T> get() = this
    open val with: ExpectAny<T> get() = this
    open val at: ExpectAny<T> get() = this
    open val an: ExpectAny<T> get() = this
    open val of: ExpectAny<T> get() = this
    open val same: ExpectAny<T> get() = this
    open val the: ExpectAny<T> get() = this
    open val `is`: ExpectAny<T> get() = this

    var negated = false

    open val not: ExpectAny<T> get() {
        this.negated = !this.negated
        return this
    }

    val `null`: Unit get() {
        if (value != null && !negated) {
            throw AssertionError()
        }
        if (value == null && negated) {
            throw AssertionError()
        }
    }

    fun equal(other: T?) {
        if (value != other && !negated) {
            throw AssertionError()
        }
        if (value == other && negated) {
            throw AssertionError()
        }
    }

    fun satisfy(predicate: (a: T) -> Boolean) {
        if (value == null) {
            throw AssertionError()
        }
        val satisfied = predicate(value)
        if (!satisfied && !negated) {
            throw AssertionError()
        }
        if (satisfied && negated) {
            throw AssertionError()
        }
    }

    protected fun verify(rule: () -> Boolean) {
        val truthy = rule()
        if (!truthy && !negated) {
            throw AssertionError()
        }
        if (truthy && negated) {
            throw AssertionError()
        }
    }

}