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
                        <td>${yaRuang.noRuangan}</td>
                        <td>${yaRuang.kosong}</td>
                        <td><a href="${pageContext.servletContext.contextPath}/ruang/ubah?kodeRuang=${yaRuang.id}">Ubah</a></td>
                        <td><a href="${pageContext.servletContext.contextPath}/ruang/delete?kodeRuang=${yaRuang.id}">Hapus</a></td>
                   
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
