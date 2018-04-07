<%@ tag pageEncoding="UTF-8" %>

<%-- Форма регистрации нового пользователя --%>

<div class="contnent-header-register">
    Регистрация нового пользователя
</div>
<div class="content-form-register">
    <form class="form-register" action="?action=register">
        <table>
        <tr>
            <td>ФИО:</td>
            <td><input name="FIO" type="text" value="" size="30"></td>
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
            <td><input type="submit"></td>
        </tr>
        </table>
    </form>
</div>

