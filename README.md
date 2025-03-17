# TimeAgo

[![Maven Central](https://img.shields.io/maven-central/v/com.github.marlonlom/timeago.svg)](http://www.mvnrepository.com/artifact/com.github.marlonlom/timeago)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Timeago-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/4707)
[![Android Build](https://github.com/marlonlom/timeago/actions/workflows/build.yml/badge.svg)](https://github.com/marlonlom/timeago/actions/workflows/build.yml)
[![CodeFactor](https://www.codefactor.io/repository/github/marlonlom/timeago/badge)](https://www.codefactor.io/repository/github/marlonlom/timeago)

Simple java library for displaying dates as relative time ago language.

## Examples:

```
- 4 days ago
- 15 years ago
- a minute ago
- just now
```

## Usage:

### Import as a dependency:

Gradle (Kotlin):

```
implementation("com.github.marlonlom:timeago:$latestVersion")
```

Gradle (Groovy):

```
implementation "com.github.marlonlom:timeago:$latestVersion"
```

Maven:

```xml
<dependency>
  <groupId>com.github.marlonlom</groupId>
  <artifactId>timeago</artifactId>
  <version>$latestVersion</version>
</dependency>
```

### Use it in your code:

```java
String text=TimeAgo.using(timeInMillis);
```

Where _timeInMillis_, based on current date and time, is defined like

```java
/* You can use java.util.Calendar.getInstance().getTimeInMillis()*/
/* Also, with java 8, java.time.Instant.now().toEpochMilli() */

long timeInMillis=System.currentTimeMillis();
```

### With Specific Locale (by language tag):

For specific language usage, use _TimeAgoMessages_:

```java
Locale LocaleBylanguageTag=Locale.forLanguageTag("es");
TimeAgoMessages messages=new TimeAgoMessages.Builder().withLocale(LocaleBylanguageTag).build();

String text=TimeAgo.using(timeInMillis,messages);
```

#### Languages supported
Spanish (es), English (en), Dutch (nl), German (de), French (fr), Italian (it), Portuguese (pt),
Indonesian (id), Czech (cs), Arabic (ar), and more. You can see more
details [reading this information](docs/languages_supported.md).

## Demo

Check the [Demo](https://goo.gl/y66vh4) here.

![Sample app running](ta_screenshots/ta_sample_running.webp "Sample app running")


# Documentation

## Code-of-Conduct

See the [code of conduct](CODE_OF_CONDUCT.md) document for more information.

## Contributing

See the [Contributing](CONTRIBUTING.md) document for more information.


### License
This application is distributed under the terms of the Apache License (Version 2.0). See the [license](LICENSE) for more
information.

```
Copyright 2016 marlonlom

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
