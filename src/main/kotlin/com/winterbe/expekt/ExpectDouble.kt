package com.winterbe.expekt

/**
 * Expectation context for `Double` values.
 *
 * @author Benjamin Winterberg
 */
class ExpectDouble(subject: Double?, flavor: Flavor, message: String?=null) : ExpectComparable<Double>(subject, flavor, message) {

    /**
     * Assert that the subject of this expectation is equal or close to the given value.
     */
    fun closeTo(expected: Double, delta: Double = 0.0): ExpectDouble {
        words.add("closeTo")
        words.add(expected.toString())
        words.add("±" + delta.toString())
        verify { subject!! >= expected - delta && subject <= expected + delta }
        return this
    }

    override val to: ExpectDouble get() {
        super.to
        return this
    }

    override val be: ExpectDouble get() {
        super.be
        return this
    }

    override val been: ExpectDouble get() {
        super.been
        return this
    }

    override val that: ExpectDouble get() {
        super.that
        return this
    }

    override val which: ExpectDouble get() {
        super.which
        return this
    }

    override val and: ExpectDouble get() {
        super.and
        return this
    }

    override val has: ExpectDouble get() {
        super.has
        return this
    }

    override val have: ExpectDouble get() {
        super.have
        return this
    }

    override val with: ExpectDouble get() {
        super.with
        return this
    }

    override val at: ExpectDouble get() {
        super.at
        return this
    }

    override val a: ExpectDouble get() {
        super.a
        return this
    }

    override val an: ExpectDouble get() {
        super.an
        return this
    }

    override val of: ExpectDouble get() {
        super.of
        return this
    }

    override val same: ExpectDouble get() {
        super.same
        return this
    }

    override val the: ExpectDouble get() {
        super.the
        return this
    }

    override val `is`: ExpectDouble get() {
        super.`is`
        return this
    }

    override val not: ExpectDouble get() {
        super.not
        return this
    }

    override val `null`: ExpectDouble get() {
        super.`null`
        return this
    }

    override fun within(min: Double, max: Double): ExpectDouble {
        super.within(min, max)
        return this
    }

    override fun most(other: Double): ExpectDouble {
        super.most(other)
        return this
    }

    override fun least(other: Double): ExpectDouble {
        super.least(other)
        return this
    }

    override fun above(other: Double): ExpectDouble {
        super.above(other)
        return this
    }

    override fun below(other: Double): ExpectDouble {
        super.below(other)
        return this
    }

    override fun <S : Double> instanceof(type: Class<S>): ExpectDouble {
        super.instanceof(type)
        return this
    }

    override fun identity(expected: Double?): ExpectDouble {
        super.identity(expected)
        return this
    }

    override fun equal(expected: Double?): ExpectDouble {
        super.equal(expected)
        return this
    }

    override fun satisfy(predicate: (Double) -> Boolean): ExpectDouble {
        super.satisfy(predicate)
        return this
    }

    override fun withMessage(message:String): ExpectDouble {
        super.withMessage(message)
        return this
    }
}