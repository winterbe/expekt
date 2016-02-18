package org.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
open class ExpectAny<T>(val value: T?) {

    protected val words = arrayListOf<String>()

    protected var negated = false

    open val not: ExpectAny<T> get() {
        negated = !negated
        words.add("not")
        return this
    }

    open val `null`: ExpectAny<T> get() {
        words.add("null")
        verify { value == null }
        return this
    }

    fun <S: T> instanceof(type: Class<S>) {
        words.add("instanceof")
        words.add(type.toString())
        verify { type.isInstance(value) }
    }

    fun identity(other: T?) {
        words.add("identity")
        words.add(other.toString())
        verify { value === other }
    }

    fun equal(other: T?) {
        words.add("equal")
        words.add(other.toString())
        verify { value == other }
    }

    fun satisfy(predicate: (a: T) -> Boolean) {
        words.add("satisfy")
        words.add("predicate")
        verify { predicate(value!!) }
    }

    protected fun verify(rule: () -> Boolean) {
        val truthy = rule()
        if (!truthy && !negated) {
            throwError()
        }
        if (truthy && negated) {
            throwError()
        }
    }

    private fun throwError() {
        words.add(0, value.toString())
        words.add(0, "expect")
        val msg = words.joinToString(separator = " ")
        throw AssertionError(msg)
    }

    open val to: ExpectAny<T> get() {
        words.add("to")
        return this
    }

    open val be: ExpectAny<T> get() {
        words.add("be")
        return this
    }

    open val been: ExpectAny<T> get() {
        words.add("been")
        return this
    }

    open val that: ExpectAny<T> get() {
        words.add("that")
        return this
    }

    open val which: ExpectAny<T> get() {
        words.add("which")
        return this
    }

    open val and: ExpectAny<T> get() {
        words.add("and")
        return this
    }

    open val has: ExpectAny<T> get() {
        words.add("has")
        return this
    }

    open val have: ExpectAny<T> get() {
        words.add("have")
        return this
    }

    open val with: ExpectAny<T> get() {
        words.add("with")
        return this
    }

    open val at: ExpectAny<T> get() {
        words.add("at")
        return this
    }

    open val a: ExpectAny<T> get() {
        words.add("a")
        return this
    }

    open val an: ExpectAny<T> get() {
        words.add("an")
        return this
    }

    open val of: ExpectAny<T> get() {
        words.add("of")
        return this
    }

    open val same: ExpectAny<T> get() {
        words.add("same")
        return this
    }

    open val the: ExpectAny<T> get() {
        words.add("the")
        return this
    }

    open val `is`: ExpectAny<T> get() {
        words.add("is")
        return this
    }

}