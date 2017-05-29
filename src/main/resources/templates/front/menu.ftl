
<!doctype html>
<html>
	<head>
		<title>菜单</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<link href="/css/jquery.selectbox.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<select name="country_id" id="country_id" tabindex="1">
				<#--<option value="1">-->
					<#--<a href="#" onclick=""><span onclick="alert('wo')">点我!</span></a>-->
				<#--</option>-->
				<option value="1"><a href="/front/evaluate/auto/${cookis!}">一键评教</a> </option>
				<option value="2"><a href="/front/grade?cookies=${cookies!}">查成绩(测试版)</a></option>
				<option value="3"><a href="#">开发中...</a></option>
		</select>
             <!-----start-copyright---->
            <div class="copy-right">
                <p>Template by <a href="http://w3layouts.com" target="_blank">w3layouts</a> </p>
            </div>
            <!-----end-copyright---->
            <script type="text/javascript" src="/js/jquery-1.7.2.min.js"> </script>
            <script type="text/javascript" src="/js/jquery.selectbox-0.2.js"></script>
            <script type="text/javascript">
                $(function () {
                $("#country_id").selectbox();
                });
            </script>
			<script>
				function autoEvaluate(path,cookies) {
				    alert("正在自动评教中.... 给我一小会时间就好");
				    if(cookies!=null){
                        $.ajax({
                            method: "POST",
                            url: path,
                            dataType: "json",
                            data: {"cookies":cookies}
                            timeout: 50000,
                            success: function (data) {
                                $(document).ready(
                                    function () {
                                        if(data!=null && data.status ==0){
                                            alert("评教完成");
                                        }
                                        else {
                                            alert("评教除了点小问题，请看看教务处");
                                    }
                                } )
                            }
                        });
                    }else {
				        alert("请重新登陆");
				        location.href="/front/login";
                    }
                }
			</script>

		     
	</body>
</html>
