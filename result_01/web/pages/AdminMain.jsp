<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员页面</title>
    <link rel="stylesheet" href="../css/Administrator_css.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="//at.alicdn.com/t/c/font_3642848_y0fv3qbzff7.css">
    <!-- 加号 icon-zengjiatianjiajiajian
        减号 icon-minus-circle
        购物车 icon-gouwuche
        删除（垃圾桶） icon-ashbin
        展开 icon-zhankai
    -->
</head>
<body>
<div class="user_mainbody"><!-- 主体块 -->
    <div class="user_title"><!-- 标题块 -->
        <h1>自动售货机商品页</h1>
    </div>
    <div class="goods_01"><!-- 商品显示区块 -->
        <%
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/autoseller";
            Connection connection = DriverManager.getConnection(url,"root","root");
            Statement statement = connection.createStatement();
            String str = "select * from Goods";
            ResultSet rs = statement.executeQuery(str);
            String good_id="";
            String good_name="";
            String good_num="";
            String good_price="";
            while (rs.next()){
                good_name = rs.getString("good_name");
                good_id = rs.getString("good_id");
                good_num = rs.getString("good_num");
                good_price = rs.getString("good_price");
        %>
        <div><!-- 商品信息块 -->
            <ul>
                <li><span class="goods_left">货架号：<%=good_id%></span></li>
                <li class="goods_body"><span>商品名:<%=good_name%></span></li>
                <li><span class="price_piece">价格：</span><span class="price"><%=good_price%>
                </span><span class="goods_right">数量：<%=good_num%></span></li>
                <li><a href="<%=request.getContextPath()%>/Delete?good_id=<%=good_id%>" onclick="return confirm('是否删除')">
                    <button>删除</button></a></li>
                <li><a href="<%=request.getContextPath()%>/pages/Update.jsp?good_id=<%=good_id%>">
                    <button>修改</button></a></li>
            </ul>
        </div>

        <%
            }
            statement.close();
            rs.close();
            connection.close();
        %>
    </div>

    <div class="pay_piece">
        <span><a href="Add.jsp"><button>添加货架商品</button></a></span>
    </div>
    <div class="goto_Log">
        <a href="Log.jsp"><button>日志</button></a>
    </div>
    <div class="go_back">
        <a href="/GoBack"><button>返回登录</button></a>
    </div>

</div>
</body>
</html>
