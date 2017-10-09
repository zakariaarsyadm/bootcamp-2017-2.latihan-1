<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Peminjaman Buku</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/rawat/add" method="post">
            <div>
                <label for="bukuId">Pilih Pasien</label>
                <select name="pasienId" id="pasienId">
                    <c:forEach items="${listPasien}" var="p">
                        <option value="${p.id}">${p.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="dokterId">Pilih Dokter</label>
                <select name="dokterId" id="dokterId">
                    <c:forEach items="${listDokter}" var="d">
                        <option value="${d.id}">${d.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="ruangId">Pilih Ruangan</label>
                <select name="ruangId" id="ruangId">
                    <c:forEach items="${listRuang}" var="r">
                        <option value="${r.id}">${r.noRuangan} (${r.kosong})</option>
                    </c:forEach>
                </select>
            </div>


            <div>
                <button type="submit">submit</button>
                <button type="reset">reset</button>
            </div>
        </form>
    </body>
</html>
