package org.expekt

class ExpectAny<T>(subject: T?) : ExpectBase<T>(subject) {
    override val to: ExpectAny<T> get() = this
    override val be: ExpectAny<T> get() = this
    override val been: ExpectAny<T> get() = this
    override val that: ExpectAny<T> get() = this
    override val which: ExpectAny<T> get() = this
    override val and: ExpectAny<T> get() = this
    override val has: ExpectAny<T> get() = this
    override val have: ExpectAny<T> get() = this
    override val with: ExpectAny<T> get() = this
    override val at: ExpectAny<T> get() = this
    override val an: ExpectAny<T> get() = this
    override val of: ExpectAny<T> get() = this
    override val same: ExpectAny<T> get() = this
    override val the: ExpectAny<T> get() = this
    override val `is`: ExpectAny<T> get() = this

    override val not: ExpectAny<T> get() {
        this.negated = !this.negated
        return this
    }

}