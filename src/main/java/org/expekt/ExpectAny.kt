package org.expekt

class ExpectAny<T>(subject: T?) : ExpectBase<T>(subject) {

    // language chains
    val to: ExpectAny<T> get() = this
    val be: ExpectAny<T> get() = this
    val been: ExpectAny<T> get() = this
    val that: ExpectAny<T> get() = this
    val which: ExpectAny<T> get() = this
    val and: ExpectAny<T> get() = this
    val has: ExpectAny<T> get() = this
    val have: ExpectAny<T> get() = this
    val with: ExpectAny<T> get() = this
    val at: ExpectAny<T> get() = this
    val an: ExpectAny<T> get() = this
    val of: ExpectAny<T> get() = this
    val same: ExpectAny<T> get() = this
    val the: ExpectAny<T> get() = this
    val `is`: ExpectAny<T> get() = this


    val length: ExpectAny<T> get() = this
    val ok: Unit get() = Unit
    val exist: Unit get() = Unit
    val empty: Unit get() = Unit
    val `throw`: Unit get() = Unit

    val not: ExpectAny<T> get() {
        this.negated = !this.negated
        return this
    }

    fun length(other: Any?) {

    }

    fun `throw`(other: Any?) {

    }

    fun instanceof(other: Any?) {

    }
}