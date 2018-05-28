<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="ooActiveUser" required="true" type="market.logic.User" %>
<%@ attribute name="ssAddProductResult" required="true" type="java.lang.String" %>
<%@ attribute name="products" required="true" type="java.util.Collection" %>

<div class="content-header">
    Product List!
    <div class="content-grid">
    <c:forEach var="product" items="${products}">
        <div class="content-product">
            <p class="content-product-name"><c:out value="${product.getName()}"/></p>
            <p class="content-product-description"><c:out value="${product.getDescription()}"/> </p>
            <img src="${product.getImage()}" class="content-product-image"/>
            <form class="form-product-add-to-basket" action="post">
                <input type="hidden" name="product" value="${product.getCode()}"/>
                <input name="action" value="product_add_to_basket" type="hidden">
                <input name="p" value="list" type="hidden">
                <input type="submit" value="Добавить в корзину">
            </form>
        </div>
    </c:forEach>
    </div>
    <hr/>
    <c:if test="${ooActiveUser.access> 2 }" >
        <div class="contnent-header-form-add-product">
            Добавление нового товара:
        </div>
        <div class="content-form-add-product">
            <form class="form-product-add" action="post">
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

