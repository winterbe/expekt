package org.expekt

import org.junit.Test

class ExpectAnyTest {

    @Test
    fun notSatisfy2() {
        passes { expect(3).to.not.satisfy { it == 4 } }
    }

    @Test
    fun notSatisfy1() {
        fails { expect("abc").to.not.satisfy { it.startsWith("b") } }
    }

    @Test
    fun satisfy3() {
        passes { expect(3).to.satisfy { it > 2 } }
    }

    @Test
    fun satisfy2() {
        fails { expect(3).to.satisfy { it == 4 } }
    }

    @Test
    fun satisfy1() {
        passes { expect("abc").to.satisfy { it.startsWith("a") } }
    }

    @Test
    fun notNull2() {
        fails { expect(null as Int?).to.not.be.`null` }
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
        passes { expect(null as Int?).to.be.`null` }
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

}