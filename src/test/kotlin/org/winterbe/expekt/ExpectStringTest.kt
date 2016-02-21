package org.winterbe.expekt

import org.junit.Test

class ExpectStringTest {

    @Test
    fun within() {
        passes { expect("b").to.be.within("a", "c").and.to.have.length(1) }
    }

    @Test
    fun notMatch() {
        passes { expect("abc").not.to.match(Regex(".")) }
        fails("expect abc not to match .*") {
            expect("abc").not.to.match(Regex(".*"))
        }
    }

    @Test
    fun match() {
        passes { expect("abc").to.match(Regex(".*")) }
        fails("expect abc to match .") {
            expect("abc").to.match(Regex("."))
        }
    }

    @Test
    fun containStartWith() {
        passes { expect("abc").to.contain("bc").and.to.startWith("a") }
    }

    @Test
    fun notContain() {
        passes { expect("abc").not.to.contain("d") }
        fails("expect abc not to contain b") {
            expect("abc").not.to.contain("b")
        }
    }

    @Test
    fun contain1() {
        passes { expect("abc").to.contain("b") }
        fails("expect abc to contain d") {
            expect("abc").to.contain("d")
        }
    }

    @Test
    fun notLengthProp() {
        passes { expect("abc").not.to.have.length.above(3) }
        fails("expect abc not to have length below 4") {
            expect("abc").not.to.have.length.below(4)
        }
    }

    @Test
    fun lengthProp() {
        passes { expect("abc").to.have.length.above(2) }
        fails("expect abc to have length equal 4") {
            expect("abc").to.have.length.equal(4)
        }
    }

    @Test
    fun notLength() {
        passes { expect("abc").not.to.have.length(4) }
        fails("expect abc not to have length 3") {
            expect("abc").not.to.have.length(3)
        }
    }

    @Test
    fun length() {
        passes { expect("abc").to.have.length(3) }
        fails("expect abc to have length 4") {
            expect("abc").to.have.length(4)
        }
    }

    @Test
    fun notEmpty() {
        passes { expect("abc").to.not.be.empty() }
        fails("expect  to not be empty") {
            expect("").to.not.be.empty()
        }
    }

    @Test
    fun empty() {
        passes { expect("").to.be.empty() }
        fails("expect abc to be empty") {
            expect("abc").to.be.empty()
        }
    }

    @Test
    fun chain() {
        passes { expect("abc").to.startWith("a").and.not.to.endWith("b") }
    }

    @Test
    fun notEndWith() {
        passes { expect("abc").not.to.endWith("b") }
        fails("expect abc not to endWith c") {
            expect("abc").not.to.endWith("c")
        }
    }

    @Test
    fun endWith() {
        passes { expect("abc").to.endWith("bc") }
        fails("expect abc to endWith a") {
            expect("abc").to.endWith("a")
        }
    }

    @Test
    fun notStartWith() {
        passes { expect("abc").not.to.startWith("b") }
        fails("expect abc not to startWith a") {
            expect("abc").not.to.startWith("a")
        }
    }

    @Test
    fun startWith() {
        passes { expect("abc").to.startWith("a") }
        fails("expect abc to startWith b") {
            expect("abc").to.startWith("b")
        }
    }

    @Test
    fun should() {
        "abc".should.startWith("a").and.endWith("bc")
    }

}