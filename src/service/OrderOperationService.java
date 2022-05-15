package service;

import model.Product;
import model.ShoppingCart;

public interface OrderOperationService {


   boolean addOrder();

   boolean addProductToOrder(Product product, Integer producQty);

   boolean cancelOrder();

    void completePayment();

    void setProducts(ShoppingCart shoppingCart);

}
