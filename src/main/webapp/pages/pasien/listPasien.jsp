<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Pasien</title>
    </head>
    <body>
        <h1 align="center">Daftar Pasien</h1>
        <table frame="box" border="1" align="center">
            <thead>
                <tr>
                    <td>No</td>
                    <td>Nama Pasien</td>
                    <td>Alamat</td>
                    <td>Tanggal Lahir</td>
                    <td>Aksi</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listPasien}" var="yaPasien" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${yaPasien.nama}</td>
                        <td>${yaPasien.alamat}</td>
                        <td>${yaPasien.tanggalLahir}</td>
                        <td><a href="${pageContext.servletContext.contextPath}/pasien/ubah?kodePasien=${yaPasien.id}">Ubah</a></td>
                        <td><a href="${pageContext.servletContext.contextPath}/pasien/delete?kodePasien=${yaPasien.id}">Hapus</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p></p>
        <div>
            <!--<a href="localhost/latihan-1/pages/pasien/tambahPasien.jsp">Tambah pasien klik disini</a>-->
            <form action="add" align="center">
                <input type="submit" value="Tambah Pasien" />
            </form>
        </div>

    </body>
</html>
