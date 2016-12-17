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

        words.add("raise")
        words.add(expectedClass.toString())

        try {
            subject()
        } catch (e: Exception) {
            success = expectedClass.equals(e.javaClass)
        } finally {
            if (!success) fail()
        }

        return this
    }

    fun raiseAny(): ExpectClosure {
        var success = false

        words.add("raise")
        words.add("some exception")

        try {
            subject()
        } catch (e: Exception) {
            success = true
        } finally {
            if (!success) fail()
        }

        return this
    }

    private fun fail() {
        val message = words.joinToString(separator = " ")
        throw AssertionError(message)
    }
}
