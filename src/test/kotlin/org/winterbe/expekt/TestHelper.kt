package org.winterbe.expekt

import org.hamcrest.CoreMatchers
import org.junit.Assert

fun fails(fn: () -> Unit) {
    var failed = false
    try {
        fn()
    } catch(e: AssertionError) {
        failed = true
    }

    if (!failed) {
        throw IllegalStateException("fn did not fail")
    }
}

fun fails(message: String, fn: () -> Unit) {
    var failed = false
    try {
        fn()
    } catch(e: AssertionError) {
        Assert.assertThat(e.message, CoreMatchers.`is`(message))
        failed = true
    }

    if (!failed) {
        throw IllegalStateException("fn did not fail")
    }
}

fun passes(fn: () -> Unit) {
    try {
        fn()
    } catch(e: AssertionError) {
        throw IllegalStateException("fn did not pass", e)
    }
}