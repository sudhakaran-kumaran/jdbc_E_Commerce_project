package com.sudhakaranecommerce.controllers;

import com.sudhakaranecommerce.dao.CartDao;
import com.sudhakaranecommerce.dao.OrderDao;
import com.sudhakaranecommerce.models.Cart;
import com.sudhakaranecommerce.models.Order;
import com.sudhakaranecommerce.models.User;
import com.sudhakaranecommerce.utils.AppException;
import com.sudhakaranecommerce.utils.StringUtil;
import com.sudhakaranecommerce.views.OrderPage;

import java.util.ArrayList;

import static com.sudhakaranecommerce.utils.AppInput.enterInteger;
import static com.sudhakaranecommerce.utils.AppOutput.println;
import static com.sudhakaranecommerce.utils.UserUtil.getLoggedInUser;

public class OrderController {

    private final OrderPage orderPage;
    private final OrderDao orderDao;

    private final CartDao cartDao;

    private final HomeController homeController;

    public OrderController(HomeController homeController) {
        this.orderPage = new OrderPage();
        this.orderDao = new OrderDao();
        this.cartDao = new CartDao();
        this.homeController= homeController;
    }

    private static ArrayList<Cart> carts = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    public void orderedItems() {
        User user = getLoggedInUser();
        carts=orderDao.getUserCartItems(user.getId());
        orderDao.AddUserOrders(carts);
        cartDao.updateCart(user.getId());
        println(StringUtil.ORDER_SUCCESSFUL);
    }

    public void OrderedItemsList() {
        User user = getLoggedInUser();
        orders=orderDao.getOrders(user.getId());
        if(!orders.isEmpty())
        {
            orderPage.printOrders(orders);
            println(StringUtil.BACK);
            int choice;
            try {
                choice = enterInteger(StringUtil.CHOICE);
                if (choice == 100) {
                    homeController.printMenu();
                } else {
                    invalidException(new AppException(StringUtil.INVALID_CHOICE));
                }
            } catch (AppException e) {
                invalidException(e);
            }
        }
        else
        {
            println(StringUtil.ORDER_EMPTY);
            homeController.printMenu();
        }

    }
    private void invalidException(AppException e) {
        println(e.getMessage());
        OrderedItemsList();
    }
}
