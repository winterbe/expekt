package org.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
open class ExpectComparable<T: Comparable<T>>(value: T?) : ExpectAny<T>(value) {

    open fun within(min: T, max: T): ExpectComparable<T> {
        words.add("within")
        words.add(min.toString())
        words.add(max.toString())
        verify { value!! >= min && value <= max }
        return this
    }

    open fun most(other: T): ExpectComparable<T> {
        words.add("most")
        words.add(other.toString())
        verify { value!! <= other }
        return this
    }

    open fun least(other: T): ExpectComparable<T> {
        words.add("least")
        words.add(other.toString())
        verify { value!! >= other }
        return this
    }

    open fun above(other: T): ExpectComparable<T> {
        words.add("above")
        words.add(other.toString())
        verify { value!! > other }
        return this
    }

    open fun below(other: T): ExpectComparable<T> {
        words.add("below")
        words.add(other.toString())
        verify { value!! < other }
        return this
    }

    override val to: ExpectComparable<T> get() {
        super.to
        return this
    }

    override val be: ExpectComparable<T> get() {
        super.be
        return this
    }

    override val been: ExpectComparable<T> get() {
        super.been
        return this
    }

    override val that: ExpectComparable<T> get() {
        super.that
        return this
    }

    override val which: ExpectComparable<T> get() {
        super.which
        return this
    }

    override val and: ExpectComparable<T> get() {
        super.and
        return this
    }

    override val has: ExpectComparable<T> get() {
        super.has
        return this
    }

    override val have: ExpectComparable<T> get() {
        super.have
        return this
    }

    override val with: ExpectComparable<T> get() {
        super.with
        return this
    }

    override val at: ExpectComparable<T> get() {
        super.at
        return this
    }

    override val a: ExpectComparable<T> get() {
        super.a
        return this
    }

    override val an: ExpectComparable<T> get() {
        super.an
        return this
    }

    override val of: ExpectComparable<T> get() {
        super.of
        return this
    }

    override val same: ExpectComparable<T> get() {
        super.same
        return this
    }

    override val the: ExpectComparable<T> get() {
        super.the
        return this
    }

    override val `is`: ExpectComparable<T> get() {
        super.`is`
        return this
    }

    override val not: ExpectComparable<T> get() {
        super.not
        return this
    }

    override val `null`: ExpectComparable<T> get() {
        super.`null`
        return this
    }
}