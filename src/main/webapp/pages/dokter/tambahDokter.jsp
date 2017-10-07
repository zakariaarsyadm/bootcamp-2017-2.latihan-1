<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Dokter</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/dokter/add" method="post">
            <div>
                <label for ="nama">Nama</label>
                <input type="text" name="nama" id="nama"/>
            </div>
            <div>
                <label for="spesialis">Spesialis</label>
                <input type="text" name="spesialis" id="spesialis"/>
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
