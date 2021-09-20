<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<div style="margin:0px auto; width:500px">

    <form action="../products/${p.id}" method="post">
        <input type="hidden" name="_method" value="PUT">
        name: <input name="name" value="${p.name}"> <br><br>
        price: <input name="price" value="${p.price}"> <br><br>
        <input name="id" type="hidden" value="${p.id}">
        <button type="submit">提交</button>
    </form>
</div>