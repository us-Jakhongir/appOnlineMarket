package service;

import model.Product;
import model.ShoppingCart;

import java.util.List;

public interface ShoppingCardService {

    boolean addShop(Product product, Double totalAmount);

    ShoppingCart getShop();

    boolean deleteShop(Long id);

}
