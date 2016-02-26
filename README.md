# Expekt [![Travic CI](https://travis-ci.org/winterbe/expekt.svg?branch=master)](https://travis-ci.org/winterbe/expekt)

Expekt is a (work in progress) BDD assertion library for [Kotlin](http://kotlinlang.org/), inspired by [Chai.js](http://chaijs.com/). It works with your favorite test runner such as [JUnit](http://junit.org/) and [Spek](http://jetbrains.github.io/spek/).

```kotlin
class ExpektTest {
    @Test
    fun helloExpekt() {
        23.should.equal(23)
        "Kotlin".should.not.contain("Scala")
        listOf(1, 2, 3).should.have.size.above(1)
    }
}
```

> [Follow on Twitter](https://twitter.com/winterbe_) for updates!

### Getting started

Expekt is available via [Maven Central](https://repo1.maven.org/maven2/com/winterbe/expekt/). Just add the dependency to your Maven POM or Gradle build config.

##### Maven

```xml
<dependency>
    <groupId>com.winterbe</groupId>
    <artifactId>expekt</artifactId>
    <version>0.1.0</version>
    <scope>test</scope>
</dependency>
```

##### Gradle

```groovy
testCompile "com.winterbe:expekt:0.1.0"
```

### Introduction

Expekt let's you write assertions in natural english language by building fluent sentences in your JUnit tests.

It comes in two flavors `should` and `expect`, both exposing the same API. It's up to you which variant to use. The property `should` is available on any object (e.g. `myObject.should`), even on `null`. The function `expect` accepts any object as parameter (e.g. `expect(myObject)`) instead.

When using IntelliJ IDEA you can simply use `expect` and `should` from classpath. The IDE handles all imports for you. In case you have to handle imports manually, add one of those to your test file:

```kotlin
import com.winterbe.expekt.expect
import com.winterbe.expekt.should
```

The Expekt API consists of many chainable properties and functions. Properties like `to`, `be` and `which` are provided to improve readibility. They don't serve any semantical meaning. The property `not` is used to negate expectations. Depending on the type of the initial value plenty of properties and functions are available to assert different aspects of the value, e.g. you can assert that a collection contains some elements, that a number is within it's bounds or that a string matches a given regex pattern.

See [API doc](APIDOC.md) for all available assertion properties and functions.

### What happens when expectations fail?

When an expectation fails Expekt throws a `java.lang.AssertionError` containing a readable message, so you can easily see what's going wrong.

```kotlin
class FailingTest {
    @Test
    fun thisTestFails() {
        3.4.should.be.closeTo(3.2, delta = 0.1)
    }
}
```

The above test fails, resulting in the following exception:

```
java.lang.AssertionError: 3.4 should be closeTo 3.2 ±0.1

	at com.winterbe.expekt.ExpectAny.fail(ExpectAny.kt:77)
	at com.winterbe.expekt.ExpectAny.verify(ExpectAny.kt:68)
	at com.winterbe.expekt.ExpectDouble.closeTo(ExpectDouble.kt:12)
	at com.example.ExampleTest.example1(ExampleTest.kt:10)
```

### Examples

Example assertions using the `should` property:

```kotlin
23.should.equal(23)
null.should.be.`null`
"foo".should.not.equal("bar")
3.should.satisfy { it % 2 == 1 }
3.should.be.above(2).and.below(4)
"abc".should.contain("bc").and.startWith("a")
"abc".should.not.have.length.above(3)
"abc".should.not.match(Regex("[0-9]+"))
listOf(1, 2, 3).should.contain(3).and.have.length.above(2)
listOf(1, 2, 3).should.contain.any.elements(1, 3, 4)
listOf(1, 2, 3).should.have.all.elements(1, 2, 3)
mapOf("foo" to "bar", "bar" to "foo").should.contain("foo" to "bar")
```

Example assertions using the `expect` function:

```kotlin
expect(23).to.equal(23)
expect(null).to.be.`null`
expect("foo").not.to.equal("bar")
expect(3).not.to.satisfy { it % 2 == 1 }
expect(3).to.be.above(2).and.to.be.below(4)
expect("abc").to.contain("bc").and.to.startWith("a")
expect("abc").not.to.have.length.above(3)
expect("abc").not.to.match(Regex("[0-9]+"))
expect(listOf(1, 2, 3)).to.contain(3).and.to.have.length.above(2)
expect(listOf(1, 2, 3)).to.contain.any.elements(1, 3, 4)
expect(listOf(1, 2, 3)).to.have.all.elements(1, 2, 3)
expect(mapOf("foo" to "bar", "bar" to "foo")).to.contain("foo" to "bar")
```

### License

MIT