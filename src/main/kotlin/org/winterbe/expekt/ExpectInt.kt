package org.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectInt(value: Int?) : ExpectAny<Int>(value) {
    override val to: ExpectInt get() = this
    override val be: ExpectInt get() = this
    override val been: ExpectInt get() = this
    override val that: ExpectInt get() = this
    override val which: ExpectInt get() = this
    override val and: ExpectInt get() = this
    override val has: ExpectInt get() = this
    override val have: ExpectInt get() = this
    override val with: ExpectInt get() = this
    override val at: ExpectInt get() = this
    override val a: ExpectInt get() = this
    override val an: ExpectInt get() = this
    override val of: ExpectInt get() = this
    override val same: ExpectInt get() = this
    override val the: ExpectInt get() = this
    override val `is`: ExpectInt get() = this

    override val not: ExpectInt get() {
        super.not
        return this
    }

    override val `null`: ExpectInt get() {
        super.`null`
        return this
    }

    fun within(min: Int, max: Int): ExpectInt {
        verify { value!! >= min && value <= max }
        return this
    }

    fun most(other: Int): ExpectInt {
        verify { value!! <= other }
        return this
    }

    fun least(other: Int): ExpectInt {
        verify { value!! >= other }
        return this
    }

    fun above(other: Int): ExpectInt {
        verify { value!! > other }
        return this
    }

    fun below(other: Int): ExpectInt {
        verify { value!! < other }
        return this
    }
}