package org.expekt

import org.junit.Test

class ExpectIntTest {

    @Test
    fun notBelow2() {
        fails { expect(2).not.to.be.below(3) }
    }

    @Test
    fun notBelow1() {
        passes { expect(3).not.to.be.below(3) }
    }

    @Test
    fun below2() {
        fails { expect(3).to.be.below(3) }
    }

    @Test
    fun below1() {
        passes { expect(2).to.be.below(3) }
    }

    @Test
    fun notAbove2() {
        fails { expect(3).not.to.be.above(2) }
    }

    @Test
    fun notAbove1() {
        passes { expect(3).not.to.be.above(3) }
    }

    @Test
    fun above2() {
        fails { expect(3).to.be.above(3) }
    }

    @Test
    fun above1() {
        passes { expect(3).to.be.above(2) }
    }

    @Test
    fun aboveBelow() {
        passes { expect(3).to.be.above(2).and.to.be.below(4) }
    }

}