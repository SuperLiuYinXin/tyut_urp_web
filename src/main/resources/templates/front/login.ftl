<!DOCTYPE html>
<html >
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>太理一键评教小助手</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="/assets/css/form-elements.css">
        <link rel="stylesheet" href="/assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/assets/ico/apple-touch-icon-57-precomposed.png">
    </head>

    <body>
        <!-- Top content -->
        <div class="top-content">
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1>太理<strong>一键评教</strong>小助手</h1>
                            <div class="description">
                                <p>评教嘛...人生嘛...</p>
                            	<#--<p>-->
	                            	<#--This is a free responsive login form made with Bootstrap.-->
	                            	<#--Thanks <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!-->
                            	<#--</p>-->
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>嘿!同学</h3>
                            		<p>请输入你在教务处的学号和密码</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="/front/login" method="post" class="login-form" name="dataForm">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">学号</label>
			                        	<input type="text" name="user" placeholder="同学你的学号..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="password" placeholder="同学你的密码..." class="form-password form-control" id="form-password">
			                        </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="form-username">Password</label>
                                        <input type="text" name="captcha" placeholder="别忘了输验证码啊..." class="form-username form-control" >
                                    </div>
                                    <div class="form-group">
                                        <img src="/captcha/${imgUrl!}"> <span  style="color:red;">${error!}</span>
                                        <#--<#if loginFail??>-->
                                            <span style="color:red;" >${loginFail!}</span>
                                        <#--</#if>-->
                                        <input type="hidden" name="cookies" value="${cookies!}">
                                    </div>
			                        <button type="submit" onclick="check()" class="btn">快点我登陆!</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="navbar-btn">
                            <p>作者:lyx 此代码近期会在github上开源，尽请关注</p>
                            <p>该评教默认好评.如果有问题，请加群 635052292 反馈</p>
                        </div>
                    </div>
                    <#--<div class="row">-->
                        <#--<div class="col-sm-6 col-sm-offset-3 social-login">-->
                        	<#--<h3>...or login with:</h3>-->
                        	<#--<div class="social-login-buttons">-->
	                        	<#--<a class="btn btn-link-1 btn-link-1-facebook" href="#">-->
	                        		<#--<i class="fa fa-facebook"></i> Facebook-->
	                        	<#--</a>-->
	                        	<#--<a class="btn btn-link-1 btn-link-1-twitter" href="#">-->
	                        		<#--<i class="fa fa-twitter"></i> Twitter-->
	                        	<#--</a>-->
	                        	<#--<a class="btn btn-link-1 btn-link-1-google-plus" href="#">-->
	                        		<#--<i class="fa fa-google-plus"></i> Google Plus-->
	                        	<#--</a>-->
                        	<#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                </div>
            </div>
        </div>
        <!-- Javascript -->
        <script src="/assets/js/jquery-1.11.1.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="/assets/js/jquery.backstretch.min.js"></script>
        <script src="/assets/js/scripts.js"></script>
        <script >
            <#-- TODO  待改善  -->
            function check() {
                alert("正在一键评教，请稍等");
                document.dataForm.submit();
            }
            function evaluateSuccess() {
                alert("教评成功");
            }
            <#if evaluateResult?? &&  evaluateResult==0 >
                evaluateSuccess();
                alert("${result}");
            </#if>
        </script>
        <!--[if lt IE 10]>
            <script src="/assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>