<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ubah Data Ruang</title>
    </head>
    <body>
        <h1 align="center">Ubah Data Ruang</h1>
        <form action="${pageContext.servletContext.contextPath}/ruang/ubah" method="post" align="center">
            <input type="hidden" name="id" value="${ruang.id}">
            <div>
                <label for="noRuang">No Ruang</label>
                <p></p>
                <input type="text" name="noRuangan" id="noRuangan" value="${ruang.noRuangan}"/>
            </div>
            <p></p>
            <div>
                <label for="kosong">Kosong ?</label>
                <p></p>
                <select name="kosong" id="${ruang.kosong}">
                    <option value="true">Ya</option>
                    <option value="false">Tidak</option>
                </select>
            </div>
            <p></p>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
