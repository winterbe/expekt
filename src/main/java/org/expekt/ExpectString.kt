package org.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectString(subject: String?) : ExpectAny<String>(subject) {
    override val to: ExpectString get() = this
    override val be: ExpectString get() = this
    override val been: ExpectString get() = this
    override val that: ExpectString get() = this
    override val which: ExpectString get() = this
    override val and: ExpectString get() = this
    override val has: ExpectString get() = this
    override val have: ExpectString get() = this
    override val with: ExpectString get() = this
    override val at: ExpectString get() = this
    override val an: ExpectString get() = this
    override val of: ExpectString get() = this
    override val same: ExpectString get() = this
    override val the: ExpectString get() = this
    override val `is`: ExpectString get() = this

    override val not: ExpectString get() {
        super.not
        return this
    }

    val length: ExpectInt get() {
        val expectInt = ExpectInt(value!!.length)
        if (negated) {
            return expectInt.not
        }
        return expectInt
    }

    fun length(length: Int): ExpectString {
        if (value!!.length != length && !negated) {
            throw AssertionError()
        }
        if (value.length == length && negated) {
            throw AssertionError()
        }
        return this
    }

    fun contain(other: String): ExpectString {
        if (value!!.indexOf(other) < 0 && !negated) {
            throw AssertionError()
        }
        if (value.indexOf(other) >= 0 && negated) {
            throw AssertionError()
        }
        return this
    }

    fun empty(): ExpectString {
        if (!value!!.isEmpty() && !negated) {
            throw AssertionError()
        }
        if (value.isEmpty() && negated) {
            throw AssertionError()
        }
        return this
    }

    fun startWith(other: String): ExpectString {
        if (!value!!.startsWith(other) && !negated) {
            throw AssertionError()
        }
        if (value.startsWith(other) && negated) {
            throw AssertionError()
        }
        return this
    }

    fun endWith(other: String): ExpectString {
        if (!value!!.endsWith(other) && !negated) {
            throw AssertionError()
        }
        if (value.endsWith(other) && negated) {
            throw AssertionError()
        }
        return this
    }

}