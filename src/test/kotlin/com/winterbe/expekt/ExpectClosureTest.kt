package com.winterbe.expekt

import org.junit.Test

class ExpectClosureTest {

    @Test
    fun raise() {
        passes {
            expect({ throw NullPointerException() }).raise(NullPointerException::class)
            expect({ throw CustomException() }).raise(CustomException::class)
        }
        fails("expect closure raise ${NullPointerException::class.java} but nothing to thrown") {
            expect({ /* nothing to thrown */ }).raise(NullPointerException::class)
        }
        fails("expect closure raise ${NullPointerException::class.java} but actual thrown ${CustomException::class.java}") {
            expect({ throw CustomException() }).raise(NullPointerException::class)
        }
        fails("expect closure raise ${CustomException::class.java} but nothing to thrown") {
            expect({ /* nothing to thrown */ }).raise(CustomException::class)
        }
        fails("expect closure raise ${CustomException::class.java} but actual thrown ${NullPointerException::class.java}") {
            expect({ throw NullPointerException() }).raise(CustomException::class)
        }
    }

    @Test
    fun raiseAny() {
        passes {
            expect({ throw NullPointerException() }).raiseAny()
            expect({ throw CustomException() }).raiseAny()
        }
        fails("expect closure raise some exception but nothing to thrown") {
            expect({ /* nothing to thrown */ }).raiseAny()
        }
    }

}

class CustomException : Exception()
