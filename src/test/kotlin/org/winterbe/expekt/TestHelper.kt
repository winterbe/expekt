package org.winterbe.expekt

import org.hamcrest.CoreMatchers
import org.junit.Assert

fun fails(fn: () -> Unit) {
    try {
        fn()
        Assert.fail()
    } catch(e: AssertionError) {
        // swallow
    }
}

fun fails(message: String, fn: () -> Unit) {
    try {
        fn()
        Assert.fail()
    } catch(e: AssertionError) {
        Assert.assertThat(e.message, CoreMatchers.`is`(message))
    }
}

fun passes(fn: () -> Unit) {
    try {
        fn()
    } catch(e: AssertionError) {
        Assert.fail()
    }
}