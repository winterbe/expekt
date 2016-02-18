package org.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectString(value: String?) : ExpectAny<String>(value) {

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

    override val to: ExpectString get() {
        super.to
        return this
    }

    override val be: ExpectString get() {
        super.be
        return this
    }

    override val been: ExpectString get() {
        super.been
        return this
    }

    override val that: ExpectString get() {
        super.that
        return this
    }

    override val which: ExpectString get() {
        super.which
        return this
    }

    override val and: ExpectString get() {
        super.and
        return this
    }

    override val has: ExpectString get() {
        super.has
        return this
    }

    override val have: ExpectString get() {
        super.have
        return this
    }

    override val with: ExpectString get() {
        super.with
        return this
    }

    override val at: ExpectString get() {
        super.at
        return this
    }

    override val a: ExpectString get() {
        super.a
        return this
    }

    override val an: ExpectString get() {
        super.an
        return this
    }

    override val of: ExpectString get() {
        super.of
        return this
    }

    override val same: ExpectString get() {
        super.same
        return this
    }

    override val the: ExpectString get() {
        super.the
        return this
    }

    override val `is`: ExpectString get() {
        super.`is`
        return this
    }

    override val not: ExpectString get() {
        super.not
        return this
    }

    override val `null`: ExpectString get() {
        super.`null`
        return this
    }

}