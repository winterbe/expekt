package org.expekt

import org.junit.Test

class ExpectBooleanTest {

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

}