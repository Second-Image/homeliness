<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>交易日志</title>
    <style>
        body{
            margin: 0;
            padding: 0;
            background-image: url("../image/paper.jpg");
            background-size: cover;
            background-attachment: local;
        }
        ul{
            list-style-type: none;
        }
        .Log_mainbody{
            margin: 0 auto;
            width: 800px;
            overflow: hidden;
            background: rgba(148,204,222,0.6);
        }
        .Log_mainbody h1{
            text-align: center;
        }
        .Log_body{
            width: 800px;
            border: azure solid;
        }
        .backtrack button{
            width: 100px;
            height: 40px;
            border-radius: 24px;
            border: #768ee3 solid;
        }
        .backtrack button:focus{
            background: yellow;
        }
    </style>
</head>
<body>
<div class="Log_mainbody">
    <div><h1>交易日志</h1></div>
    <div class="backtrack"><a href="AdminMain.jsp" ><button>返回</button></a></div> <!--返回按键 也可 链接-->

    <table class="Log_body" border="1">
        <tr>
            <th>订单编号</th>
            <th>订单信息编码</th>
            <th>订单价格</th>
        </tr>
    <%
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/autoseller";
        Connection c= DriverManager.getConnection(url,"root","root");
        String sql="select * from log";
        PreparedStatement ps=c.prepareStatement(sql);

        ResultSet rs=ps.executeQuery();
        String Log_id="";
        String Log_info="";
        String price="";
        while(rs.next()){
            Log_id=rs.getString(1);
            Log_info=rs.getString(2);
            price=rs.getString(3);

    %>
        <tr>
            <th> <%=Log_id%></th> <!--订单编号-->
            <th> <%=Log_info%></th> <!--信息-->
            <th> <%=price%></th> <!--价格-->
        </tr>
        <%
            }
            ps.close();
            c.close();
            rs.close();
        %>
    </table>
</div>
</div>
</body>
</html>