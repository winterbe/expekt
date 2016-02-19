package org.winterbe.expekt

import org.junit.Test

class ExpectIntTest {

    @Test
    fun notWithin() {
        fails("expect 3 not to be within 2 4") { expect(3).not.to.be.within(2, 4) }
        fails { expect(3).not.to.be.within(3, 4) }
        fails { expect(3).not.to.be.within(2, 3) }
        passes { expect(3).not.to.be.within(4, 5) }
    }

    @Test
    fun within() {
        passes { expect(3).to.be.within(2, 4) }
        passes { expect(3).to.be.within(3, 4) }
        passes { expect(3).to.be.within(2, 3) }
        fails("expect 3 to be within 4 5") { expect(3).to.be.within(4, 5) }
    }

    @Test
    fun notLeast() {
        passes { expect(3).not.to.be.at.least(4) }
        fails("expect 3 not to be at least 2") { expect(3).not.to.be.at.least(2) }
        fails("expect 3 not to be at least 3") { expect(3).not.to.be.at.least(3) }
    }

    @Test
    fun least() {
        passes { expect(3).to.be.at.least(3) }
        passes { expect(3).to.be.at.least(2) }
        fails("expect 3 to be at least 4") { expect(3).to.be.at.least(4) }
    }

    @Test
    fun notMost() {
        passes { expect(3).not.to.be.at.most(2) }
        fails("expect 3 not to be at most 4") { expect(3).not.to.be.at.most(4) }
        fails("expect 3 not to be at most 3") { expect(3).not.to.be.at.most(3) }
    }

    @Test
    fun most() {
        passes { expect(3).to.be.at.most(3) }
        passes { expect(3).to.be.at.most(4) }
        fails("expect 3 to be at most 2") { expect(3).to.be.at.most(2) }
    }

    @Test
    fun notBelow() {
        passes { expect(3).not.to.be.below(3) }
        fails("expect 2 not to be below 3") { expect(2).not.to.be.below(3) }
    }

    @Test
    fun below() {
        passes { expect(2).to.be.below(3) }
        fails("expect 3 to be below 3") { expect(3).to.be.below(3) }
    }

    @Test
    fun notAbove() {
        passes { expect(3).not.to.be.above(3) }
        fails("expect 3 not to be above 2") { expect(3).not.to.be.above(2) }
    }

    @Test
    fun above() {
        passes { expect(3).to.be.above(2) }
        fails("expect 3 to be above 3") { expect(3).to.be.above(3) }
    }

    @Test
    fun aboveBelow() {
        passes { expect(3).to.be.above(2).and.to.be.below(4) }
    }

}