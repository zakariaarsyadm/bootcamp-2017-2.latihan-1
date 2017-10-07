<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ubah Data Ruang</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.getContext(uripath)}/ruang/ubah" method="post">
             <input type="hidden" name="id" value="${ruang.id}">
            <div>
                <label for="noRuang">No Ruang</label>
                <input type="text" name="noRuang" id="${ruang.noRuang}"/>
            </div>
            <div>
                <label for="kosong">Kosong ?</label>
                <select name="kosong" id="${ruang.kosong}">
                    <option value="true">Ya</option>
                    <option value="false">Tidak</option>
                </select>
            </div>
        </form>
    </body>
</html>
