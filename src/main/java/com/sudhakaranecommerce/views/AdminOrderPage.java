package com.sudhakaranecommerce.views;

import com.sudhakaranecommerce.models.Order;
import com.sudhakaranecommerce.utils.StringUtil;

import java.util.ArrayList;

import static com.sudhakaranecommerce.utils.AppOutput.println;

public class AdminOrderPage {
    public void viewOrders(ArrayList<Order> orders) {
        println(StringUtil.ORDER_MESSAGE);

        for (Order order : orders) {

            println(order.getId() + ". " + order.getProduct().getProductName() + ", "+"Ordered By: "+order.getUser().getEmail()+ ", " + order.getDate() + ", ₹." + order.getProduct().getPrice());

        }
    }
}
