
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>login</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: sans-serif;
                /*background: #94ccde;*/
                background-image: url("../image/preview03.jpg");
                background-size: cover;
                background-attachment: fixed;
            }
            .box {
                width: 300px;
                padding: 40px;
                position: absolute;
                /* 块元素百分比居中*/
                top: 50%;
                left: 50%;
                transform: translate(-50% , -50%);
                background-color: rgba(7,255,253,0.5);
                text-align: center;
            }

            .box h1 {
                color: #349;
                /* 控制文本大小写 */
                text-transform: uppercase;
                font-size: 500px;
            }

            /* 选中输入账号密码的框 */
            .box input[type="text"],
            .box input[type="password"] {
                border: 0;
                background: none;
                display: block;
                margin: 20px auto;
                text-align: center;
                border: 2px solid #3498db;
                padding: 14px 10px;
                width: 200px;
                outline: none;
                color: rgb(52, 152, 219);
                /* 更圆润的边框半径*/
                border-radius: 24px;
                /* 设置动画的过渡时间 */
                transition: 0.25s;
            }

            /* 设置变化后的界面 */
            .box input[type="text"]:focus,
            .box input[type="password"]:focus {
                width: 280px;
                border-color: #ffffff;
            }

            .box input[type="submit"] {
                float: left;
                border: 0;
                background: white;
                display: block;
                margin: 20px auto;
                text-align: center;
                border: 2px solid #2ecc71;
                padding: 14px 40px;
                outline: none;
                color: black;
                border-radius: 24px;
                transition: 0.25s;
            }

            .box input[type="submit"]:hover {
                background: yellow;
            }
            .A1{
                float: right;
                width: 70px;
                border: 0;
                background: white;
                display: block;
                margin: 20px auto;
                text-align: center;
                border: 2px solid #2ecc71;
                padding: 14px 20px;
                outline: none;
                color: black;
                border-radius: 24px;
                transition: 0.25s;
                text-decoration: none;
            }
            .A1:hover{
                background: yellow;
            }
        </style>
</head>
<body>
<form class="box" action = "<%=request.getContextPath()%>/ad_log" method="post">
    <h2 >管理员登录</h2>
    <p style="color: red"><small><%
        request.setCharacterEncoding("utf-8");
        if(null!=request.getAttribute("errorMessage"))
        {
            out.println(request.getAttribute("errorMessage"));
        }
    %></small></p>
    <input type = "text" name = "aid" placeholder="管理员账号" >
    <input type = "password" name = "pwd" placeholder="密码">
    <hr>
    <input type="submit" value = "登录">
    <a href="/pages/Main.jsp" class="A1">返回</a>
</form>
</body>
</html>
