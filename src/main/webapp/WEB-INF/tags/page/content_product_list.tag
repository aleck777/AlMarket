<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="ooActiveUser" required="true" type="market.logic.User" %>
<%@ attribute name="ssAddProductResult" required="true" type="java.lang.String" %>

<div class="content-header">
    Product List!
    <hr/>
    <c:if test="${ooActiveUser.access> 2 }" >
        <div class="contnent-header-form-add-product">
            Добавление нового товара:
        </div>
        <div class="content-form-add-product">
            <form class="form-product" action="post">
                <table>
                    <tr>
                        <td>Код товара:</td>
                        <td><input name="product_code" type="text" value="" size="100"></td>
                    </tr><tr>
                        <td>Наименование товара:</td>
                        <td><input name="product_name" type="text" value="" size="100"></td>
                    </tr><tr>
                        <td>Описание товара:</td>
                        <td><input name="product_description" type="text" value="" size="100"></td>
                    </tr><tr>
                        <td>Изображение:</td>
                        <td><input name="product_image" type="text" value="" size="100"></td>
                    </tr><tr>
                        <td><input type="submit" value="Добавить"></td>
                    </tr>
                </table>
                <input name="action" value="product_add" type="hidden">
                <input name="p" value="list" type="hidden">
            </form>
        </div>
    </c:if>
    <c:if test="${ssAddProductResult.equals(\"ProductAddGood\")}">
        <hr/>
        Товар успешно добавлен!<br/>
    </c:if>
</div>

