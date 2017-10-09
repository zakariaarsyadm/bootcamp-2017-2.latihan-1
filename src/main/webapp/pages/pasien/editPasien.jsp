<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Data Pasien</title>
    </head>
    <body>
        <h1 align="center">Ubah Data Pasien</h1>
        <form action="${pageContext.servletContext.contextPath}/pasien/ubah" method="post" align="center">
            <input type="hidden" name="id" value="${pasien.id}">
            <div>
                <label for="nama">Nama</label>
                <p></p>
                <input type="text" name="nama" id="nama" value="${pasien.nama}"/>
            </div>
            <p></p>
            <div>
                <label for="alamat">Alamat</label>
                <p></p>
                <input type="text" name="alamat" id="alamat" value="${pasien.alamat}"/>
            </div>
            <p></p>
            <div>
                <label for="tanggalLahir">Tanggal Lahir</label>
                <p></p>
                <input type="date" name="tanggalLahir" id="tanggalLahir" value="${pasien.tanggalLahir}"/>
            </div>
            <p></p>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
