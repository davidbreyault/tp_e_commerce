<jsp:include page="parts/header.jsp" />

<main class="sandwich">
    <div class="container">
        <h1>${product.name}</h1>
        <div class="card">
            <div class="card_img">
                <img src="${product.picture}" alt="">
            </div>
            <div class="card_text">
                <div class="card_text--infos">
                    <p class="card_price"><span>Price : </span>${product.price} $</p>
                    <p class="card_quantity"><span>Quantity : </span>${product.quantity}</p>
                    <p class="card_description">${product.description}</p>
                    <p class="card_description--extra"><br/>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt. Placerat duis ultricies lacus sed turpis. Orci eu lobortis elementum nibh tellus molestie nunc non blandit. Tristique sollicitudin nibh sit amet commodo nulla facilisi nullam. Sit amet consectetur adipiscing elit duis tristique sollicitudin. Consequat mauris nunc congue nisi vitae. Vivamus arcu felis bibendum ut tristique et egestas. Et leo duis ut diam quam nulla porttitor massa. Cras pulvinar mattis nunc sed. Nullam eget felis eget nunc lobortis mattis aliquam faucibus purus.</p>
                </div>
                <div class="card_button_container">
                    <a href="/sandwiches/${product.id}" class="card_button">Add to cart</a>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="parts/footer.jsp" />