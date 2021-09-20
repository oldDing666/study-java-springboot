<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script>
    $(function () {
        // 将post改为delete
        // 点击删除链接后，会使用form提交，并且提交的_method值为delete，以达到和增加类似的效果
        $(".delete").click(function () {
            if (window.confirm('是否删除该分类？')) {
                var href = $(this).attr("href");
                $("#formdelete").attr("action", href).submit();
            }
            return false;
        })
    })
</script>

<div align="center">

</div>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>password</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="u" varStatus="st">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.password}</td>
                <td><a href="users/${u.id}">编辑</a></td>
                <td>
                    <a class="delete" href="users/${u.id}">
                        删除
                    </a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <div>
        <%--        PageHelper插件会自动判断有没有上一页或下一页--%>
        <a href="?start=0">[首 页]</a>
        <a href="?start=${page.pageNum-1}">[上一页]</a>
        <a href="?start=${page.pageNum+1}">[下一页]</a>
        <a href="?start=${page.pages}">[末 页]</a>


    </div>
    <br>
    <form action="users" method="post">
        name: <input name="name"> <br>
        <br>
        password: <input name="password"> <br>
        <br>
        <button type="submit">提交</button>
    </form>

    <form id="formdelete" action="" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>