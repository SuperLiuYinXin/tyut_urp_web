<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>成绩详情</title>
</head>
<body>
<h1>成绩详情</h1>
${error!}
<#list terms! as term >
    <h2>${term.name}</h2>
    <#list term.grades as grade >
    课程号：${grade.classNumber}&nbsp; 课序号  ${grade.classOrder}; &nbsp;课程名 ${grade.classNumber}
    &nbsp;${grade.className}&nbsp;学分${grade.credit }&nbsp;课程属性${grade.classInfo}&nbsp;
    成绩${grade.grade}<br/>
    </#list>
</#list>
</body>
</html>
