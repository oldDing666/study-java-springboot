<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<div style="margin:0px auto; width:500px">

    <form action="../users/${u.id}" method="post">
        <input type="hidden" name="_method" value="PUT">
        name: <input name="name" value="${u.name}"> <br><br>
        password: <input name="password" value="${u.password}"> <br><br>
        <input name="id" type="hidden" value="${u.id}">
        <button type="submit">提交</button>
    </form>
</div>