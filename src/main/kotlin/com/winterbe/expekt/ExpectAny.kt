package com.winterbe.expekt

/**
 * Expectation context for any kind of value. Every specific expectation context extends from this context.
 *
 * @author Benjamin Winterberg
 */
open class ExpectAny<T>(protected val subject: T?, protected val flavor: Flavor, protected var message: String? = null) {

    internal val words = arrayListOf<String>()

    internal var negated = false

    init {
        when (flavor) {
            Flavor.EXPECT -> {
                words.add("expect")
                words.add(subject.toString())
            }
            Flavor.SHOULD -> {
                words.add(subject.toString())
                words.add("should")
            }
        }
    }

    /**
     * Negate this expectation.
     */
    open val not: ExpectAny<T> get() {
        negated = !negated
        words.add("not")
        return this
    }

    /**
     * Assert that the subject of this expectation is `null`.
     */
    open val `null`: ExpectAny<T> get() {
        words.add("null")
        verify { subject == null }
        return this
    }

    /**
     * Assert that the subject of this expectation is an instance of the given type.
     */
    open fun <S : T> instanceof(type: Class<S>): ExpectAny<T> {
        words.add("instanceof")
        words.add(type.toString())
        verify { type.isInstance(subject) }
        return this
    }

    /**
     * Assert that the subject of this expectation is of the same identity as the given value,
     * such as the following is true: `subject === expected`
     */
    open fun identity(expected: T?): ExpectAny<T> {
        words.add("identity")
        words.add(expected.toString())
        verify { subject === expected }
        return this
    }

    open fun withMessage(message:String): ExpectAny<T> {
        this.message = message
        return this
    }

    /**
     * Assert that the subject of this expectation is equal to the given value,
     * such as the following is true: `subject == expected`
     */
    open fun equal(expected: T?): ExpectAny<T> {
        words.add("equal")
        words.add(expected.toString())
        verify { subject == expected }
        return this
    }

    /**
     * Assert that the given predicate evaluates to true.
     */
    open fun satisfy(predicate: (a: T) -> Boolean): ExpectAny<T> {
        words.add("satisfy")
        words.add("predicate")
        verify { predicate(subject!!) }
        return this
    }

    /**
     * Verifies that the given predicates evaluates to true, otherwise throws an `AssertionError`.
     */
    protected fun verify(rule: () -> Boolean) {
        val truthy = rule()
        if (!truthy && !negated) {
            fail()
        }
        if (truthy && negated) {
            fail()
        }
    }

    private fun fail() {

        val message = if(this.message!=null) this.message else words.joinToString(separator = " ")
        throw AssertionError(message)
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val to: ExpectAny<T> get() {
        words.add("to")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val be: ExpectAny<T> get() {
        words.add("be")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val been: ExpectAny<T> get() {
        words.add("been")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val that: ExpectAny<T> get() {
        words.add("that")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val which: ExpectAny<T> get() {
        words.add("which")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val and: ExpectAny<T> get() {
        words.add("and")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val has: ExpectAny<T> get() {
        words.add("has")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val have: ExpectAny<T> get() {
        words.add("have")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val with: ExpectAny<T> get() {
        words.add("with")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val at: ExpectAny<T> get() {
        words.add("at")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val a: ExpectAny<T> get() {
        words.add("a")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val an: ExpectAny<T> get() {
        words.add("an")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val of: ExpectAny<T> get() {
        words.add("of")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val same: ExpectAny<T> get() {
        words.add("same")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val the: ExpectAny<T> get() {
        words.add("the")
        return this
    }

    /**
     * Language chain without any further semantical meaning.
     */
    open val `is`: ExpectAny<T> get() {
        words.add("is")
        return this
    }

}