<%@page  isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Ruangan</title>
    </head>
    <body>
        <table>
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
                        <td>${yaRuang.noRuang}</td>
                        <td>${yaRuang.kosong}</td>
                        <td>Ubah</td>
                        <td>Hapus</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
