package service;

import model.Product;

import java.util.List;

public interface ProductService {

    boolean addProduct(Product product);

    boolean editProduct(Product product);

    boolean deleteProduct(Long id);


    Product findById(Long id);

    Product getAllProducts();

}
