package org.winterbe.expekt

import org.junit.Test

class ExpectStringTest {

    @Test
    fun containStartWith() {
        passes { expect("abc").to.contain("bc").and.to.startWith("a") }
    }

    @Test
    fun notContain2() {
        fails { expect("abc").not.to.contain("b") }
    }

    @Test
    fun notContain1() {
        passes { expect("abc").not.to.contain("d") }
    }

    @Test
    fun contain2() {
        fails { expect("abc").to.contain("d") }
    }

    @Test
    fun contain1() {
        passes { expect("abc").to.contain("b") }
    }

    @Test
    fun notLengthProp2() {
        fails { expect("abc").not.to.have.length.below(2) }
    }

    @Test
    fun notLengthProp1() {
        passes { expect("abc").not.to.have.length.above(3) }
    }

    @Test
    fun lengthProp2() {
        fails { expect("abc").to.have.length.equal(4) }
    }

    @Test
    fun lengthProp1() {
        passes { expect("abc").to.have.length.above(2) }
    }

    @Test
    fun notLength2() {
        fails { expect("abc").not.to.have.length(3) }
    }

    @Test
    fun notLength1() {
        passes { expect("abc").not.to.have.length(4) }
    }

    @Test
    fun length2() {
        fails { expect("abc").to.have.length(4) }
    }

    @Test
    fun length1() {
        passes { expect("abc").to.have.length(3) }
    }

    @Test
    fun notEmpty2() {
        fails { expect("").to.not.be.empty() }
    }

    @Test
    fun NotEmpty1() {
        passes { expect("abc").to.not.be.empty() }
    }

    @Test
    fun empty2() {
        fails { expect("abc").to.be.empty() }
    }

    @Test
    fun empty1() {
        passes { expect("").to.be.empty() }
    }

    @Test
    fun chain() {
        passes { expect("abc").to.startWith("a").and.not.to.endWith("b") }
    }

    @Test
    fun notEndWith2() {
        fails { expect("abc").not.to.endWith("a") }
    }

    @Test
    fun notEndWith1() {
        passes { expect("abc").not.to.endWith("b") }
    }

    @Test
    fun endWith2() {
        fails { expect("abc").to.endWith("a") }
    }

    @Test
    fun endWith1() {
        passes { expect("abc").to.endWith("bc") }
    }

    @Test
    fun notStartWith2() {
        fails { expect("abc").not.to.startWith("a") }
    }

    @Test
    fun notStartWith1() {
        passes { expect("abc").not.to.startWith("b") }
    }

    @Test
    fun startWith2() {
        fails { expect("abc").to.startWith("b") }
    }

    @Test
    fun startWith1() {
        passes { expect("abc").to.startWith("a") }
    }

}