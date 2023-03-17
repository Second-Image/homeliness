<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <style>
        body {
            /* 设置边距*/
            margin: 0;
            /* 填充 */
            padding: 0;
            /* 设置字体风格 */
            font-family: sans-serif;
            /* 设置背景颜色 */
            /*background: lightsteelblue;*/
            background-image: url("../image/preview01.jpg");
            background-size: cover;
            background-attachment: fixed;
        }
        .box {
            width: 300px;
            padding: 40px;
            /* 绝对定位 */
            position: absolute;
            /* 块元素在百分比下居中 */
            top: 50%;
            left: 50%;
            transform: translate(-50% , -50%);
            /* 设置登陆界面的背景颜色 */
            background-color: rgba(148, 222, 202, 0.69);
            /* 规定标签中元素属性为 text 的居中 */
            text-align: center;
            border-radius: 20px;
        }
        .box a button{
            padding: 14px 10px;
            width: 200px;
            color: rgb(65, 105, 225);
            border-radius: 24px;
        }
        .box a button:hover{
            background: #94ccde;
        }

    </style>
</head>
<body>
<div class="box">
    <h2 style="color: #fde700">您的身份是</h2>
    <a href="User.jsp" style="text-align: center"><button>顾客</button></a><br>
    <hr>
    <a href="AdminMain.jsp" style="text-align: center"><button>管理员</button></a><br>
</div>
</body>
</html>
