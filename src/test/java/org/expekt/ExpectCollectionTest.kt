package org.expekt

import org.junit.Test

class ExpectCollectionTest {

    @Test
    fun containsLength() {
        passes { expect(listOf(1, 2, 3)).to.contain(3).and.to.have.length.above(2) }
    }

    @Test
    fun notContain2() {
        fails { expect(listOf(1, 2, 3)).not.to.contain(3) }
    }

    @Test
    fun notContain1() {
        passes { expect(listOf(1, 2, 3)).not.to.contain(4) }
    }

    @Test
    fun contain2() {
        fails { expect(listOf(1, 2, 3)).to.contain(4) }
    }

    @Test
    fun contain1() {
        passes { expect(listOf(1, 2, 3)).to.contain(1) }
    }

    @Test
    fun notLengthProp2() {
        fails { expect(listOf(1, 2, 3)).not.to.have.length.below(2) }
    }

    @Test
    fun notLengthProp1() {
        passes { expect(listOf(1, 2, 3)).not.to.have.length.above(3) }
    }

    @Test
    fun lengthProp2() {
        fails { expect(listOf(1, 2, 3)).to.have.length.equal(4) }
    }

    @Test
    fun lengthProp1() {
        passes { expect(listOf(1, 2, 3)).to.have.length.above(2) }
    }

    @Test
    fun notLength2() {
        fails { expect(listOf(1, 2, 3)).not.to.have.length(3) }
    }

    @Test
    fun notLength1() {
        passes { expect(listOf(1, 2, 3)).not.to.have.length(4) }
    }

    @Test
    fun length2() {
        fails { expect(listOf(1, 2, 3)).to.have.length(4) }
    }

    @Test
    fun length1() {
        passes { expect(listOf(1, 2, 3)).to.have.length(3) }
    }

    @Test
    fun notEmpty2() {
        fails { expect(listOf<Int>()).not.to.be.empty() }
    }

    @Test
    fun notEmpty1() {
        passes { expect(listOf(1, 2, 3)).not.to.be.empty() }
    }

    @Test
    fun empty2() {
        fails { expect(listOf(1, 2, 3)).to.be.empty() }
    }

    @Test
    fun empty1() {
        passes { expect(listOf<Int>()).to.be.empty() }
    }

    @Test
    fun notEquals2() {
        fails { expect(listOf(1, 2, 3)).not.to.equal(listOf(1, 2, 3)) }
    }

    @Test
    fun notEquals1() {
        passes { expect(listOf(1, 2, 3)).not.to.equal(listOf(1, 2, 3, 4)) }
    }

    @Test
    fun equals2() {
        fails { expect(listOf(1, 2, 3)).to.equal(listOf(1, 2, 3, 4)) }
    }

    @Test
    fun equals1() {
        passes { expect(listOf(1, 2, 3)).to.equal(listOf(1, 2, 3)) }
    }

}