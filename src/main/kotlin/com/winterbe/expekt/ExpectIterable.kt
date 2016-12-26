package com.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectIterable<T>(subject: Iterable<T>?, flavor: Flavor): ExpectAny<Iterable<T>>(subject, flavor) {

    private var anyMode = false
    
    private var haveMode = false

    val any: ExpectIterable<T> get() {
        words.add("any")
        anyMode = true
        return this
    }

    val all: ExpectIterable<T> get() {
        words.add("all")
        anyMode = false
        return this
    }

    override val have: ExpectIterable<T> get() {
        words.add("have")
        haveMode = true
        return this
    }

    val contain: ExpectIterable<T> get() {
        words.add("contain")
        haveMode = false
        return this
    }

    fun contain(other: T): ExpectIterable<T> {
        words.add("contain")
        words.add(other.toString())
        verify { subject!!.contains(other) }
        return this
    }

    fun elements(vararg elements: T): ExpectIterable<T> {
        words.add("elements")
        words.add(elements.toList().toString())
        if (anyMode) {
            verify { containsAny(elements) }
        } else {
            verify { containsAll(elements) }
        }
        return this
    }

    private fun containsAll(elements: Array<out T>): Boolean {
        if (haveMode && elements.count() != subject!!.count()) {
            return false
        }
        for (element in elements) {
            if (!subject!!.contains(element)) {
                return false
            }
        }
        return true
    }

    private fun containsAny(elements: Array<out T>): Boolean {
        // is the same for haveAny
        for (element in elements) {
            if (subject!!.contains(element)) {
                return true
            }
        }
        return false
    }

    val empty: ExpectIterable<T> get() {
        words.add("empty")
        verify { subject!!.empty() }
        return this
    }

    val size: ExpectComparable<Int> get() {
        words.add("size")
        val expectInt = ExpectComparable(subject!!.count(), flavor)
        expectInt.negated = negated
        expectInt.words.addAll(words)
        expectInt.words.removeAt(0)
        expectInt.words.removeAt(0)
        return expectInt
    }

    fun size(size: Int): ExpectIterable<T> {
        words.add("size")
        words.add(size.toString())
        verify { subject!!.count() == size }
        return this
    }

    override val to: ExpectIterable<T> get() {
        super.to
        return this
    }

    override val be: ExpectIterable<T> get() {
        super.be
        return this
    }

    override val been: ExpectIterable<T> get() {
        super.been
        return this
    }

    override val that: ExpectIterable<T> get() {
        super.that
        return this
    }

    override val which: ExpectIterable<T> get() {
        super.which
        return this
    }

    override val and: ExpectIterable<T> get() {
        super.and
        return this
    }

    override val has: ExpectIterable<T> get() {
        super.has
        return this
    }

    override val with: ExpectIterable<T> get() {
        super.with
        return this
    }

    override val at: ExpectIterable<T> get() {
        super.at
        return this
    }

    override val a: ExpectIterable<T> get() {
        super.a
        return this
    }

    override val an: ExpectIterable<T> get() {
        super.an
        return this
    }

    override val of: ExpectIterable<T> get() {
        super.of
        return this
    }

    override val same: ExpectIterable<T> get() {
        super.same
        return this
    }

    override val the: ExpectIterable<T> get() {
        super.the
        return this
    }

    override val `is`: ExpectIterable<T> get() {
        super.`is`
        return this
    }

    override val not: ExpectIterable<T> get() {
        super.not
        return this
    }

    override val `null`: ExpectIterable<T> get() {
        super.`null`
        return this
    }

    override fun <S : Iterable<T>> instanceof(type: Class<S>): ExpectIterable<T> {
        super.instanceof(type)
        return this
    }

    override fun identity(expected: Iterable<T>?): ExpectIterable<T> {
        super.identity(expected)
        return this
    }

    override fun equal(expected: Iterable<T>?): ExpectIterable<T> {
        super.equal(expected)
        return this
    }

    override fun satisfy(predicate: (Iterable<T>) -> Boolean): ExpectIterable<T> {
        super.satisfy(predicate)
        return this
    }
}