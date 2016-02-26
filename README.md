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

### Examples

Expekt enables you to formulate assertions in natural english language and fluent sentences. It comes in two flavors `should` and `expect`, both using the same API.

##### `should`

```kotlin
23.should.equal(23)
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

##### `expect`

```kotlin
expect(23).to.equal(23)
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

### What happens when expections fail?

When an expection fails, Expekt throws a `java.lang.AssertionError` containing a readable message, so you can easily see what's going wrong.

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

### API Doc

Work in progress...

### License

MIT