package service.implement;

import model.Product;
import model.ShoppingCart;
import realization.OnlineMarketDemo;
import service.ShoppingCardService;

import java.util.List;

public class ShoppingCardServiceImpl implements ShoppingCardService {

    @Override
    public boolean addShop(Product product, Double totalAmount) {
        int i = OnlineMarketDemo.shoppingCarts.size() + 1;


        return false;
    }

    @Override
    public ShoppingCart getShop() {
        for (ShoppingCart shoppingCart : OnlineMarketDemo.shoppingCarts) {
            if (shoppingCart != null) {
                return shoppingCart;
            }
        }

        return null;

    }

    @Override
    public boolean deleteShop(Long id) {
        return false;
    }
}
