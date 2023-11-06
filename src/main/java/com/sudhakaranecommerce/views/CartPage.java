package com.sudhakaranecommerce.views;

import com.sudhakaranecommerce.models.Cart;
import com.sudhakaranecommerce.utils.StringUtil;

import java.util.ArrayList;

import static com.sudhakaranecommerce.utils.AppOutput.println;
import static com.sudhakaranecommerce.utils.UserUtil.getLoggedInUser;

public class CartPage {
    public void printCart(ArrayList<Cart> carts) {
        println(StringUtil.CART_MESSAGE);
        for(Cart cart: carts)
        {
            if(cart.getUser().getId()==getLoggedInUser().getId())
            {
                println(cart.getId()+"." +cart.getProduct().getProductName() +", ₹."+ cart.getProduct().getPrice()*cart.getCount() +", Quantity: "+cart.getCount());

            }
        }
    }
}
