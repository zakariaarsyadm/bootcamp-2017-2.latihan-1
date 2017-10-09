<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Dokter</title>
    </head>
    <body>
        <h1 align="center">Tambah Dokter</h1>
        <form action="${pageContext.servletContext.contextPath}/dokter/add" method="post" align="center">
            <div>
                <label for ="nama">Nama</label>
                <p></p>
                <input type="text" name="nama" id="nama"/>
            </div>
            <p></p>
            <div>
                <label for="spesialis">Spesialis</label>
                <p></p>
                <input type="text" name="spesialis" id="spesialis"/>
            </div>
            <p></p>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
