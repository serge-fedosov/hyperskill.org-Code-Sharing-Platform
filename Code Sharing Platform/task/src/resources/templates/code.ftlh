<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<span id="load_date">${code.getDateString()}</span>
<br/>
<#if code.isViewsRestriction()>
<u><span id="views_restriction">${code.getViews()}</span></u> more views allowed
<br/></#if>
<#if code.isTimeRestriction()>
The code will be available for <u><span id="time_restriction">${code.getTime()}</span></u> seconds
<br/></#if>
<pre id="code_snippet"><code>${code.getCode()}</code></pre>
</body>
</html>