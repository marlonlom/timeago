# TimeAgo
Simple java library for displaying dates as relative time ago language.

## Examples:
- 4 days ago
- 15 years ago
- a minute ago
- just now

## Usage:

### Import as a dependency:

Gradle:

<pre>compile 'com.github.marlonlom:timeago:2.0.0'</pre>

Maven:

```xml
<dependency>
  <groupId>com.github.marlonlom</groupId>
  <artifactId>timeago</artifactId>
  <version>2.0.0</version>
</dependency>
```

### Default usage:

```java
/** using java.util.Date*/
TimeAgo.from(new java.util.Date().getTime());</pre>
/** using java.util.Calendar*/
TimeAgo.from(java.util.Calendar.getInstance().getTime());
```

### With Specific Locale (by language tag):

```java
Locale LocaleBylanguageTag = Locale.forLanguageTag("es"); 
TimeAgoMessages messages = new TimeAgoMessages.Builder().withLocale(LocaleBylanguageTag).build();
TimeAgo.from(new java.util.Date().getTime(), messages);
```


## Demo

Check the [Demo](https://goo.gl/hracI1) here.

##Spread the word

If you like this library, please tell others about it :thumbsup::thumbsup:

<a href="https://twitter.com/intent/tweet?text=Trying%20to%20show%20relative%20date%20time%20texts%3F%20Check%20out%20this%20awesome%20library%20on%20Github%3A%20https://github.com/marlonlom/timeago" target="_blank" title="share to twitter" style="width:100%"><img src="https://github.com/marlonlom/staticmaps_builder/blob/master/design/twitter_icon.png" title="Share on Twitter" width="35" height=35 />
<a href="https://plus.google.com/share?url=https://github.com/marlonlom/timeago" target="_blank" title="share to G+" style="width:100%"><img src="https://github.com/marlonlom/staticmaps_builder/blob/master/design/googleplus_icon.png" target="_blank"  title="Share on Google+" width="35" height=35 />
<a href="https://www.facebook.com/sharer/sharer.php?u=https://github.com/marlonlom/timeago" target="_blank" title="share to facebook" style="width:100%"><img src="https://github.com/marlonlom/staticmaps_builder/blob/master/design/facebook_icon.png" title="Share on Facebook" width="35" height=35 />

 - []()Follow me on **Twitter**: [**@Marlonlom**](https://twitter.com/marlonlom)
 - Contact me on **LinkedIn**: [**Marlonlom**](https://co.linkedin.com/in/marlonlom)


###License

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
