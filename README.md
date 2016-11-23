# TimeAgo
Simple java library for displaying dates as relative time ago language.

## Examples:
- 4 days ago
- 15 years ago
- a minute ago
- just now

## Usage:

### Import into your project:

Gradle:

<pre>compile 'com.github.marlonlom:timeago:2.0.0'</pre>


### Defaults:

<pre>TimeAgo.from(new java.util.Date().getTime());</pre>

### With Specific Locale (by language tag):

<pre>Locale LocaleBylanguageTag = Locale.forLanguageTag("es"); 
TimeAgoMessages messages = new TimeAgoMessages.Builder().withLocale(LocaleBylanguageTag).build();
TimeAgo.from(new java.util.Date().getTime(), messages);
</pre>


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
