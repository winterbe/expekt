package org.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectInt(value: Int?) : ExpectAny<Int>(value) {

    fun within(min: Int, max: Int): ExpectInt {
        words.add("within")
        words.add(min.toString())
        words.add(max.toString())
        verify { value!! >= min && value <= max }
        return this
    }

    fun most(other: Int): ExpectInt {
        words.add("most")
        words.add(other.toString())
        verify { value!! <= other }
        return this
    }

    fun least(other: Int): ExpectInt {
        words.add("least")
        words.add(other.toString())
        verify { value!! >= other }
        return this
    }

    fun above(other: Int): ExpectInt {
        words.add("above")
        words.add(other.toString())
        verify { value!! > other }
        return this
    }

    fun below(other: Int): ExpectInt {
        words.add("below")
        words.add(other.toString())
        verify { value!! < other }
        return this
    }

    override val to: ExpectInt get() {
        super.to
        return this
    }

    override val be: ExpectInt get() {
        super.be
        return this
    }

    override val been: ExpectInt get() {
        super.been
        return this
    }

    override val that: ExpectInt get() {
        super.that
        return this
    }

    override val which: ExpectInt get() {
        super.which
        return this
    }

    override val and: ExpectInt get() {
        super.and
        return this
    }

    override val has: ExpectInt get() {
        super.has
        return this
    }

    override val have: ExpectInt get() {
        super.have
        return this
    }

    override val with: ExpectInt get() {
        super.with
        return this
    }

    override val at: ExpectInt get() {
        super.at
        return this
    }

    override val a: ExpectInt get() {
        super.a
        return this
    }

    override val an: ExpectInt get() {
        super.an
        return this
    }

    override val of: ExpectInt get() {
        super.of
        return this
    }

    override val same: ExpectInt get() {
        super.same
        return this
    }

    override val the: ExpectInt get() {
        super.the
        return this
    }

    override val `is`: ExpectInt get() {
        super.`is`
        return this
    }

    override val not: ExpectInt get() {
        super.not
        return this
    }

    override val `null`: ExpectInt get() {
        super.`null`
        return this
    }
}