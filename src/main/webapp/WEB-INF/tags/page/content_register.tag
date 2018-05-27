<%@ tag pageEncoding="UTF-8" %>

<%-- Форма регистрации нового пользователя --%>

<div class="contnent-header-register">
    Регистрация нового пользователя
</div>
<div class="content-form-register">
    <form class="form-register" action="post">
        <table>
        <tr>
            <td>ФИО:</td>
            <td><input name="fio" type="text" value="" size="30"></td>
        </tr><tr>
            <td>Логин:</td>
            <td> <input name="login" type="text" value="" size="30"> </td>
        </tr><tr>
            <td>Пароль:</td>
            <td> <input name="password" type="text" value="" size="30"> </td>
        </tr><tr>
            <td>Email:</td>
            <td><input name="email" type="email" value="" size="30"> </td>
        </tr><tr>
            <td><input type="submit" value="Зарегистрироваться"></td>
        </tr>
        </table>
        <input name="action" value="register" type="hidden">
        <input name="p" value="main" type="hidden">
    </form>
</div>

