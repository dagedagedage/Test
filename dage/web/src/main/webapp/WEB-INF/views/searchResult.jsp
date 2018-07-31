<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/7/29
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <title>查询歌曲操作</title>

    <meta charset="utf-8" />

    <title>歌单</title>

    <style type="text/css">
        .center{
            margin-left: 30%;
            margin-top:5%;
        }
    </style>
</head>

<body>
<div class="center">
    <h1>INFORMATION</h1>

    <table border="1">

        <tr>
            <th>计数</th><th>曲名</th><th>收录专辑</th><th>歌手</th><th>编号</th><th colspan="2">操作</th>
        </tr>

        <c:forEach  items="${songList}"  var="song" varStatus="status">
            <tr>
                <td>
                        ${status.index+1}
                </td>
                <td>
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

    </table>

    <form action="${website}/song" method="post">
        <input type="submit" name="fail" value="返回主页面">
    </form>
</div>
</body>
</html>
