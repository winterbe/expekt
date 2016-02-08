# Expekt Assertion Library

Expekt is a BDD assertion library for [Kotlin](http://kotlinlang.org/), inspired by [Chai.js](http://chaijs.com/). It works with your favorite test runner, e.g. JUnit, TestNG and Spok.

### Example Usage

Expekt enables you to formulate assertions in natural english language:

```kotlin
expect(23).to.equal(23)
expect("foo").not.to.equal("bar")
expect(3).not.to.satisfy { it == 4 }
expect(3).to.be.above(2).and.to.be.below(4)
expect("abc").not.to.have.length.above(3)
expect("abc").to.contain("bc").and.to.startWith("a")
expect(listOf(1, 2, 3)).to.contain(3).and.to.have.length.above(2)
```

### Current Status

WIP (no production-ready release yet)

### License

MIT