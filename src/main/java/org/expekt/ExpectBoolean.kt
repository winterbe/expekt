package org.expekt

class ExpectBoolean(subject: Boolean?) : ExpectBase<Boolean>(subject) {

    // language chains
    val to: ExpectBoolean get() = this
    val be: ExpectBoolean get() = this
    val been: ExpectBoolean get() = this
    val that: ExpectBoolean get() = this
    val which: ExpectBoolean get() = this
    val and: ExpectBoolean get() = this
    val has: ExpectBoolean get() = this
    val have: ExpectBoolean get() = this
    val with: ExpectBoolean get() = this
    val at: ExpectBoolean get() = this
    val an: ExpectBoolean get() = this
    val of: ExpectBoolean get() = this
    val same: ExpectBoolean get() = this
    val the: ExpectBoolean get() = this
    val `is`: ExpectBoolean get() = this

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

    val not: ExpectBoolean get() {
        this.negated = !this.negated
        return this
    }
}