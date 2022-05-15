package service.implement;

import enums.OrderStatus;
import model.*;
import realization.OnlineMarketDemo;
import service.*;

import java.util.*;

import static realization.OnlineMarketDemo.shoppingCarts;

public class DemonstrationServiceImpl implements DemonstrationService {

    static Scanner scanner;
    static CategoryService categoryService = new CategoryServiceImpl();
    static ProductService productService = new ProductServiceImplement();
    static Long choseCat = null;
    static Integer count = 0;
    static Double amountProducts = 0.0;
    static ShoppingCart shoppingCart = new ShoppingCart();





    Map<Integer, Product> newProduct = new HashMap<>();







    @Override
    public void showCustomerMenu() {

    Long cartId = OnlineMarketDemo.currentUser.getId();
    List<Category> categories = OnlineMarketDemo.categories;
    Map<Product, Integer> productsToBuy = new HashMap<>();
    List<Product> newProductToBuy = new ArrayList<>();
//    ShoppingCart mycart = new ShoppingCart(cartId);

    Double totalAmount = null;
    Double totalPriceProducts = null;

//    Order myOrder = new Order(cartId, OnlineMarketDemo.currentUser, OrderStatus.NEW, totalAmount);
//    OrderDetails myOrderDetails = new OrderDetails(cartId, myOrder, productsToBuy);


//    if(!OnlineMarketDemo.shoppingCarts.contains(mycart)){
//        OnlineMarketDemo.shoppingCarts.add(mycart);
//    }


        scanner = new Scanner(System.in);
        OrderOperationService orderService = new OrderOperationServiceImpl();


        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("\t\t==================CUSTOMER FORM==================\t\t\n");
            System.out.println("+ View All Category      - Cancel      v - View Shopping Cart      o - My Orders\n");
            System.out.println("=================================================================================");
            System.out.println("\nChoose: ");
            String choice = scanner.nextLine();
            System.out.println("-----------------");

            switch (choice) {

                case "+":

                    if (!categories.equals(null)) {

                        System.out.println("Customer / " + OnlineMarketDemo.currentUser.getFullName());
                        System.out.println("\nCategory: ");
                            while (true) {
                                System.out.println("-----------------");
                                for (Category category : categories) {

                                    System.out.println(category.getId() + ". " + category.getName());

                                }


                                System.out.println("-----------------");
                                System.out.println("Choose Category: ");
                                scanner = new Scanner(System.in);
                                choseCat = scanner.nextLong();

                                System.out.println("------------------------------------------------");
                                for (Category category : categories) {
                                    if (category.getId().equals(choseCat)) {
                                        System.out.println("Customer / " + "Category / " + category.getName() + ":");

                                    }
                                }
                                System.out.println();
                                System.out.println(String.format("%1$-2s", "№") + " |    "
                                        + String.format("%1$-10s", "Name")+ " |    "
                                        + String.format("%1$-10s", "Price") +   " |    "
                                        + String.format("%1$-10s", "Category"));
                                System.out.println();
                                for (Product product : OnlineMarketDemo.products ) {
                                    if (product.getCategory().getId().equals(choseCat)) {
                                        System.out.println(String.format("%1$-2s", product.getId()) + " |    "
                                                + String.format("%1$-10s", product.getName())+ " |    "
                                                + String.format("%1$-10s", product.getPrice()) + " |    "
                                                + String.format("%1$-10s", product.getCategory().getName()));
                                        //System.out.println(product.getId() + "-  " + product.getName() + "  |  " + product.getPrice() + "  |  " + product.getCategory().getName());

                                    }
                                }

                                System.out.println("------------------------------------------------");

                                System.out.print("Choose Product to buy: ");
                                Long prodToBuy = scanner.nextLong();



                                int indexNew = newProductToBuy.size();
                                Product productToBuy__ = null;
                                System.out.println("Name  ||  Price ||");
                                for (Product product : OnlineMarketDemo.products ) {
                                    if (product.getId().equals(prodToBuy)) {
                                        System.out.println(product.getName() + "    " +product.getPrice());
                                        newProductToBuy.add(indexNew++, product);
                                        productToBuy__ = product;

                                    }
                                }



                                System.out.print("Amount products: ");
                                amountProducts = scanner.nextDouble();
                                productsToBuy.put(productToBuy__, amountProducts.intValue());

                                List<Product> products = OnlineMarketDemo.products;
                                for (Product product : products) {
                                    if (product.getId().equals(prodToBuy)) {
                                        totalPriceProducts = amountProducts * product.getPrice();
                                        totalAmount = amountProducts;
                                    }
                                }









                                int idShoppingCart = shoppingCarts.size() + 1;

                                shoppingCart.setId((long)idShoppingCart+1);
                                shoppingCart.setProducts(newProductToBuy);
                                shoppingCart.setTotalAmount(totalAmount);
                                shoppingCart.setTotalPrice(totalPriceProducts);



                                shoppingCarts.add(shoppingCart);
                                break;
                            }
                    }
                        System.out.println("Has Not Categories!");


                    break;



                case "v":

                    System.out.println("SHOPPING CART: ");
                    List<ShoppingCart> shoppingCartsS = OnlineMarketDemo.shoppingCarts;
                                for (ShoppingCart cart : shoppingCartsS) {
                                    System.out.println("Id: " + cart.getId() + ".  |  " + cart.getProducts() + "  |  " + "Total Amount: " + cart.getTotalAmount() + "  |  " + "Total Price: " + cart.getTotalPrice());

                                }
                    System.out.println("Do you want to complete your order?");
                    System.out.println("Enter 'y' to finish the payment, or anything else to continue shopping.");
                    scanner = new Scanner(System.in);
                    String choiceStr = scanner.next();
                    if(choiceStr.equals("y") || choiceStr.equals("Y")){
                        orderService.setProducts(shoppingCart);
                        orderService.completePayment();
                        Order order = new Order(OnlineMarketDemo.orders.size()+1L, OnlineMarketDemo.currentUser,
                                OrderStatus.COMPLETED, shoppingCart.getTotalPrice());
                        OrderDetails details = new OrderDetails(OnlineMarketDemo.orderDetails.size()+1L,
                                order, productsToBuy);
                        OnlineMarketDemo.orders.add(order);
                        OnlineMarketDemo.orderDetails.add(details);
                        shoppingCarts.remove(shoppingCart);
                        shoppingCart = new ShoppingCart();
                    }

                    break;

                case "o":
                    List<Order> orders = OnlineMarketDemo.orders;
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    break;

                case "-":
                    return;
            }


        }
    }

    private void chooseOption() {

        System.out.println("What do you want?");

        while (true) {
            System.out.println("1. To Order");
            System.out.println("2. Cancel");

            scanner = new Scanner(System.in);
            Integer choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println();

            }

            switch (choice) {
                case 1:

//                    Product foundProduct = DemonstrationServiceImpl.foundProduct;
                    Integer count = DemonstrationServiceImpl.count;

                    System.out.println(count);
                    break;

                case 2:

                    return;


            }
        }
    }


    @Override
    public void showSalesmanMenu() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n<<<<<<<<<<<<<<<<< SALESMAN MENU >>>>>>>>>>>>>>>>>\n");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Add Category");
            System.out.println("4. Remove Product");
            System.out.println("5. Show All Products");
            System.out.println("6. Exit");
            System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>");

            int choice = scanner.nextInt();
            int innerChoice = 0;
            switch (choice) {
                case 1:
                    System.out.println("-----------------------");

                    System.out.print("Name: ");
                    scanner = new Scanner(System.in);
                    String name = scanner.nextLine();

                    scanner = new Scanner(System.in);
                    System.out.print("Price: ");
                    Double price = scanner.nextDouble();


                    Category category;
                    Category subCategory = null;
                    System.out.println("-----------------------");
                    System.out.println("Choose the Category: ");


//                    int choice = scanner.nextInt();
//        Category selected = categories.get(choice -1);

                    int index = 1;

                    for (Category cat : OnlineMarketDemo.categories) {
                        System.out.println(index + ". " + cat.getName());
                        index++;
                    }


                    System.out.println(index + ". New");
                    scanner = new Scanner(System.in);
                    innerChoice = scanner.nextInt();

                    if (innerChoice > OnlineMarketDemo.categories.size()) {
                        System.out.println("|--------------| New Category Entry |--------------|");
                        scanner = new Scanner(System.in);
                        System.out.println("Name: ");
                        String catName = scanner.nextLine();

                        System.out.println("Description: ");
                        String desCat = scanner.nextLine();

                        long catId = OnlineMarketDemo.categories.size() +1;

                        category = new Category(catId, catName, desCat);

                        categoryService.addCategory(category);

                    } else {
                        category = OnlineMarketDemo.categories.get(innerChoice - 1);
                    }



//                    List<Category> list = categoryService.getAllcategory();

//
                    long prodId = OnlineMarketDemo.products.size() +1;



//
                    Product product = new Product(
                            prodId,
                            name,
                            category,
                            null,
                            price);

                    boolean success = productService.addProduct(product);
                    if (success)
                        System.out.println("Product saved\n");
                    break;

                case 2:
                    scanner = new Scanner(System.in);
                    String updateName = "";
                    double updatePrice = 0.0;


                    System.out.println("ID: ");
                    Integer findKeyProduct = scanner.nextInt();


                    for (Product product1 : OnlineMarketDemo.products) {

                        if (product1.getId().equals(findKeyProduct)) {


                            OnlineMarketDemo.currentProductKey = findKeyProduct;



                            scanner = new Scanner(System.in);
                            System.out.println("--------------------------------");
                            System.out.println("What do want to change?\n");
                            System.out.println("1. Name");
                            System.out.println("2. Price");
                            System.out.println("3. Name and Price");
                            System.out.println("--------------------------------");

                            int choice1 = scanner.nextInt();

                            switch (choice1) {

                                case 1:
                                    scanner = new Scanner(System.in);
                                    System.out.print("Name: ");
                                    updateName = scanner.nextLine();
                                    break;

                                case 2:
                                    scanner = new Scanner(System.in);
                                    System.out.print("Price: ");
                                    updatePrice = scanner.nextDouble();
                                    break;

                                case 3:
                                    scanner = new Scanner(System.in);
                                    System.out.print("Name: ");
                                    updateName = scanner.nextLine();
                                    System.out.print("Price: ");
                                    updatePrice = scanner.nextDouble();
                                    System.out.println("------------------------------");
                                    break;
                            }


                            Long id = product1.getId();
                            Product updateProduct = new Product(
                                    id,
                                    updateName,
                                    product1.getCategory(),
                                    product1.getCategory(),
                                    updatePrice);

                            boolean updatedProduct = productService.editProduct(updateProduct);
                            if (updatedProduct) {
                                System.out.println("Updated Success\n");

                            }
                        }
                    }

                    break;

                case 3:
                    scanner = new Scanner(System.in);
                    System.out.println("Name: ");
                    String nameCategory = scanner.nextLine();

                    System.out.println("Description: ");
                    String description = scanner.nextLine();


                    long catCatId = OnlineMarketDemo.categories.size() +1;

                    category = new Category(
                            catCatId,
                            nameCategory,
                            description
                    );


                    boolean b = categoryService.addCategory(category);
                    if (b)
                        System.out.println("New category successful added ");
                    break;

                case 4:
                    scanner = new Scanner(System.in);
                    System.out.println("ID of product: ");
                    long idProduct = scanner.nextLong();


                    boolean deleted = productService.deleteProduct(idProduct);

                    if (deleted)
                        System.out.println("Deleted success!");

                    break;

                case 5:


                    System.out.println("|----------------| ALL PRODUCTS |----------------|\n");


                    for (Product prod : OnlineMarketDemo.products) {
                        System.out.println(prod);
                    }
                    System.out.println("|------------------------------------------------|\n");
                    break;


                case 6:
                    return;
            }
        }

    }

    private void showDetailsProduct() {

    }

    public void showCategories() {


        List<Category> categories = OnlineMarketDemo.categories;

//        Iterator<Category> iterator = categories.iterator();
//        System.out.println("Choose the Category: ");
//        System.out.println("Categories: " + categoryService.getAllcategory());
//
//        String choice = scanner.nextLine();
//        while (iterator.hasNext()) {
//            if (iterator.next().getName().equals(choice)) {
//                System.out.println("Category: " + choice);
//
//            }
//            return;
//        }





//            if (categories != null && categories.size() != 0 ) {
//                for (Category category : categories) {
//                    if (category.getId().equals(selected))
//                        System.out.println(category);
//                    break;
//                }
//
//            }

    }

    @Override
    public void showManagerMenu() {

    }

    @Override
    public void showDirectorMenu() {

    }
}
