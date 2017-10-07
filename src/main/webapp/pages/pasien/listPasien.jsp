<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Pasien</title>
    </head>
    <body>
        <table>
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
                        <td>Hapus</td>
                        <td>Ubah</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
