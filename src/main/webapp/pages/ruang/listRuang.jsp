<%@page  isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Ruangan</title>
    </head>
    <body>
        <h1 align="center">Daftar Ruangan</h1>
        <table frame="box" align="center" border="1">
            <thead>
                <tr>
                    <td>No</td>
                    <td>No Ruangan</td>
                    <td>Kosong</td>
                    <td>Aksi</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listRuang}" var="yaRuang" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${yaRuang.noRuangan}</td>
                        <td>${yaRuang.kosong}</td>
                        <td><a href="${pageContext.servletContext.contextPath}/ruang/ubah?kodeRuang=${yaRuang.id}">Ubah</a></td>
                        <td><a href="${pageContext.servletContext.contextPath}/ruang/delete?kodeRuang=${yaRuang.id}">Hapus</a></td>
                   
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p></p>
        <div>
            <!--<a href="localhost/latihan-1/pages/pasien/tambahPasien.jsp">Tambah pasien klik disini</a>-->
            <form action="add" align="center">
                <input type="submit" value="Tambah Ruang" />
            </form>
        </div>
    </body>
</html>
