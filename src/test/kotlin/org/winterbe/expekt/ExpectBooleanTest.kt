package org.winterbe.expekt

import org.junit.Test

class ExpectBooleanTest {

    @Test
    fun notFalse() {
        passes { expect(true).not.to.be.`false` }
        fails("expect false not to be false") {
            expect(false).not.to.be.`false`
        }
    }

    @Test
    fun `false`() {
        passes { expect(false).to.be.`false` }
        fails("expect true to be false") {
            expect(true).to.be.`false`
        }
    }

    @Test
    fun notTrue() {
        passes { expect(false).not.to.be.`true` }
        fails("expect true not to be true") {
            expect(true).not.to.be.`true`
        }
    }

    @Test
    fun `true`() {
        passes { expect(true).to.be.`true` }
        fails("expect false to be true") {
            expect(false).to.be.`true`
        }
    }

    @Test
    fun should() {
        true.should.be.`true`
    }

}