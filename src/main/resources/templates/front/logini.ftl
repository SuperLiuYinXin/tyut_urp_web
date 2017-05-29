<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
</head>
<body>
<form method="post"  action="/front/login" >
    <table width="100%" border="0" cellspacing="6" cellpadding="0" class="font-b">
        <tr>
            <td align="right" width="67">
                <span id="userName_label">帐号</span>:    			</td>
            <td>
                <input type="text" name="user" value="2016005906" class="input01" title="帐号" alt="notnull"></td>
        </tr>
        <tr>
            <td align="right" width="67">
                <span id="password_label">密码</span>:    			</td>
            <td>
                <input type="password" name="password" value="283617" class="input01" title="密码" alt="notnull"></td>
        </tr>
        <tr>
            <td align="right" width="67">
                <span id="password_label">验证码</span>:
            </td>
            <td colspan="2" align="left">
                <input type="text" name="captcha" size="4"
                       title="验证码" alt="notnull">
                <img src="/captcha/${imgUrl}"  height="20" width="80"> &nbsp;
                <#if isLoginSuccess?? && isLoginSuccess==false>
                    <span style="cursor:pointer; color:red;" >验证码输入错误,请重新输入</span>
                </#if>
                <input type="hidden" name="cookies" value="${cookies}">
            </td>
        </tr>
        <tr>
            <td > <input type="submit"   d="btnSure" class="buttonImg" title="登录"></td>
            <td > <input type="reset"  class="buttonImg" title="重设"></td>
        </tr>
        </table>
</form>

</body>
</html>