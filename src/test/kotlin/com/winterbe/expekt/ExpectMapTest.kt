package com.winterbe.expekt

import org.junit.Test

class ExpectMapTest {

    @Test
    fun contain() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { map.should.contain(1 to 11).and.contain(2 to 22).and.not.contain(3 to 55) }
        fails("{1=11, 2=22, 3=33} should contain (2, 23)") {
            map.should.contain(2 to 23)
        }
    }

    @Test
    fun valuesHaveAny() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.contain.any.values(11, 22, 33) }
        passes { expect(map).to.contain.any.values(11, 44) }
        fails("expect {1=11, 2=22, 3=33} to contain any values [44, 55]") {
            expect(map).to.contain.any.values(44, 55)
        }
    }

    @Test
    fun valuesHaveAll() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.have.all.values(11, 22, 33) }
        fails("expect {1=11, 2=22, 3=33} to have all values [11, 22]") { expect(map).to.have.all.values(11, 22) }
        fails { expect(map).to.have.all.values(11) }
        fails { expect(map).to.have.all.values(11, 22, 33, 44) }
    }

    @Test
    fun valuesHaveImplicitAll() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.have.values(11, 22, 33) }
        fails("expect {1=11, 2=22, 3=33} to have values [11, 22]") { expect(map).to.have.values(11, 22) }
        fails { expect(map).to.have.values(11) }
        fails { expect(map).to.have.values(11, 22, 33, 44) }
    }

    @Test
    fun valuesContainAny() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.contain.any.values(11, 22, 33) }
        passes { expect(map).to.contain.any.values(11, 44) }
        fails("expect {1=11, 2=22, 3=33} to contain any values [44, 55]") {
            expect(map).to.contain.any.values(44, 55)
        }
    }

    @Test
    fun valuesContainAll() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.contain.all.values(11, 22, 33) }
        passes { expect(map).to.contain.all.values(11, 22) }
        passes { expect(map).to.contain.all.values(11) }
        fails("expect {1=11, 2=22, 3=33} to contain all values [11, 22, 44]") {
            expect(map).to.contain.all.values(11, 22, 44)
        }
    }

    @Test
    fun valuesContainImplicitAll() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.contain.values(11, 22, 33) }
        passes { expect(map).to.contain.values(11, 22) }
        passes { expect(map).to.contain.values(11) }
        fails("expect {1=11, 2=22, 3=33} to contain values [11, 22, 44]") {
            expect(map).to.contain.values(11, 22, 44)
        }
    }

    @Test
    fun keysHaveAny() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.contain.any.keys(1, 2, 3) }
        passes { expect(map).to.contain.any.keys(1, 4) }
        fails("expect {1=11, 2=22, 3=33} to contain any keys [4, 5]") {
            expect(map).to.contain.any.keys(4, 5)
        }
    }

    @Test
    fun keysHaveAll() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.have.all.keys(1, 2, 3) }
        fails("expect {1=11, 2=22, 3=33} to have all keys [1, 2]") { expect(map).to.have.all.keys(1, 2) }
        fails { expect(map).to.have.all.keys(1) }
        fails { expect(map).to.have.all.keys(1, 2, 3, 4) }
    }

    @Test
    fun keysHaveImplicitAll() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.have.keys(1, 2, 3) }
        fails("expect {1=11, 2=22, 3=33} to have keys [1, 2]") { expect(map).to.have.keys(1, 2) }
        fails { expect(map).to.have.keys(1) }
        fails { expect(map).to.have.keys(1, 2, 3, 4) }
    }

    @Test
    fun keysContainAny() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.contain.any.keys(1, 2, 3) }
        passes { expect(map).to.contain.any.keys(1, 4) }
        fails("expect {1=11, 2=22, 3=33} to contain any keys [4, 5]") {
            expect(map).to.contain.any.keys(4, 5)
        }
    }

    @Test
    fun keysContainAll() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.contain.all.keys(1, 2, 3) }
        passes { expect(map).to.contain.all.keys(1, 2) }
        passes { expect(map).to.contain.all.keys(1) }
        fails("expect {1=11, 2=22, 3=33} to contain all keys [1, 2, 4]") {
            expect(map).to.contain.all.keys(1, 2, 4)
        }
    }

    @Test
    fun keysContainImplicitAll() {
        val map = mapOf(1 to 11, 2 to 22, 3 to 33)
        passes { expect(map).to.contain.keys(1, 2, 3) }
        passes { expect(map).to.contain.keys(1, 2) }
        passes { expect(map).to.contain.keys(1) }
        fails("expect {1=11, 2=22, 3=33} to contain keys [1, 2, 4]") {
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
        passes { mapOf<Int, Int>().should.be.empty }
        fails("{a=1} should be empty") { mapOf("a" to 1).should.be.empty }
        passes { mapOf(1 to 2).should.not.be.empty }
    }

    @Test
    fun `null`() {
        passes { expect(null as Map<Int, Int>?).to.be.`null` }
        fails("expect {a=1} to be null") { expect(mapOf("a" to 1)).to.be.`null` }
    }

}