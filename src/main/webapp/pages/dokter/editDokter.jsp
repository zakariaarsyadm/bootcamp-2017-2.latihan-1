<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Data Dokter</title>
    </head>
    <body>
        <h1 align="center">Ubah Data Dokter</h1>
        <form action="${pageContext.servletContext.contextPath}/dokter/ubah" method="post" align="center">
            <input type="hidden" name="id" value="${dokter.id}">
            <div>
                <label for ="nama">Nama</label>
                <p></p>
                <input type="text" name="nama" id="nama" value="${dokter.nama}"/>
            </div>
            <p></p>
            <div>
                <label for="spesialis">Spesialis</label>
                <p></p>
                <input type="text" name="spesialis" id="spesialis" value="${dokter.spesialis}"/>
            </div>
            <p></p>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
