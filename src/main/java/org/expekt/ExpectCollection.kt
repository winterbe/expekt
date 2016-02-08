package org.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectCollection<T>(subject: Collection<T>): ExpectAny<Collection<T>>(subject) {
    override val to: ExpectCollection<T> get() = this
    override val be: ExpectCollection<T> get() = this
    override val been: ExpectCollection<T> get() = this
    override val that: ExpectCollection<T> get() = this
    override val which: ExpectCollection<T> get() = this
    override val and: ExpectCollection<T> get() = this
    override val has: ExpectCollection<T> get() = this
    override val have: ExpectCollection<T> get() = this
    override val with: ExpectCollection<T> get() = this
    override val at: ExpectCollection<T> get() = this
    override val an: ExpectCollection<T> get() = this
    override val of: ExpectCollection<T> get() = this
    override val same: ExpectCollection<T> get() = this
    override val the: ExpectCollection<T> get() = this
    override val `is`: ExpectCollection<T> get() = this

    override val not: ExpectCollection<T> get() {
        super.not
        return this
    }

    val length: ExpectInt get() {
        val expectInt = ExpectInt(value!!.size)
        if (negated) {
            return expectInt.not
        }
        return expectInt
    }

    fun length(length: Int): ExpectCollection<T> {
        if (value!!.size != length && !negated) {
            throw AssertionError()
        }
        if (value.size == length && negated) {
            throw AssertionError()
        }
        return this
    }

    fun contain(other: T): ExpectCollection<T> {
        if (!value!!.contains(other) && !negated) {
            throw AssertionError()
        }
        if (value.contains(other) && negated) {
            throw AssertionError()
        }
        return this
    }

    fun empty(): ExpectCollection<T> {
        if (!value!!.isEmpty() && !negated) {
            throw AssertionError()
        }
        if (value.isEmpty() && negated) {
            throw AssertionError()
        }
        return this
    }
}