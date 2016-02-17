package org.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectString(value: String?) : ExpectAny<String>(value) {
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
    override val a: ExpectString get() = this
    override val an: ExpectString get() = this
    override val of: ExpectString get() = this
    override val same: ExpectString get() = this
    override val the: ExpectString get() = this
    override val `is`: ExpectString get() = this

    override val not: ExpectString get() {
        super.not
        return this
    }

    override val `null`: ExpectString get() {
        super.`null`
        return this
    }

    val length: ExpectInt get() {
        val expectInt = ExpectInt(value!!.length)
        if (negated) {
            return expectInt.not
        }
        return expectInt
    }

    fun match(regex: Regex): ExpectString {
        verify { regex.matches(value!!) }
        return this
    }

    fun length(length: Int): ExpectString {
        verify { value!!.length == length }
        return this
    }

    fun contain(other: String): ExpectString {
        verify { value!!.indexOf(other) >= 0 }
        return this
    }

    fun empty(): ExpectString {
        verify { value!!.isEmpty() }
        return this
    }

    fun startWith(other: String): ExpectString {
        verify { value!!.startsWith(other) }
        return this
    }

    fun endWith(other: String): ExpectString {
        verify { value!!.endsWith(other) }
        return this
    }

}