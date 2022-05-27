<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="parts/header.jsp" />

<main class="sandwiches">
    <div class="container">
        <h1>Sandwiches</h1>
        <div class="sandwiches-list">
            <c:forEach items="${products}" var="product">
                <div class="card">
                    <div class="card_img">
                        <img src="${product.picture}" alt="">
                    </div>
                    <h2 class="card_title">${product.name}</h2>
                    <p class="card_price">${product.price} $</p>
                    <p class="card_description">${product.description}</p>
                    <div class="card_button_container">
                        <a href="/sandwiches/${product.id}" class="card_button">See more</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</main>

<jsp:include page="parts/footer.jsp" />