# Expekt [![Travic CI](https://travis-ci.org/winterbe/expekt.svg?branch=master)](https://travis-ci.org/winterbe/expekt)

Expekt is a (work in progress) BDD assertion library for [Kotlin](http://kotlinlang.org/), inspired by [Chai.js](http://chaijs.com/). It works with your favorite test runner such as [JUnit](http://junit.org/) and [Spek](http://jetbrains.github.io/spek/).

### Examples

Expekt enables you to formulate assertions in natural english language:

```kotlin
expect(23).to.equal(23)
expect("foo").not.to.equal("bar")
expect(3).not.to.satisfy { it == 4 }
expect(3).to.be.above(2).and.to.be.below(4)
expect("abc").not.to.have.length.above(3)
expect("abc").to.contain("bc").and.to.startWith("a")
expect("abc").not.to.match(Regex("[0-9]+"))
expect(listOf(1, 2, 3)).to.contain(3).and.to.have.length.above(2)
expect(listOf(1, 2, 3)).to.contain.any.elements(1, 3, 4)
expect(listOf(1, 2, 3)).to.have.all.elements(1, 2, 3)
```

### License

MIT