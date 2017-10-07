<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Pasien</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/pasien/add" method="post">
            <div>
                <label for="nama">Nama : </label>
                <input type="text" name="nama" id="nama"/>
            </div>
            <div>
                <label for="alamat">Alamat : </label>
                <input type="text" name="alamat" id="alamat"/>
            </div>
            <div>
                <label for="tanggalLahir">Tanggal Lahir : </label>
                <input type="text" name="tanggalLahir" id="tanggalLahir" pattern="^(19[5-9][0-9]|20[0-4][0-9]|2050)[-/](0?[1-9]|1[0-2])[-/](0?[1-9]|[12][0-9]|3[01])$"/>
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
