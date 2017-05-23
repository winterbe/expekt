package com.winterbe.expekt

import org.junit.Test

class ExpectClosureTest {

    @Test
    fun raise() {
        // Exception
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

        // Error
        passes {
            expect({ throw NotImplementedError() }).raise(NotImplementedError::class)
            expect({ throw CustomError() }).raise(CustomError::class)
        }
        fails("expect closure raise ${NotImplementedError::class.java} but nothing to thrown") {
            expect({ /* nothing to thrown */ }).raise(NotImplementedError::class)
        }
        fails("expect closure raise ${NotImplementedError::class.java} but actual thrown ${CustomError::class.java}") {
            expect({ throw CustomError() }).raise(NotImplementedError::class)
        }
        fails("expect closure raise ${CustomError::class.java} but nothing to thrown") {
            expect({ /* nothing to thrown */ }).raise(CustomError::class)
        }
        fails("expect closure raise ${CustomError::class.java} but actual thrown ${NotImplementedError::class.java}") {
            expect({ throw NotImplementedError() }).raise(CustomError::class)
        }
    }

    @Test
    fun raiseAny() {
        passes {
            expect({ throw NullPointerException() }).raiseAny()
            expect({ throw CustomException() }).raiseAny()

            expect({ throw NotImplementedError() }).raiseAny()
            expect({ throw CustomError() }).raiseAny()
        }
        fails("expect closure raise some exception but nothing to thrown") {
            expect({ /* nothing to thrown */ }).raiseAny()
        }
    }

}

class CustomException : Exception()
class CustomError : Error()
