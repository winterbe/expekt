package org.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectCollection<T>(subject: Collection<T>): ExpectAny<Collection<T>>(subject) {
    override val to: ExpectCollection<T> get() = this
    override val be: ExpectCollection<T> get() = this
    override val been: ExpectCollection<T> get() = this
    override val that: ExpectCollection<T> get() = this
    override val which: ExpectCollection<T> get() = this
    override val and: ExpectCollection<T> get() = this
    override val has: ExpectCollection<T> get() = this
    override val with: ExpectCollection<T> get() = this
    override val at: ExpectCollection<T> get() = this
    override val a: ExpectCollection<T> get() = this
    override val an: ExpectCollection<T> get() = this
    override val of: ExpectCollection<T> get() = this
    override val same: ExpectCollection<T> get() = this
    override val the: ExpectCollection<T> get() = this
    override val `is`: ExpectCollection<T> get() = this

    private var anyMode = false
    private var haveMode = false

    val any: ExpectCollection<T> get() {
        anyMode = true
        return this
    }

    val all: ExpectCollection<T> get() {
        anyMode = false
        return this
    }

    override val have: ExpectCollection<T> get() {
        haveMode = true
        return this
    }

    val contain: ExpectCollection<T> get() {
        haveMode = false
        return this
    }

    fun contain(other: T): ExpectCollection<T> {
        verify { value!!.contains(other) }
        return this
    }

    fun elements(vararg elements: T): ExpectCollection<T> {
        if (anyMode) {
            verify { containsAny(elements) }
        } else {
            verify { containsAll(elements) }
        }
        return this
    }

    private fun containsAll(elements: Array<out T>): Boolean {
        if (haveMode && elements.size != value!!.size) {
            return false
        }
        for (element in elements) {
            if (!value!!.contains(element)) {
                return false
            }
        }
        return true
    }

    private fun containsAny(elements: Array<out T>): Boolean {
        if (haveMode && elements.size != value!!.size) {
            return false
        }
        for (element in elements) {
            if (value!!.contains(element)) {
                return true
            }
        }
        return false
    }

    override val not: ExpectCollection<T> get() {
        super.not
        return this
    }

    override val `null`: ExpectCollection<T> get() {
        super.`null`
        return this
    }

    fun empty(): ExpectCollection<T> {
        verify { value!!.isEmpty() }
        return this
    }

    val size: ExpectInt get() {
        val expectInt = ExpectInt(value!!.size)
        if (negated) {
            return expectInt.not
        }
        return expectInt
    }

    fun size(size: Int): ExpectCollection<T> {
        verify { value!!.size == size }
        return this
    }



}