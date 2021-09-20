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
            <td>price</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="p" varStatus="st">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td><a href="products/${p.id}">编辑</a></td>
                    <%--                <td><a href="deleteCategory?id=${c.id}">删除</a></td>--%>
                <td>
                        <%--                    <a class="delete" href="javascript:if(window.confirm('是否删除该分类？')){window.location.href='products/${p.id}'}">--%>
                    <a class="delete" href="products/${p.id}">
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

        <%--        <a href="?start=0">[首 页]</a>--%>
        <%--        <c:if test="${not page.hasPreviousPage}">--%>
        <%--            <a href="?start=0">[上一页]</a>--%>
        <%--        </c:if>--%>
        <%--        <c:if test="${page.hasPreviousPage}">--%>
        <%--            <a href="?start=${page.pageNum-1}">[上一页]</a>--%>
        <%--        </c:if>--%>

        <%--        <c:if test="${not page.hasNextPage}">--%>
        <%--            <a href="?start=${page.pages}">[下一页]</a>--%>
        <%--        </c:if>--%>
        <%--        <c:if test="${page.hasNextPage}">--%>
        <%--            <a href="?start=${page.pageNum+1}">[下一页]</a>--%>
        <%--        </c:if>--%>
        <%--        <a href="?start=${page.pages}">[末 页]</a>--%>

    </div>
    <br>
    <form action="products" method="post">
        name: <input name="name"> <br>
        <br>
        price: <input name="price"> <br>
        <br>
        <button type="submit">提交</button>
    </form>

    <form id="formdelete" action="" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>