package com.winterbe.expekt

/**
 * @author Benjamin Winterberg
 */
class ExpectMap<K, V>(subject: Map<K, V>?, flavor: Flavor): ExpectAny<Map<K, V>>(subject, flavor) {

    private var anyMode = false

    private var haveMode = false

    val any: ExpectMap<K, V> get() {
        words.add("any")
        anyMode = true
        return this
    }

    val all: ExpectMap<K, V> get() {
        words.add("all")
        anyMode = false
        return this
    }

    override val have: ExpectMap<K, V> get() {
        words.add("have")
        haveMode = true
        return this
    }

    val contain: ExpectMap<K, V> get() {
        words.add("contain")
        haveMode = false
        return this
    }

    fun contain(entry: Pair<K, V>): ExpectMap<K, V> {
        words.add("contain")
        words.add(entry.toString())
        verify { subject!![entry.first] == entry.second }
        return this
    }

    fun keys(vararg keys: K): ExpectMap<K, V> {
        words.add("keys")
        words.add(keys.toList().toString())
        if (anyMode) {
            verify { containsAnyKeys(keys) }
        } else {
            verify { containsAllKeys(keys) }
        }
        return this
    }

    fun values(vararg values: V): ExpectMap<K, V> {
        words.add("values")
        words.add(values.toList().toString())
        if (anyMode) {
            verify { containsAnyValues(values) }
        } else {
            verify { containsAllValues(values) }
        }
        return this
    }

    private fun containsAllKeys(keys: Array<out K>): Boolean {
        if (haveMode && keys.size != subject!!.size) {
            return false
        }
        for (key in keys) {
            if (!subject!!.containsKey(key)) {
                return false
            }
        }
        return true
    }

    private fun containsAnyKeys(keys: Array<out K>): Boolean {
        // is the same for haveAny
        for (key in keys) {
            if (subject!!.containsKey(key)) {
                return true
            }
        }
        return false
    }

    private fun containsAllValues(values: Array<out V>): Boolean {
        if (haveMode && values.size != subject!!.size) {
            return false
        }
        for (v in values) {
            if (!subject!!.containsValue(v)) {
                return false
            }
        }
        return true
    }

    private fun containsAnyValues(values: Array<out V>): Boolean {
        // is the same for haveAny
        for (v in values) {
            if (subject!!.containsValue(v)) {
                return true
            }
        }
        return false
    }

    val empty: ExpectMap<K, V> get() {
        words.add("empty")
        verify { subject!!.isEmpty() }
        return this
    }

    val size: ExpectComparable<Int> get() {
        words.add("size")
        val expectInt = ExpectComparable(subject!!.size, flavor)
        expectInt.negated = negated
        expectInt.words.addAll(words)
        expectInt.words.removeAt(0)
        expectInt.words.removeAt(0)
        return expectInt
    }

    fun size(size: Int): ExpectMap<K, V> {
        words.add("size")
        words.add(size.toString())
        verify { subject!!.size == size }
        return this
    }

    override val to: ExpectMap<K, V> get() {
        super.to
        return this
    }

    override val be: ExpectMap<K, V> get() {
        super.be
        return this
    }

    override val been: ExpectMap<K, V> get() {
        super.been
        return this
    }

    override val that: ExpectMap<K, V> get() {
        super.that
        return this
    }

    override val which: ExpectMap<K, V> get() {
        super.which
        return this
    }

    override val and: ExpectMap<K, V> get() {
        super.and
        return this
    }

    override val has: ExpectMap<K, V> get() {
        super.has
        return this
    }

    override val with: ExpectMap<K, V> get() {
        super.with
        return this
    }

    override val at: ExpectMap<K, V> get() {
        super.at
        return this
    }

    override val a: ExpectMap<K, V> get() {
        super.a
        return this
    }

    override val an: ExpectMap<K, V> get() {
        super.an
        return this
    }

    override val of: ExpectMap<K, V> get() {
        super.of
        return this
    }

    override val same: ExpectMap<K, V> get() {
        super.same
        return this
    }

    override val the: ExpectMap<K, V> get() {
        super.the
        return this
    }

    override val `is`: ExpectMap<K, V> get() {
        super.`is`
        return this
    }

    override val not: ExpectMap<K, V> get() {
        super.not
        return this
    }

    override val `null`: ExpectMap<K, V> get() {
        super.`null`
        return this
    }

    override fun <S : Map<K, V>> instanceof(type: Class<S>): ExpectMap<K, V> {
        super.instanceof(type)
        return this
    }

    override fun identity(other: Map<K, V>?): ExpectMap<K, V> {
        super.identity(other)
        return this
    }

    override fun equal(other: Map<K, V>?): ExpectMap<K, V> {
        super.equal(other)
        return this
    }

    override fun satisfy(predicate: (Map<K, V>) -> Boolean): ExpectMap<K, V> {
        super.satisfy(predicate)
        return this
    }
}