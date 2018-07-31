<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pandawork.common.entity.song" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/7/27
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>歌单</title>

    <style type="text/css">
        .center{
            margin-left: 30%;
            margin-top:5%;
        }
        form{
            display:inline-block;
        }
    </style>


    <script language="javascript">
        function Checking() {
            if(form2.search.value == ""){                                                                                //输入判空
                window.alert("输入不能为空o(´^｀)o");
                return false;
            }
        }
    </script>
</head>
<body>
<div class="center">

    <h1>THE SONGS</h1>
    <%--<h3>欢迎你，${sessionScope.get("sessionUsername")}！<a href="/user?state=userInfo&username=<%=request.getParameter("username")%>">用户信息管理</a> </h3>--%>
    <form name="form2" action="${website}searchSong" method="post" >
        <input type="text" name="search">
        <input type="submit" name="search_do" value="查询" onclick="return Checking()">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${warn}
    </form>

    <table border="1">

        <tr>
            <th>计数</th><th>曲名</th><th>收录专辑</th><th>歌手</th><th>编号</th><th colspan="2">操作</th>
        </tr>

        <c:forEach items="${songList}"  var="song" varStatus="status">
            <tr>
                <td>
                        ${status.index+1}
                </td>
                <td>
                    <%--<a href="${website}/songInfor/${song.username}/${song.id}">${song.name}</a>--%>
                        ${song.name}
                </td>
                <td>
                        ${song.belonging}
                </td>
                <td>
                        ${song.singer}
                </td>
                <td>
                        ${song.id}
                </td>
                <td>
                    <a href="${website}/deleteSong/${song.id}">删除</a>
                </td>
                <td>
                    <a href="${website}/toUpdate/${song.id}">修改</a>
                </td>
            </tr>


        </c:forEach>

        <tr>
            <form action="${website}/toAdd" name="form1" method="post">
                <td colspan="8" align="right"><input type="submit" value="添加"></td>
            </form>
        </tr>

    </table>

    <form action="${website}/home" method="post">
        <input type="submit" value="返回">
    </form>

    <%--<form action="/song?state=home" method="post">--%>
        <%--<input type="submit" value="退出">--%>
    <%--</form>--%>
</body>
</html>
