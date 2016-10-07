package com.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectCollection<T>(subject: Collection<T>?, flavor: Flavor, message: String?=null): ExpectAny<Collection<T>>(subject, flavor, message) {

    private var anyMode = false
    
    private var haveMode = false

    val any: ExpectCollection<T> get() {
        words.add("any")
        anyMode = true
        return this
    }

    val all: ExpectCollection<T> get() {
        words.add("all")
        anyMode = false
        return this
    }

    override val have: ExpectCollection<T> get() {
        words.add("have")
        haveMode = true
        return this
    }

    val contain: ExpectCollection<T> get() {
        words.add("contain")
        haveMode = false
        return this
    }

    fun contain(other: T): ExpectCollection<T> {
        words.add("contain")
        words.add(other.toString())
        verify { subject!!.contains(other) }
        return this
    }

    fun elements(vararg elements: T): ExpectCollection<T> {
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
        if (haveMode && elements.size != subject!!.size) {
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

    val empty: ExpectCollection<T> get() {
        words.add("empty")
        verify { subject!!.isEmpty() }
        return this
    }

    val size: ExpectComparable<Int> get() {
        words.add("size")
        val expectInt = ExpectComparable(subject!!.size, flavor, message)
        expectInt.negated = negated
        expectInt.words.addAll(words)
        expectInt.words.removeAt(0)
        expectInt.words.removeAt(0)
        return expectInt
    }

    fun size(size: Int): ExpectCollection<T> {
        words.add("size")
        words.add(size.toString())
        verify { subject!!.size == size }
        return this
    }

    override val to: ExpectCollection<T> get() {
        super.to
        return this
    }

    override val be: ExpectCollection<T> get() {
        super.be
        return this
    }

    override val been: ExpectCollection<T> get() {
        super.been
        return this
    }

    override val that: ExpectCollection<T> get() {
        super.that
        return this
    }

    override val which: ExpectCollection<T> get() {
        super.which
        return this
    }

    override val and: ExpectCollection<T> get() {
        super.and
        return this
    }

    override val has: ExpectCollection<T> get() {
        super.has
        return this
    }

    override val with: ExpectCollection<T> get() {
        super.with
        return this
    }

    override val at: ExpectCollection<T> get() {
        super.at
        return this
    }

    override val a: ExpectCollection<T> get() {
        super.a
        return this
    }

    override val an: ExpectCollection<T> get() {
        super.an
        return this
    }

    override val of: ExpectCollection<T> get() {
        super.of
        return this
    }

    override val same: ExpectCollection<T> get() {
        super.same
        return this
    }

    override val the: ExpectCollection<T> get() {
        super.the
        return this
    }

    override val `is`: ExpectCollection<T> get() {
        super.`is`
        return this
    }

    override val not: ExpectCollection<T> get() {
        super.not
        return this
    }

    override val `null`: ExpectCollection<T> get() {
        super.`null`
        return this
    }

    override fun <S : Collection<T>> instanceof(type: Class<S>): ExpectCollection<T> {
        super.instanceof(type)
        return this
    }

    override fun identity(expected: Collection<T>?): ExpectCollection<T> {
        super.identity(expected)
        return this
    }

    override fun equal(expected: Collection<T>?): ExpectCollection<T> {
        super.equal(expected)
        return this
    }

    override fun satisfy(predicate: (Collection<T>) -> Boolean): ExpectCollection<T> {
        super.satisfy(predicate)
        return this
    }

    override fun withMessage(message:String): ExpectCollection<T> {
        super.withMessage(message)
        return this
    }
}