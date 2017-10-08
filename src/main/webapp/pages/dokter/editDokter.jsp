<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Data Dokter</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/dokter/ubah" method="post">
            <div>
                <label for ="nama">Nama</label>
                <input type="text" name="nama" id="${dokter.nama}"/>
            </div>
            <div>
                <label for="spesialis">Spesialis</label>
                <input type="text" name="spesialis" id="${dokter.spesialis}"/>
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
