package org.winterbe.expekt

import org.junit.Test

class ExpectCollectionTest {

    @Test
    fun elementsHaveAny() {
        passes { expect(listOf(1, 2, 3)).to.contain.any.elements(1, 2, 3) }
        passes { expect(listOf(1, 2, 3)).to.contain.any.elements(1, 4) }
        fails("expect [1, 2, 3] to contain any elements [4, 5]") {
            expect(listOf(1, 2, 3)).to.contain.any.elements(4, 5)
        }
    }

    @Test
    fun elementsHaveAll() {
        passes { expect(listOf(1, 2, 3)).to.have.all.elements(1, 2, 3) }
        fails("expect [1, 2, 3] to have all elements [1, 2]") { expect(listOf(1, 2, 3)).to.have.all.elements(1, 2) }
        fails { expect(listOf(1, 2, 3)).to.have.all.elements(1) }
        fails { expect(listOf(1, 2, 3)).to.have.all.elements(1, 2, 3, 4) }
    }

    @Test
    fun elementsHaveImplicitAll() {
        passes { expect(listOf(1, 2, 3)).to.have.elements(1, 2, 3) }
        fails("expect [1, 2, 3] to have elements [1, 2]") { expect(listOf(1, 2, 3)).to.have.elements(1, 2) }
        fails { expect(listOf(1, 2, 3)).to.have.elements(1) }
        fails { expect(listOf(1, 2, 3)).to.have.elements(1, 2, 3, 4) }
    }

    @Test
    fun elementsContainAny() {
        passes { expect(listOf(1, 2, 3)).to.contain.any.elements(1, 2, 3) }
        passes { expect(listOf(1, 2, 3)).to.contain.any.elements(1, 4) }
        fails("expect [1, 2, 3] to contain any elements [4, 5]") {
            expect(listOf(1, 2, 3)).to.contain.any.elements(4, 5)
        }
    }

    @Test
    fun elementsContainAll() {
        passes { expect(listOf(1, 2, 3)).to.contain.all.elements(1, 2, 3) }
        passes { expect(listOf(1, 2, 3)).to.contain.all.elements(1, 2) }
        passes { expect(listOf(1, 2, 3)).to.contain.all.elements(1) }
        fails("expect [1, 2, 3] to contain all elements [1, 2, 4]") {
            expect(listOf(1, 2, 3)).to.contain.all.elements(1, 2, 4)
        }
    }

    @Test
    fun elementsContainImplicitAll() {
        passes { expect(listOf(1, 2, 3)).to.contain.elements(1, 2, 3) }
        passes { expect(listOf(1, 2, 3)).to.contain.elements(1, 2) }
        passes { expect(listOf(1, 2, 3)).to.contain.elements(1) }
        fails("expect [1, 2, 3] to contain elements [1, 2, 4]") {
            expect(listOf(1, 2, 3)).to.contain.elements(1, 2, 4)
        }
    }

    @Test
    fun containsLength() {
        passes { expect(listOf(1, 2, 3)).to.contain(3).and.to.have.size.above(2) }
    }

    @Test
    fun notContain() {
        passes { expect(listOf(1, 2, 3)).not.to.contain(4) }
        fails("expect [1, 2, 3] not to contain 3") {
            expect(listOf(1, 2, 3)).not.to.contain(3)
        }
    }

    @Test
    fun contain() {
        passes { expect(listOf(1, 2, 3)).to.contain(1) }
        fails("expect [1, 2, 3] to contain 4") { expect(listOf(1, 2, 3)).to.contain(4) }
    }

    @Test
    fun notSizeProp() {
        passes { expect(listOf(1, 2, 3)).not.to.have.size.above(3) }
        fails("expect [1, 2, 3] not to have size below 4") {
            expect(listOf(1, 2, 3)).not.to.have.size.below(4)
        }
    }

    @Test
    fun sizeProp() {
        passes { expect(listOf(1, 2, 3)).to.have.size.above(2) }
        fails("expect [1, 2, 3] to have size equal 4") {
            expect(listOf(1, 2, 3)).to.have.size.equal(4)
        }
    }

    @Test
    fun notSize() {
        passes { expect(listOf(1, 2, 3)).not.to.have.size(4) }
        fails("expect [1, 2, 3] not to have size 3") { expect(listOf(1, 2, 3)).not.to.have.size(3) }
    }

    @Test
    fun size() {
        passes { expect(listOf(1, 2, 3)).to.have.size(3) }
        fails("expect [1, 2, 3] to have size 4") { expect(listOf(1, 2, 3)).to.have.size(4) }
    }

    @Test
    fun notEmpty1() {
        passes { expect(listOf(1, 2, 3)).not.to.be.empty() }
        fails("expect [] not to be empty") {
            expect(listOf<Int>()).not.to.be.empty()
        }
    }

    @Test
    fun empty1() {
        passes { expect(listOf<Int>()).to.be.empty() }
        fails("expect [1, 2, 3] to be empty") {
            expect(listOf(1, 2, 3)).to.be.empty()
        }
    }

    @Test
    fun notEquals() {
        passes { expect(listOf(1, 2, 3)).not.to.equal(listOf(1, 2, 3, 4)) }
        fails("expect [1, 2, 3] not to equal [1, 2, 3]") {
            expect(listOf(1, 2, 3)).not.to.equal(listOf(1, 2, 3))
        }
    }

    @Test
    fun equals() {
        passes { expect(listOf(1, 2, 3)).to.equal(listOf(1, 2, 3)) }
        fails("expect [1, 2, 3] to equal [1, 2, 3, 4]") {
            expect(listOf(1, 2, 3)).to.equal(listOf(1, 2, 3, 4))
        }
    }

    @Test
    fun should() {
        listOf(1, 2, 3).should.contain.all.elements(1, 2)
    }

}