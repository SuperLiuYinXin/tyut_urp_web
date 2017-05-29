<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜单</title>
</head>
<body>

<form action="/front/evaluate/auto" method="post">
    <input type="hidden" name="cookies" value="${cookies!}">
    <input type="submit"  value="一键评教">
</form>
<br>
<form action="/front/grade" method="get">
    <input type="hidden" name="cookies" value="${cookies!}">
    <input type="submit"  value="一键查成绩">
</form>
</body>
</html>