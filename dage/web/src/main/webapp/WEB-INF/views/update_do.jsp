<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/7/29
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />

    <title>歌曲信息修改</title>

    <style type="text/css">
        .center{
            margin-left: 30%;
            margin-top:20%;
        }
    </style>

    <script language="javascript">
        function Checking() {
            if(form.name.value == ""){                                                                                       //输入判空
                window.alert("输入不能为空o(´^｀)o");
                return false;
            }else if(form.singer.value == ""){
                window.alert("输入不能为空o(´^｀)o");
                return false;
            }
        }
    </script>
</head>

<body>
<div class="center">

    <h1>歌曲信息修改</h1>

    <form name="form" action="${website}updateSong/${id}" method="post" >

        <table>
            <tr>
                <td>曲名：</td><td><input type="text" name="name" value="${song.name}"></td>
            </tr>
            <tr>
                <td>专辑：</td><td><input type="text" name="belonging" value="${song.belonging}"></td>
            </tr>
            <tr>
                <td>歌手：</td><td><input type="text" name="singer" value="${song.singer}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="确定" id="sure" onclick="return Checking()"></td>
                <td>
                    <input type="submit" value="取消" name="leave" formaction="${website}/song">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
