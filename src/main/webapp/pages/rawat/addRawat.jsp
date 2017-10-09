<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Data Rawat</title>
    </head>
    <body>
        <h1 align="center">Tambah Data Rawat</h1>
        <form action="${pageContext.servletContext.contextPath}/rawat/add" method="post" align="center">
            <div>
                <label for="bukuId">Pilih Pasien</label>
                <p></p>
                <select name="pasienId" id="pasienId">
                    <c:forEach items="${listPasien}" var="p">
                        <option value="${p.id}">${p.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <p></p>
            <div>
                <label for="dokterId">Pilih Dokter</label>
                <p></p>
                <select name="dokterId" id="dokterId">
                    <c:forEach items="${listDokter}" var="d">
                        <option value="${d.id}">${d.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <p></p>
            <div>
                <label for="ruangId">Pilih Ruangan</label>
                <p></p>
                <select name="ruangId" id="ruangId">
                    <c:forEach items="${listRuang}" var="r">
                        <option value="${r.id}">${r.noRuangan} (${r.kosong})</option>
                    </c:forEach>
                </select>
            </div>
            <p></p>

            <div>
                <button type="submit">submit</button>
                <button type="reset">reset</button>
            </div>
        </form>
    </body>
</html>
