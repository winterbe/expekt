package org.expekt

class ExpectInt(subject: Int?) : ExpectBase<Int>(subject) {

    // language chains
    val to: ExpectInt get() = this
    val be: ExpectInt get() = this
    val been: ExpectInt get() = this
    val that: ExpectInt get() = this
    val which: ExpectInt get() = this
    val and: ExpectInt get() = this
    val has: ExpectInt get() = this
    val have: ExpectInt get() = this
    val with: ExpectInt get() = this
    val at: ExpectInt get() = this
    val an: ExpectInt get() = this
    val of: ExpectInt get() = this
    val same: ExpectInt get() = this
    val the: ExpectInt get() = this
    val `is`: ExpectInt get() = this

    fun above(other: Int?): ExpectInt {
        if (subject == null || other == null) {
            throw AssertionError()
        }
        if (subject <= other && !negated) {
            throw AssertionError()
        }
        if (subject > other && negated) {
            throw AssertionError()
        }
        return this
    }

    fun below(other: Int?): ExpectInt {
        if (subject == null || other == null) {
            throw AssertionError()
        }
        if (subject >= other && !negated) {
            throw AssertionError()
        }
        if (subject < other && negated) {
            throw AssertionError()
        }
        return this
    }

    val not: ExpectInt get() {
        this.negated = !this.negated
        return this
    }
}