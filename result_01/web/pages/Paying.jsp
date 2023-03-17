
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>支付中</title>
    <style>
        body{
            margin: 0;
            padding: 0;
            text-align: center;
            background-image: url("../image/paper.jpg");
            background-size: cover;
            background-attachment: local;
        }
        a{
            text-decoration: none;
        }
        .head01{
            margin-top: 50px;
        }
        .weixin{
            margin-left: 520px;
            float: left;
            width: 200px;
            height: 200px;
        }
        .zhifubao{
            margin-left: 50px;
            float: left;
            width: 200px;
            height: 200px;
        }
        .backtrack{
            margin-top: 250px;
        }
        .backtrack button{
            width: 150px;
            height: 50px;
            border-radius: 24px;
            border: #768ee3 solid;
        }
        .backtrack button:focus{
            background: yellow;
        }
    </style>
</head>
<body>
<div class="head01"><h1>请选择支付方式</h1></div>
<div class="">
    <div class="weixin"><a href="/log"><button>
        <img src="../image/weixin.png" width="150px" height="150px">
    </button></a></div>

    <div class="zhifubao"><a href="/log"><button>
        <img src="../image/zhifubao.png" width="150px" height="150px">
    </button></a></div>
    <br>
    <div class="backtrack"><a href="/Return"><button>返回</button></a></div>
</div>
</body>
</html>
