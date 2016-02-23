package org.winterbe.expekt

import org.junit.Test

class ExpectMapTest {

    @Test
    fun keysContainAny() {
        val map = mapOf(1 to 1, 2 to 2, 3 to 3)
        passes { expect(map).to.contain.any.keys(1, 2, 3) }
        passes { expect(map).to.contain.any.keys(1, 4) }
        fails("expect {1=1, 2=2, 3=3} to contain any keys [4, 5]") {
            expect(map).to.contain.any.keys(4, 5)
        }
    }

    @Test
    fun keysContainAll() {
        val map = mapOf(1 to 1, 2 to 2, 3 to 3)
        passes { expect(map).to.contain.all.keys(1, 2, 3) }
        passes { expect(map).to.contain.all.keys(1, 2) }
        passes { expect(map).to.contain.all.keys(1) }
        fails("expect {1=1, 2=2, 3=3} to contain all keys [1, 2, 4]") {
            expect(map).to.contain.all.keys(1, 2, 4)
        }
    }

    @Test
    fun keysContainImplicitAll() {
        val map = mapOf(1 to 1, 2 to 2, 3 to 3)
        passes { expect(map).to.contain.keys(1, 2, 3) }
        passes { expect(map).to.contain.keys(1, 2) }
        passes { expect(map).to.contain.keys(1) }
        fails("expect {1=1, 2=2, 3=3} to contain keys [1, 2, 4]") {
            expect(map).to.contain.keys(1, 2, 4)
        }
    }

    @Test
    fun size() {
        passes { expect(mapOf<Int, Int>()).to.be.of.size(0) }
        fails("expect {a=1} to have size 0") { expect(mapOf("a" to 1)).to.have.size(0) }
        passes { mapOf("a" to 1).should.have.size.above(0) }
        fails("{a=1} should have size above 1") { mapOf("a" to 1).should.have.size.above(1) }
    }

    @Test
    fun empty() {
        passes { mapOf<Int, Int>().should.be.empty() }
        fails("{a=1} should be empty") { mapOf("a" to 1).should.be.empty() }
        passes { mapOf(1 to 2).should.not.be.empty() }
    }

}