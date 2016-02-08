package org.expekt

class ExpectString(subject: String?) : ExpectBase<String>(subject) {
    override val to: ExpectString get() = this
    override val be: ExpectString get() = this
    override val been: ExpectString get() = this
    override val that: ExpectString get() = this
    override val which: ExpectString get() = this
    override val and: ExpectString get() = this
    override val has: ExpectString get() = this
    override val have: ExpectString get() = this
    override val with: ExpectString get() = this
    override val at: ExpectString get() = this
    override val an: ExpectString get() = this
    override val of: ExpectString get() = this
    override val same: ExpectString get() = this
    override val the: ExpectString get() = this
    override val `is`: ExpectString get() = this

    override val not: ExpectString get() {
        this.negated = !this.negated
        return this
    }
}