package com.winterbe.expekt

import org.junit.Test

class ExpectSequenceTest {

    @Test
    fun elementsHaveAny() {
        passes { expect(sequenceOf(1, 2, 3)).to.contain.any.elements(1, 2, 3) }
        passes { expect(sequenceOf(1, 2, 3)).to.contain.any.elements(1, 4) }
        fails("expect [1, 2, 3] to contain any elements [4, 5]") {
            expect(sequenceOf(1, 2, 3)).to.contain.any.elements(4, 5)
        }
    }

    @Test
    fun elementsHaveAll() {
        passes { expect(sequenceOf(1, 2, 3)).to.have.all.elements(1, 2, 3) }
        fails("expect [1, 2, 3] to have all elements [1, 2]") { expect(sequenceOf(1, 2, 3)).to.have.all.elements(1, 2) }
        fails { expect(sequenceOf(1, 2, 3)).to.have.all.elements(1) }
        fails { expect(sequenceOf(1, 2, 3)).to.have.all.elements(1, 2, 3, 4) }
    }

    @Test
    fun elementsHaveImplicitAll() {
        passes { expect(sequenceOf(1, 2, 3)).to.have.elements(1, 2, 3) }
        fails("expect [1, 2, 3] to have elements [1, 2]") { expect(sequenceOf(1, 2, 3)).to.have.elements(1, 2) }
        fails { expect(sequenceOf(1, 2, 3)).to.have.elements(1) }
        fails { expect(sequenceOf(1, 2, 3)).to.have.elements(1, 2, 3, 4) }
    }

    @Test
    fun elementsContainAny() {
        passes { expect(sequenceOf(1, 2, 3)).to.contain.any.elements(1, 2, 3) }
        passes { expect(sequenceOf(1, 2, 3)).to.contain.any.elements(1, 4) }
        fails("expect [1, 2, 3] to contain any elements [4, 5]") {
            expect(sequenceOf(1, 2, 3)).to.contain.any.elements(4, 5)
        }
    }

    @Test
    fun elementsContainAll() {
        passes { expect(sequenceOf(1, 2, 3)).to.contain.all.elements(1, 2, 3) }
        passes { expect(sequenceOf(1, 2, 3)).to.contain.all.elements(1, 2) }
        passes { expect(sequenceOf(1, 2, 3)).to.contain.all.elements(1) }
        fails("expect [1, 2, 3] to contain all elements [1, 2, 4]") {
            expect(sequenceOf(1, 2, 3)).to.contain.all.elements(1, 2, 4)
        }
    }

    @Test
    fun elementsContainImplicitAll() {
        passes { expect(sequenceOf(1, 2, 3)).to.contain.elements(1, 2, 3) }
        passes { expect(sequenceOf(1, 2, 3)).to.contain.elements(1, 2) }
        passes { expect(sequenceOf(1, 2, 3)).to.contain.elements(1) }
        fails("expect [1, 2, 3] to contain elements [1, 2, 4]") {
            expect(sequenceOf(1, 2, 3)).to.contain.elements(1, 2, 4)
        }
    }

    @Test
    fun containsLength() {
        passes { expect(sequenceOf(1, 2, 3)).to.contain(3).and.to.have.size.above(2) }
    }

    @Test
    fun notContain() {
        passes { expect(sequenceOf(1, 2, 3)).not.to.contain(4) }
        fails("expect [1, 2, 3] not to contain 3") {
            expect(sequenceOf(1, 2, 3)).not.to.contain(3)
        }
    }

    @Test
    fun contain() {
        passes { expect(sequenceOf(1, 2, 3)).to.contain(1) }
        fails("expect [1, 2, 3] to contain 4") { expect(sequenceOf(1, 2, 3)).to.contain(4) }
    }

    @Test
    fun notSizeProp() {
        passes { expect(sequenceOf(1, 2, 3)).not.to.have.size.above(3) }
        fails("expect [1, 2, 3] not to have size below 4") {
            expect(sequenceOf(1, 2, 3)).not.to.have.size.below(4)
        }
    }

    @Test
    fun sizeProp() {
        passes { expect(sequenceOf(1, 2, 3)).to.have.size.above(2) }
        fails("expect [1, 2, 3] to have size equal 4") {
            expect(sequenceOf(1, 2, 3)).to.have.size.equal(4)
        }
    }

    @Test
    fun notSize() {
        passes { expect(sequenceOf(1, 2, 3)).not.to.have.size(4) }
        fails("expect [1, 2, 3] not to have size 3") { expect(sequenceOf(1, 2, 3)).not.to.have.size(3) }
    }

    @Test
    fun size() {
        passes { expect(sequenceOf(1, 2, 3)).to.have.size(3) }
        fails("expect [1, 2, 3] to have size 4") { expect(sequenceOf(1, 2, 3)).to.have.size(4) }
    }

    @Test
    fun notEmpty() {
        passes { expect(sequenceOf(1, 2, 3)).not.to.be.empty }
        fails("expect [] not to be empty") {
            expect(sequenceOf<Int>()).not.to.be.empty
        }
    }

    @Test
    fun empty() {
        passes { expect(sequenceOf<Int>()).to.be.empty }
        fails("expect [1, 2, 3] to be empty") {
            expect(sequenceOf(1, 2, 3)).to.be.empty
        }
    }

    @Test
    fun notEquals() {
//        passes { expect(sequenceOf(1, 2, 3)).not.to.equal(sequenceOf(1, 2, 3, 4)) }
//        fails("expect [1, 2, 3] not to equal [1, 2, 3]") {
//            expect(sequenceOf(1, 2, 3)).not.to.equal(sequenceOf(1, 2, 3))
//        }
    }

    @Test
    fun equals() {
//        passes { expect(sequenceOf(1, 2, 3)).to.equal(sequenceOf(1, 2, 3)) }
//        fails("expect [1, 2, 3] to equal [1, 2, 3, 4]") {
//            expect(sequenceOf(1, 2, 3)).to.equal(sequenceOf(1, 2, 3, 4))
//        }
    }

    @Test
    fun `null`() {
        passes { expect(null as Sequence<Int>?).to.be.`null` }
        fails("expect [1, 2, 3] to be null") {
            expect(sequenceOf(1, 2, 3)).to.be.`null`
        }
    }

    @Test
    fun should() {
        sequenceOf(1, 2, 3).should.contain.all.elements(1, 2)
    }

}