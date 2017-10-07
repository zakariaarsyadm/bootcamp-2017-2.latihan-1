<%@page isELIgnored="false" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Ruang</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.getContext(uripath)}/ruang/add" method="post">
            <div>
                <label for="noRuang">No Ruang</label>
                <input type="text" name="noRuang" id="noRuang"/>
            </div>
            <div>
                <label for="kosong">Kosong ?</label>
                <select name="kosong" id="kosong">
                    <option value="true">Ya</option>
                    <option value="false">Tidak</option>
                </select>
            </div>
        </form>
    </body>
</html>
