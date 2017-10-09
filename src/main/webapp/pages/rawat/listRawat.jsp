<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Rawat</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <td>No</td>
                    <td>Nama Pasien</td>
                    <td>No Ruangan</td>
                    <td>Nama Dokter</td>
                    <td>Waktu Register</td>
                    <td>Waktu Checkout</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listRawat}" var="r" varStatus="idx">
                        <tr>
                                <td>${idx.count}</td>
                                <td>${r.pasien.nama}</td>
                                <td>${r.ruang.noRuangan}</td>
                                <td>${r.dokter.nama}</td>
                                <td>${r.rawat.waktuRegister}</td>
                                <td>${r.rawat.waktuCheckout}</td>
                                <td>
                                   <c:if test="${r.waktuCheckOut != null}">
                                       <c:out value="'Sudah dikembalikan'"/>
                                   </c:if>
                                   <c:if test="${r.waktuCheckOut == null}">
                                        <a href="${pageContext.servletContext.contextPath}/rawat/checkout?kode=${r.id}">Kembalikan</a>
                                    </c:if>
                                </td>
                            </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
