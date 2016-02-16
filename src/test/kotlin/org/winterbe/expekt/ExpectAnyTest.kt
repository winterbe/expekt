package org.winterbe.expekt

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
    fun notNull() {
        passes { expect("abc").to.not.be.`null` }
        fails { expect(null as Int?).to.not.be.`null` }
    }

    @Test
    fun `null`() {
        passes { expect(null as Int?).to.be.`null` }
        fails { expect(3).to.be.`null` }
    }

    @Test
    fun notAn() {
        open class A
        class B : A()
        fails { expect(A()).not.to.be.an(A::class.java) }
        passes { expect(A()).not.to.be.an(B::class.java) }
    }

    @Test
    fun an() {
        open class A
        class B : A()
        passes { expect(A()).to.be.an(A::class.java) }
        fails { expect(A()).to.be.an(B::class.java) }
    }

    @Test
    fun notA() {
        open class A
        class B : A()
        fails { expect(A()).not.to.be.a(A::class.java) }
        passes { expect(A()).not.to.be.a(B::class.java) }
    }

    @Test
    fun a() {
        open class A
        class B: A()
        passes { expect(A()).to.be.a(A::class.java) }
        fails { expect(A()).to.be.a(B::class.java) }
    }

    @Test
    fun notIdentity() {
        val obj1 = Object()
        val obj2 = Object()
        fails { expect(obj1).not.to.be.of.identity(obj1) }
        passes { expect(obj1).not.to.be.of.identity(obj2) }
    }

    @Test
    fun identity() {
        val obj1 = Object()
        val obj2 = Object()
        passes { expect(obj1).to.be.of.identity(obj1) }
        fails { expect(obj1).to.be.of.identity(obj2) }
    }

    @Test
    fun notEquals() {
        fails { expect(1).to.not.equal(1) }
        passes { expect(1).to.not.equal(2) }
    }

    @Test
    fun equals() {
        passes { expect("").to.be.equal("") }
        fails { expect(3).to.equal(4) }
        passes { expect(3).to.equal(3) }
    }

}