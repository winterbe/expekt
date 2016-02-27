package com.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectString(subject: String?, flavor: Flavor) : ExpectComparable<String>(subject, flavor) {

    val length: ExpectComparable<Int> get() {
        words.add("length")
        val expectInt = ExpectComparable(subject!!.length, this.flavor)
        expectInt.words.addAll(words)
        expectInt.words.removeAt(0)
        expectInt.words.removeAt(0)
        expectInt.negated = negated
        return expectInt
    }

    val empty: ExpectString get() {
        words.add("empty")
        verify { subject!!.isEmpty() }
        return this
    }

    fun match(regex: Regex): ExpectString {
        words.add("match")
        words.add(regex.pattern)
        verify { regex.matches(subject!!) }
        return this
    }

    fun length(length: Int): ExpectString {
        words.add("length")
        words.add(length.toString())
        verify { subject!!.length == length }
        return this
    }

    fun contain(other: String): ExpectString {
        words.add("contain")
        words.add(other)
        verify { subject!!.indexOf(other) >= 0 }
        return this
    }

    fun startWith(other: String): ExpectString {
        words.add("startWith")
        words.add(other)
        verify { subject!!.startsWith(other) }
        return this
    }

    fun endWith(other: String): ExpectString {
        words.add("endWith")
        words.add(other)
        verify { subject!!.endsWith(other) }
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

    override fun within(min: String, max: String): ExpectString {
        super.within(min, max)
        return this
    }

    override fun most(other: String): ExpectString {
        super.most(other)
        return this
    }

    override fun least(other: String): ExpectString {
        super.least(other)
        return this
    }

    override fun above(other: String): ExpectString {
        super.above(other)
        return this
    }

    override fun below(other: String): ExpectString {
        super.below(other)
        return this
    }

    override fun <S : String> instanceof(type: Class<S>): ExpectString {
        super.instanceof(type)
        return this
    }

    override fun identity(other: String?): ExpectString {
        super.identity(other)
        return this
    }

    override fun equal(other: String?): ExpectString {
        super.equal(other)
        return this
    }

    override fun satisfy(predicate: (String) -> Boolean): ExpectString {
        super.satisfy(predicate)
        return this
    }
}