<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Pasien</title>
    </head>
    <body>
        <h1 align="center">Tambah Pasien</h1>
        <form action="${pageContext.servletContext.contextPath}/pasien/add" method="post" align="center">
            <div>
                <label for="nama">Nama</label>
                <p></p>
                <input type="text" name="nama" id="nama"/>
            </div>
            <p></p>
            <div>
                <label for="alamat">Alamat</label>
                <p></p>
                <input type="text" name="alamat" id="alamat"/>
            </div>
            <p></p>
            <div>
                <label for="tanggalLahir">Tanggal Lahir</label>
                <p></p>
                <input type="text" name="tanggalLahir" id="tanggalLahir" pattern="^(19[5-9][0-9]|20[0-4][0-9]|2050)[-/](0?[1-9]|1[0-2])[-/](0?[1-9]|[12][0-9]|3[01])$"/>
            </div>
            <p></p>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
