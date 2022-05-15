package service.implement;

import model.Product;
import model.ShoppingCart;
import service.OrderOperationService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class OrderOperationServiceImpl implements OrderOperationService {
    Double totalAmount = 0.0;
    Map<Product, Integer> products;
    ShoppingCart myCart;
    Scanner scanner = new Scanner(System.in);
    @Override
    public boolean addOrder() {
        return false;
    }

    @Override
    public void setProducts(ShoppingCart shoppingCart) {
        this.myCart = shoppingCart;
        this.totalAmount = shoppingCart.getTotalPrice();
    }

    @Override
    public boolean addProductToOrder(Product product, Integer productQty) {
        if(products != null){
            if(products.containsKey(product)){
                int quantity = products.get(product);
                products.replace(product, quantity+productQty);
                totalAmount += product.getPrice() * productQty;
                return true;

            }else {
                products.put(product, productQty);
                totalAmount+=product.getPrice() * productQty;
                return true;
            }
        }
        else {
            products = new HashMap<>();
            products.put(product, productQty);
            totalAmount+= product.getPrice() * productQty;
            return true;
        }
    }

    @Override
    public boolean cancelOrder() {
        return false;
    }

    @Override
    public void completePayment() {
        System.out.println("Total amount: " + totalAmount);
        System.out.print("Enter amount to be paid (cash): ");
        Double amount = scanner.nextDouble();
        if(Objects.equals(totalAmount, amount)){
            System.out.println("Payment completed.");
            System.out.println(myCart);
        }
    }
}
