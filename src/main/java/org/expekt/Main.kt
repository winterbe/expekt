package org.expekt

fun main(args: Array<String>) {
    expect(3).to.be.ok
//    expect(null).to.be.`null`
//    expect(false).to.be.`false`
    expect("").to.be.empty
    expect("a").to.equal("a")
//    expect("abc").to.have.length.above(1).and.below(4)
    expect("abc").to.have.length(3)
    expect({}).to.not.`throw`
    expect("foo").to.be.an.instanceof("bar")

    3.should().be.equal(3)

    null.should().not.be.ok
}