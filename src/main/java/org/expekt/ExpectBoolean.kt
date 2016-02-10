package org.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectBoolean(subject: Boolean?) : ExpectAny<Boolean>(subject) {
    override val to: ExpectBoolean get() = this
    override val be: ExpectBoolean get() = this
    override val been: ExpectBoolean get() = this
    override val that: ExpectBoolean get() = this
    override val which: ExpectBoolean get() = this
    override val and: ExpectBoolean get() = this
    override val has: ExpectBoolean get() = this
    override val have: ExpectBoolean get() = this
    override val with: ExpectBoolean get() = this
    override val at: ExpectBoolean get() = this
    override val a: ExpectBoolean get() = this
    override val an: ExpectBoolean get() = this
    override val of: ExpectBoolean get() = this
    override val same: ExpectBoolean get() = this
    override val the: ExpectBoolean get() = this
    override val `is`: ExpectBoolean get() = this

    override val not: ExpectBoolean get() {
        super.not
        return this
    }

    override val `null`: ExpectBoolean get() {
        super.`null`
        return this
    }

    val `true`: Unit get() {
        verify { value == true }
    }

    val `false`: Unit get() {
        verify { value == false }
    }
}