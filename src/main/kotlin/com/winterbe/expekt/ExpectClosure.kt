package com.winterbe.expekt

import kotlin.reflect.KClass

/**
 * Expectation context for any kind of value. Every specific expectation context extends from this context.
 *
 * @author Yoichiro Sakurai
 */
class ExpectClosure(protected val subject: () -> Unit, protected val flavor: Flavor) {

    internal val words = arrayListOf<String>()

    init {
        when (flavor) {
            Flavor.EXPECT -> {
                words.add("expect")
                words.add("closure")
            }
            Flavor.SHOULD -> {
                words.add("closure")
                words.add("should")
            }
        }
    }

    fun <T : Throwable> raise(expected: KClass<T>): ExpectClosure {
        var success = false
        val expectedClass = expected.java
        var actual: Throwable? = null

        words.add("raise")
        words.add(expectedClass.toString())

        try {
            subject()
        } catch (t: Throwable) {
            success = expectedClass.equals(t.javaClass)
            if (!success) actual = t
        } finally {
            if (!success) fail(actual)
        }

        return this
    }

    fun raiseAny(): ExpectClosure {
        var success = false

        words.add("raise")
        words.add("some exception")

        try {
            subject()
        } catch (t: Throwable) {
            success = true
        } finally {
            if (!success) fail(null)
        }

        return this
    }

    private fun fail(actual: Throwable?) {
        actual?.let {
            words.add("but actual thrown")
            words.add(it.javaClass.toString())
        } ?: fun() {
            words.add("but nothing to thrown")
        }()

        val message = words.joinToString(separator = " ")
        throw AssertionError(message)
    }
}
