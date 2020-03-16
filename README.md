# TimeAgo
 
[![Maven Central](https://img.shields.io/maven-central/v/com.github.marlonlom/timeago.svg)](http://www.mvnrepository.com/artifact/com.github.marlonlom/timeago)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Timeago-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/4707)
[![Download](https://api.bintray.com/packages/marlonlom/timeago/timeago/images/download.svg) ](https://bintray.com/marlonlom/timeago/timeago/_latestVersion)
[![Build Status](https://travis-ci.org/marlonlom/timeago.svg?branch=master)](https://travis-ci.org/marlonlom/timeago)
<a href="http://www.methodscount.com/?lib=com.github.marlonlom%3Atimeago%3A%2B"><img src="https://img.shields.io/badge/Methods and size-97 | 32 KB-e91e63.svg"/></a>

Simple java library for displaying dates as relative time ago language.

## Examples:
- 4 days ago
- 15 years ago
- a minute ago
- just now

## Usage:

### Import as a dependency:

Gradle:

```
compile 'com.github.marlonlom:timeago:$latestVersion'
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
String text = TimeAgo.using(timeInMillis);
```

Where _timeInMillis_, based on current date and time, is defined like 

```java
/* You can use java.util.Calendar.getInstance().getTimeInMillis()*/
/* Also, with java 8, java.time.Instant.now().toEpochMilli() */

long timeInMillis = System.currentTimeMillis();
```

### With Specific Locale (by language tag):

For specific language usage, use _TimeAgoMessages_:

```java
Locale LocaleBylanguageTag = Locale.forLanguageTag("es"); 
TimeAgoMessages messages = new TimeAgoMessages.Builder().withLocale(LocaleBylanguageTag).build();

String text = TimeAgo.using(timeInMillis, messages);
```

Languages supported: Spanish (es), English (en), Dutch (nl), German (de), French (fr), Italian (it), Portuguese (pt), Indonesian (id), Czech (cs), Arabic (ar).

## Demo

Check the [Demo](https://goo.gl/y66vh4) here.

## Spread the word

If you like this library, please tell others about it :thumbsup::thumbsup:

<a href="https://twitter.com/intent/tweet?text=Trying%20to%20show%20relative%20date%20time%20texts%3F%20Check%20out%20this%20awesome%20library%20on%20Github%3A%20https://github.com/marlonlom/timeago" target="_blank" title="share to twitter" style="width:100%"><img src="https://github.com/marlonlom/staticmaps_builder/blob/master/design/twitter_icon.png" title="Share on Twitter" width="35" height=35 />
<a href="https://plus.google.com/share?url=https://github.com/marlonlom/timeago" target="_blank" title="share to G+" style="width:100%"><img src="https://github.com/marlonlom/staticmaps_builder/blob/master/design/googleplus_icon.png" target="_blank"  title="Share on Google+" width="35" height=35 />
<a href="https://www.facebook.com/sharer/sharer.php?u=https://github.com/marlonlom/timeago" target="_blank" title="share to facebook" style="width:100%"><img src="https://github.com/marlonlom/staticmaps_builder/blob/master/design/facebook_icon.png" title="Share on Facebook" width="35" height=35 />

 - []()Follow me on **Twitter**: [**@Marlonlom**](https://twitter.com/marlonlom)
 - Contact me on **LinkedIn**: [**Marlonlom**](https://co.linkedin.com/in/marlonlom)


### License

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
