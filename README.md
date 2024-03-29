### Duration serializer library for Java 8+

Finally, a simple, fast and convenient library for human-readable `Duration` (de)serialization.

There are not any third-party dependencies. Library fits at few KB's.

## Import to your project

Maven:

```xml

<dependency>
    <groupId>io.github.blackbaroness</groupId>
    <artifactId>duration-serializer</artifactId>
    <version>2.0.2</version>
</dependency>
```

Gradle (Groovy SDK):

```groovy
implementation 'io.github.blackbaroness:duration-serializer:2.0.2'
```

Gradle (Kotlin SDK):

```kotlin
implementation("io.github.blackbaroness:duration-serializer:2.0.2")
```

### Example usage

[//]: # (@formatter:off)
```java
Duration duration = Duration.ofDays(1).plusMinutes(15).plusSeconds(10);

// Returns "1 day 15 minutes 10 seconds"
DurationSerializer.serialize(duration, DurationFormats.fullWorldEnglish());

// Returns "Duration.ofMinutes(15).plusNanos(5)"
DurationSerializer.deserialize("15 min 5 ns", DurationFormats.shortEnglish());

// Use a lot of formats at the same time!
DurationSerializer.deserialize("15 min 30 milliseconds 5 ns", DurationFormats.allBundled());
```
[//]: # (@formatter:on)

### About this project

#### Motivation

I hate specifying durations in config by the user. This is always ugly code with indication
in seconds \ milliseconds, which no one likes — neither the developer nor the user.

Therefore, I decided to make it really universal. The developer can forget about the unit specified by the user.
And the user can write the duration using their native language.

What do you like more?

As user:

```yaml
# Classic variant
periodInSeconds: 3630

# With duration serializer
period: 1 hour 30 seconds
```

As developer:

[//]: # (@formatter:off)
```java
// Classic variant
schedule(TimeUnit.SECONDS.toMillis(periodInSeconds)); // wants millis (like a Timer)

// With duration serializer
schedule(period.toMillis()); // wants millis (like a Timer)
```
[//]: # (@formatter:on)

#### Reliability

Most of the project is tested automatically using JUnit 5.
In addition, the library tries not to allow null and adheres to immutability.

You can implement your own duration formats. For example, add your own regional language
so that the user can write in a language other than English.

#### Available formats

| Format            | Nanos       | Millis       | Seconds | Minutes | Hours | Days |
|-------------------|-------------|--------------|---------|---------|-------|------|
| Short English     | ns          | ms           | s       | min     | h     | d    |
| Medium English    | nanos       | millis       | sec     | min     | hours | days |
| Full word English | nanoseconds | milliseconds | seconds | minutes | hours | days |
| Short Russian     | нс          | мс           | с       | м       | ч     | д    |
| Medium Russian    | нсек        | мсек         | сек     | мин     | ч     | дн   |

#### Contributing

Feel free to contribute if you want to make something better! I will be happy to merge your PR.
