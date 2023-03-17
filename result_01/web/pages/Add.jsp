
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
    <style>
        body{
            text-align: center;
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
        .mainbody01{
            width: auto;
            height: auto;
            background: rgba(118, 142, 227,0.6);
            border: #94ccde solid;
            width: 300px;
            padding: 40px;
            /* 绝对定位 */
            position: absolute;
            /* 块元素在百分比下居中 */
            top: 50%;
            left: 50%;
            transform: translate(-50% , -50%);
            /* 设置登陆界面的背景颜色 */
            /*background-color: rgba(148,222,202,0.5);*/
            /* 规定标签中元素属性为 text 的居中 */
            text-align: center;
        }

        .mainbody02{
            margin: 0 auto;
        }
        .backtrack{
            float: left;
            margin-left: 30px;
            width: 100px;
            height: 35px;
            border-radius: 10px;
            border: #768ee3 solid;
        }
        .backtrack:hover{
            background: yellow;
        }
        .A1{
            float: right;
            margin-right:30px ;
            width: 30px;
            background-color: white;
            text-align: center;
            font-size:15px;
            color: black;

            border: 2px solid #2ecc71;
            padding: 5px 35px;
            border-radius: 10px;
            text-decoration: none;
            border: #768ee3 solid;
        }
        .A1:hover{
            background-color: yellow;
        }
    </style>
</head>
<body>
<div class="mainbody01">
    <form action="/Add" method="get">
        <table class="mainbody02">
            <caption><h2>添加商品</h2></caption>
            <tr>
                <td>货架号：</td>
                <td><input type="txt" name="id"></td>
            </tr>
            <tr>
                <td>商品名字：</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>商品单价：</td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td>商品数量：</td>
                <td><input type="text" name="num"></td>
            </tr>
        </table>
        <hr>
        <input type="submit" value="添加"class="backtrack">
        <a href="/pages/AdminMain.jsp" class="A1"><bottom>返回</bottom></a>
    </form>
</div>
</body>
</html>
