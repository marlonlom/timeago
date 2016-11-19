# TimeAgo
Simple java library for displaying dates as relative time ago language.

Examples: 
- 4 days ago
- 15 years ago
- a minute ago
- just now

Usage:

(1) Default: 
<pre>TimeAgo.from(new java.util.Date().getTime());</pre>

(2) With Specific Locale (by language tag):

<pre>Locale LocaleBylanguageTag = Locale.forLanguageTag("es"); 
TimeAgoMessages messages = new TimeAgoMessages.Builder().withLocale(LocaleBylanguageTag).build();
TimeAgo.from(new java.util.Date().getTime(), messages);
</pre>


