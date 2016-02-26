package com.winterbe.expekt

import org.junit.Test

class ExpectDoubleTest {

    @Test
    fun notCloseTo() {
        passes { expect(3.4).not.to.be.closeTo(3.2, 0.1) }
        fails { expect(3.4).not.to.be.closeTo(3.3, 0.1) }
    }

    @Test
    fun closeTo() {
        passes { 3.4.should.be.closeTo(3.4) }
        passes { 3.4.should.be.closeTo(3.3, 0.1) }
        passes { 3.4.should.be.closeTo(3.5, 0.1) }
        fails("3.4 should be closeTo 3.2 ±0.1") { 3.4.should.be.closeTo(3.2, delta = 0.1) }
    }

}