package service.implement;

import com.sun.xml.internal.ws.policy.AssertionSet;
import jdk.nashorn.internal.ir.IfNode;
import model.Product;
import realization.OnlineMarketDemo;
import service.ProductService;

import java.util.List;
import java.util.Map;
import java.util.Set;

//import static realization.OnlineMarketDemo.currentProductKey;

public class ProductServiceImplement implements ProductService {

    @Override
    public Product getAllProducts() {
        if (OnlineMarketDemo.products.size() != 0) {
            List<Product> products = OnlineMarketDemo.products;

        }
        return null;
    }


    @Override
    public boolean addProduct(Product product) {

        OnlineMarketDemo.products.add(product);
        return true;
    }

    @Override
    public boolean editProduct(Product product) {
        if (OnlineMarketDemo.currentProductKey.equals(product.getId())) {
            OnlineMarketDemo.products.add(product);
            return true;

        }
        return false;

    }

    @Override
    public boolean deleteProduct(Long id) {

        if (OnlineMarketDemo.products.size() > 0) {
            for (Product product : OnlineMarketDemo.products) {
                if (product.getId().equals(id)) {
                    OnlineMarketDemo.products.remove(product);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Product findById(Long id) {
        List<Product> products = OnlineMarketDemo.products;
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}