package org.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectInt(subject: Int?) : ExpectAny<Int>(subject) {
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
    override val an: ExpectInt get() = this
    override val of: ExpectInt get() = this
    override val same: ExpectInt get() = this
    override val the: ExpectInt get() = this
    override val `is`: ExpectInt get() = this

    override val not: ExpectInt get() {
        super.not
        return this
    }

    fun above(other: Int?): ExpectInt {
        if (value == null || other == null) {
            throw AssertionError()
        }
        if (value <= other && !negated) {
            throw AssertionError()
        }
        if (value > other && negated) {
            throw AssertionError()
        }
        return this
    }

    fun below(other: Int?): ExpectInt {
        if (value == null || other == null) {
            throw AssertionError()
        }
        if (value >= other && !negated) {
            throw AssertionError()
        }
        if (value < other && negated) {
            throw AssertionError()
        }
        return this
    }
}