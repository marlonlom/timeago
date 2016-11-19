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

Sample application:

<iframe src="https://appetize.io/embed/e2d4pnmfmam1z28q4qkcnc2qzw?device=nexus5&scale=75&autoplay=true&orientation=portrait&deviceColor=black" width="300px" height="597px" frameborder="0" scrolling="no"></iframe>
				
