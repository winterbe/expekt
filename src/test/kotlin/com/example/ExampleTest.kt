package com.example

import com.winterbe.expekt.expect
import com.winterbe.expekt.should
import org.junit.Assert
import org.junit.Test

class ExampleTest {

    @Test
    fun failingTest1() {
        try {
            3.4.should.be.closeTo(3.2, delta = 0.1)
            Assert.fail()
        } catch(e: AssertionError) {
            // ok
        }
    }

    @Test
    fun failingTest2() {
        try {
            expect(3.4).to.be.closeTo(3.2, delta = 0.1)
            Assert.fail()
        } catch(e: AssertionError) {
            // ok
        }
    }

}