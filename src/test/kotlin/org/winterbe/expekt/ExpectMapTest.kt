package org.winterbe.expekt

import org.junit.Test

class ExpectMapTest {

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