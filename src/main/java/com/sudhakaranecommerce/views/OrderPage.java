package com.sudhakaranecommerce.views;

import com.sudhakaranecommerce.models.Order;
import com.sudhakaranecommerce.models.User;
import com.sudhakaranecommerce.utils.StringUtil;

import java.util.ArrayList;

import static com.sudhakaranecommerce.utils.AppOutput.println;
import static com.sudhakaranecommerce.utils.UserUtil.getLoggedInUser;

public class OrderPage {
    public void printOrders(ArrayList<Order> orders) {
        println(StringUtil.ORDER_MESSAGE);

        User user = getLoggedInUser();
        for(Order order:orders)
        {
            if(order.getUser().getId()==user.getId())
            {
                println(order.getId()+". " + order.getProduct().getProductName() +", "+ order.getDate() +", ₹."+order.getProduct().getPrice());
            }
        }
    }
}
