package org.winterbe.expekt

import org.junit.Assert

fun fails(fn: () -> Unit) {
    try {
        fn()
        Assert.fail()
    } catch(e: AssertionError) {
        // swallow
    }
}

fun passes(fn: () -> Unit) {
    try {
        fn()
    } catch(e: AssertionError) {
        Assert.fail()
    }
}