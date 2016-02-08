package org.expekt

class ExpectBoolean(subject: Boolean?) : ExpectBase<Boolean>(subject) {
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
    override val an: ExpectBoolean get() = this
    override val of: ExpectBoolean get() = this
    override val same: ExpectBoolean get() = this
    override val the: ExpectBoolean get() = this
    override val `is`: ExpectBoolean get() = this

    override val not: ExpectBoolean get() {
        this.negated = !this.negated
        return this
    }

    val `true`: Unit get() {
        if (subject != true && !negated) {
            throw AssertionError()
        }
        if (subject == true && negated) {
            throw AssertionError()
        }
    }

    val `false`: Unit get() {
        if (subject != false && !negated) {
            throw AssertionError()
        }
        if (subject == false && negated) {
            throw AssertionError()
        }
    }
}