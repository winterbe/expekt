package org.winterbe.expekt

import org.junit.Test

class ExpectAnyTest {

    @Test
    fun notSatisfy() {
        data class A(val a: String)
        passes { expect(A("1")).to.not.satisfy { it!!.a == "2" } }
        fails("expect A(a=1) to not satisfy predicate") {
            expect(A("1")).to.not.satisfy { it!!.a == "1" }
        }
    }

    @Test
    fun satisfy() {
        data class A(val a: String)
        passes { expect(A("abc")).to.satisfy { it!!.a == "abc" } }
        fails("expect A(a=abc) to satisfy predicate") {
            expect(A("abc")).to.satisfy { it!!.a == "a" }
        }
    }

    @Test
    fun notNull() {
        data class A(val a: String)
        passes { expect(A("b")).to.not.be.`null` }
        fails("expect null to not be null") {
            expect(null as A?).to.not.be.`null`
        }
    }

    @Test
    fun `null`() {
        data class A(val a: String)
        passes { expect(null as A?).to.be.`null` }
        fails("expect A(a=a) to be null") {
            expect(A("a")).to.be.`null`
        }
    }

    @Test
    fun notInstanceof() {
        open class A
        class B : A()
        fails { expect(A()).not.to.be.instanceof(A::class.java) }
        passes { expect(A()).not.to.be.instanceof(B::class.java) }
    }

    @Test
    fun instanceof() {
        open class A
        class B : A()
        passes { expect(A()).to.be.instanceof(A::class.java) }
        fails { expect(A()).to.be.instanceof(B::class.java) }
    }

    @Test
    fun notIdentity() {
        data class A(val a: String)
        val a1 = A("1")
        val a2 = A("2")
        passes { expect(a1).not.to.be.of.identity(a2) }
        fails("expect A(a=1) not to be of identity A(a=1)") {
            expect(a1).not.to.be.of.identity(a1)
        }
    }

    @Test
    fun identity() {
        data class A(val a: String)
        val a1 = A("1")
        val a2 = A("2")
        passes { expect(a1).to.be.of.identity(a1) }
        fails("expect A(a=1) to be of identity A(a=2)") {
            expect(a1).to.be.of.identity(a2)
        }
    }

    @Test
    fun notEquals() {
        data class A(val a: String)
        val a1 = A("1")
        val a2 = A("1")
        val a3 = A("3")
        passes { expect(a1).to.not.equal(a3) }
        fails("expect A(a=1) to not equal A(a=1)") {
            expect(a1).to.not.equal(a2)
        }
    }

    @Test
    fun equals() {
        data class A(val a: String)
        val a1 = A("1")
        val a2 = A("1")
        val a3 = A("3")
        passes { expect(a1).to.be.equal(a2) }
        fails("expect A(a=1) to equal A(a=3)") {
            expect(a1).to.equal(a3)
        }
    }

    @Test
    fun should() {
        data class A(val a: String)
        val a1 = A("1")
        val a2 = A("1")
        a1.should.equal(a2)
    }

}