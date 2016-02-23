package com.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectBoolean(subject: Boolean?, flavor: Flavor) : ExpectAny<Boolean>(subject, flavor) {

    val `true`: Unit get() {
        words.add("true")
        verify { subject == true }
    }

    val `false`: Unit get() {
        words.add("false")
        verify { subject == false }
    }

    override val to: ExpectBoolean get() {
        super.to
        return this
    }

    override val be: ExpectBoolean get() {
        super.be
        return this
    }

    override val been: ExpectBoolean get() {
        super.been
        return this
    }

    override val that: ExpectBoolean get() {
        super.that
        return this
    }

    override val which: ExpectBoolean get() {
        super.which
        return this
    }

    override val and: ExpectBoolean get() {
        super.and
        return this
    }

    override val has: ExpectBoolean get() {
        super.has
        return this
    }

    override val have: ExpectBoolean get() {
        super.have
        return this
    }

    override val with: ExpectBoolean get() {
        super.with
        return this
    }

    override val at: ExpectBoolean get() {
        super.at
        return this
    }

    override val a: ExpectBoolean get() {
        super.a
        return this
    }

    override val an: ExpectBoolean get() {
        super.an
        return this
    }

    override val of: ExpectBoolean get() {
        super.of
        return this
    }

    override val same: ExpectBoolean get() {
        super.same
        return this
    }

    override val the: ExpectBoolean get() {
        super.the
        return this
    }

    override val `is`: ExpectBoolean get() {
        super.`is`
        return this
    }

    override val not: ExpectBoolean get() {
        super.not
        return this
    }

    override val `null`: ExpectBoolean get() {
        super.`null`
        return this
    }

}