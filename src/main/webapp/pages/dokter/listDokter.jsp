<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Dokter</title>
    </head>
    <body>
        <h1 align="center">Daftar Dokter</h1>
        <table frame="box" border="1" align="center">
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
        <p></p>
        <div>
            <!--<a href="localhost/latihan-1/pages/pasien/tambahPasien.jsp">Tambah pasien klik disini</a>-->
            <form action="add" align="center">
                <input type="submit" value="Tambah Dokter" />
            </form>
        </div>
    </body>
</html>
