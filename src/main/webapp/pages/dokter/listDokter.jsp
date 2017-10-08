<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Dokter</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <td>No</td>
                    <td>Nama</td>
                    <td>Spesialis</td>
                    <td>Aksi</td>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listDokter}" var="yaDokter" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${yaDokter.nama}</td>
                        <td>${yaDokter.spesialis}</td>
                        <td><a href="${pageContext.servletContext.contextPath}/dokter/ubah?kodeDokter=${yaDokter.id}">Ubah</a></td>
                        <td><a href="${pageContext.servletContext.contextPath}/dokter/delete?kodeDokter=${yaDokter.id}">Hapus</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
