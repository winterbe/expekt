package org.expekt

import org.junit.Assert.fail
import org.junit.Test

class ExpectTest {

    @Test
    fun notFalse2() {
        fails { expect(false).not.to.be.`false` }
    }

    @Test
    fun notFalse1() {
        passes { expect(true).not.to.be.`false` }
    }

    @Test
    fun false2() {
        fails { expect(true).to.be.`false` }
    }

    @Test
    fun false1() {
        passes { expect(false).to.be.`false` }
    }

    @Test
    fun notTrue2() {
        fails { expect(true).not.to.be.`true` }
    }

    @Test
    fun notTrue1() {
        passes { expect(false).not.to.be.`true` }
    }

    @Test
    fun true2() {
        fails { expect(false).to.be.`true` }
    }

    @Test
    fun true1() {
        passes { expect(true).to.be.`true` }
    }

    @Test
    fun notSatisfy2() {
        passes { expect(3).to.not.satisfy { it == 4 } }
    }

    @Test
    fun notSatisfy1() {
        fails { expect("abc").to.not.satisfy { it!!.startsWith("b") } }
    }

    @Test
    fun satisfy3() {
        passes { expect(3).to.satisfy { it!! > 2 } }
    }

    @Test
    fun satisfy2() {
        fails { expect(3).to.satisfy { it == 4 } }
    }

    @Test
    fun satisfy1() {
        passes { expect("abc").to.satisfy { it!!.startsWith("a") } }
    }

    @Test
    fun notNull2() {
        fails { expect(null).to.not.be.`null` }
    }

    @Test
    fun notNull1() {
        passes { expect("abc").to.not.be.`null` }
    }

    @Test
    fun null2() {
        fails { expect(3).to.be.`null` }
    }

    @Test
    fun null1() {
        passes { expect(null).to.be.`null` }
    }

    @Test
    fun notEquals2() {
        fails { expect(1).to.not.equal(1) }
    }

    @Test
    fun notEquals1() {
        passes { expect(1).to.not.equal(2) }
    }

    @Test
    fun equals3() {
        passes { expect("").to.be.equal("") }
    }

    @Test
    fun equals2() {
        fails { expect(3).to.equal(4) }
    }

    @Test
    fun equals1() {
        passes { expect(3).to.equal(3) }
    }

    fun fails(fn: () -> Unit) {
        try {
            fn()
            fail()
        } catch(e: AssertionError) {
            // swallow
        }
    }

    fun passes(fn: () -> Unit) {
        try {
            fn()
        } catch(e: AssertionError) {
            fail()
        }
    }

}