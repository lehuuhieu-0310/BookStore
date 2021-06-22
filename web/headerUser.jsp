<div class="text-white bg-dark font-weight-bold" style="font-size: 18px; margin-bottom: 10px">
    <div class="header clearfix container">
        <div class="row">
            <div class="col-sm-6">
                <nav class="nav">
                    <div class="nav-link">
                        Welcome: ${sessionScope.FULLNAME}
                    </div>
                </nav>
            </div>
            <div class="col-sm-6">
                <ul class="nav justify-content-end ">
                    <li class="nav-item">
                        <a class="nav-link" href="ShoppingHistoryController">Shopping History</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="viewcart.jsp">
                            <i class="fas fa-shopping-cart"></i>
                            Cart <span class="badge badge-primary">${sessionScope.CART.getCart().values().size()}</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="LogoutController" >Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>