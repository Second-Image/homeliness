
<%@ page import="java.util.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户页面</title>
    <link rel="stylesheet" href="../css/User_css.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="//at.alicdn.com/t/c/font_3642848_y0fv3qbzff7.css">
    <!-- 加号 icon-zengjiatianjiajiajian
        减号 icon-minus-circle
        购物车 icon-gouwuche
        删除（垃圾桶） icon-ashbin
        展开 icon-zhankai
    -->
    <style>
        a{
            text-decoration: none;
        }
        .a1:hover{
            background-color: green;
        }

    </style>
</head>
<body>
<div class="user_mainbody"><!-- 主体块 -->
    <div class="user_title"><!-- 标题块 -->
        <h1>自动售货机商品页</h1>
    </div>
    <form action="/Doing" method="post">
    <div class="goods_01"><!-- 商品显示区块 -->
        <%
            String[] nums=null;
            boolean flag=false;
            if(session.getAttribute("nums")!=null){
                nums=(String[]) session.getAttribute("nums");
                flag=true;
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/autoseller";
            Connection connection = DriverManager.getConnection(url,"root","root");
            Statement statement = connection.createStatement();
            String str = "select * from goods";
            ResultSet rs = statement.executeQuery(str);
            String Shelf_ID="";
            String Goods_Name="";
            String Goods_number="";
            String Goods_price="";
            String num="";
            int i=0;
            while (rs.next()){
                Goods_Name = rs.getString("good_name");
                Shelf_ID = rs.getString("good_id");
                Goods_number = rs.getString("good_num");
                Goods_price = rs.getString("good_price");
                if(flag){
                    num=nums[i];
                    i++;
                }else{
                    num="0";
                }
        %>
        <div><!-- 商品信息块 -->
            <span class="goods_left">编号：<%=Shelf_ID%></span>
            <span class="goods_info"></span>
            <ul>
                <li><input type="hidden" name="ids" value="<%=Shelf_ID%>" readonly></li>

                <li class="goods_body"></li>

                <li><span class="goods_name"><%=Goods_Name%></span></li>
                <li><span class="price_piece">价格：</span><span class="price"><%=Goods_price%></span>
                    <span class="goods_right">数量：<i class="goods_number"><%=Goods_number%></i></span></li>
                <li class="oneline"><button class="goods_add" type="button"><i class="iconfont icon-zengjiatianjiajiajian"></i></button></li>
                <li class="oneline"><input type="text" class="goods_count" name="nums" value="<%=num%>" readonly></li>
                <li class="oneline"><button class="goods_reduce" type="button"><i class="iconfont icon-minus-circle"></i></button></li>
                <li>小计：<i class="total">0</i></li>
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
            总价：<i id="total_price">0</i><br>
            <span><button type="submit" name="goods_pay" value="支付" class="a1">支付</button></span>
        </div>
        <div class="go_back">
            <a href="/toMian" style="color: black;"><button type="button" class="a1">返回登录</button></a>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    let adds = document.querySelectorAll('.goods_add')
    let reduces = document.querySelectorAll('.goods_reduce')
    let prices =document.querySelectorAll('.price')
    let total_price = document.querySelector('#total_price')
    let totals =document.querySelectorAll('.total')
    let inputs = document.querySelectorAll('.goods_count')
    let the_goods_all = document.querySelectorAll('.goods_number')

    let goods=document.querySelectorAll('.goods_info')

    window.onload=function(){
        for( let i = 0; i < adds.length ; i++) {
            //alert(inputs[i].value)
            totals[i].innerHTML = parseFloat(prices[i].innerHTML) * inputs[i].value + '¥'
            if (inputs[i].value >= the_goods_all[i].innerHTML) {
                adds[i].disabled = true
            }
            if (inputs[i].value <= 0) {
                reduces[i].disabled = true
            }
            if(the_goods_all[i].innerHTML==0){
                goods[i].innerHTML='已售完'
            }
        }
        sumMoney()
    }

    for( let i = 0; i < adds.length ; i++){
        // totals[i].innerHTML = prices[i].innerHTML
        // 增加
        adds[i].addEventListener('click',function(){
            inputs[i].value++
            reduces[i].disabled = false
            totals[i].innerHTML = parseFloat(prices[i].innerHTML)*inputs[i].value + '¥'
            if (inputs[i].value >=the_goods_all[i].innerHTML){
                adds[i].disabled = true
            }
            // 计算现在总额
            sumMoney()
        })
        // 减少
        reduces[i].addEventListener('click',function(){
            inputs[i].value--
            adds[i].disabled = false
            totals[i].innerHTML = parseFloat(prices[i].innerHTML)*inputs[i].value + '¥'
            if(inputs[i].value <= 0) {
                reduces[i].disabled = true
            }
            // 计算现在总额
            sumMoney()
        })
    }

    // 总价 result函数
    function sumMoney(){
        let totals =document.querySelectorAll('.total')
        let sum = 0
        for( let i = 0; i < totals.length; i++){
            sum = sum + parseFloat(totals[i].innerHTML)
        }
        total_price.innerHTML = sum + '¥'
    }
    sumMoney()
</script>
</html>
