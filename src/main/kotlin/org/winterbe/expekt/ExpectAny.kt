package org.winterbe.expekt

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
    open val a: ExpectAny<T> get() = this
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

    open val `null`: ExpectAny<T> get() {
        verify { value == null }
        return this
    }

    fun <S: T> instanceof(type: Class<S>) {
        verify { type.isInstance(value) }
    }

    fun identity(other: T?) {
        verify { value === other }
    }

    fun equal(other: T?) {
        verify { value == other }
    }

    fun satisfy(predicate: (a: T) -> Boolean) {
        verify { predicate(value!!) }
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