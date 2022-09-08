<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
</head>
<body>
<#list codes as codedto>
<pre id="code_snippet">${codedto.getCode()}</pre>
<span id="load_date">${codedto.getDate()}</span>
<br/>
</#list>
</body>
</html>