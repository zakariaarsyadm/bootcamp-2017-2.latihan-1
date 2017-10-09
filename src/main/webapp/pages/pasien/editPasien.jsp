<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Data Pasien</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/pasien/ubah" method="post">
            <input type="hidden" name="id" value="${pasien.id}">
            <div>
                <label for="nama">Nama : </label>
                <input type="text" name="nama" id="nama" value="${pasien.nama}"/>
            </div>
            <div>
                <label for="alamat">Alamat : </label>
                <input type="text" name="alamat" id="alamat" value="${pasien.alamat}"/>
            </div>
            <div>
                <label for="tanggalLahir">Tanggal Lahir : </label>
                <input type="date" name="tanggalLahir" id="tanggalLahir" value="${pasien.tanggalLahir}"/>
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
