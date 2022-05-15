package realization;

import enums.Role;
import model.*;
import service.CategoryService;
import service.DemonstrationService;
import service.RegistrationService;
import service.implement.CategoryServiceImpl;
import service.implement.DemonstrationServiceImpl;
import service.implement.RegistrationServiceImpl;

import java.util.*;

public class OnlineMarketDemo {

    public static Scanner scanner = new Scanner(System.in);

    public static Set<User> users = new HashSet<>();




//    public static List<Category> categories = new ArrayList<>();
//
//    public static Map<Integer, Product> products = new HashMap<>();
//    public static Map<Integer, Warehouse> warehouseHashMap = new HashMap<>();



    public static List<Category> categories = new ArrayList<>();
    public static Map<Category, Category> subCategories = new HashMap<>();
    public static List<Product> products = new ArrayList<>();


    public static List<Order> orders = new ArrayList<>();
    public static List<OrderDetails> orderDetails = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();





    public static List<Product> tempList = new LinkedList<>();

    static RegistrationService registrationService;
    static DemonstrationService demonstrationService;
    static CategoryService categoryService = new CategoryServiceImpl();



    public static User currentUser;
    public static Integer currentProductKey;




    public static void main(String[] args) {


        users.add(new User(1L, "Ali Aliyev", "ali@mail.com", "123", Role.CUSTOMER));
        users.add(new User(2L, "Olim Olimov", "olim@yahoo.ru", "123", Role.SALESMAN));
        users.add(new User(2L, "Bek Bekov", "bek@gmail.ru", "123", Role.DIRECTOR));
        users.add(new User(2L, "Vali Valiyev", "vali@gmail.ru", "123", Role.MANAGER));


        categories.add(new Category(1L, "Meva", "mevalar uchun"));
        categories.add(new Category(2L, "Texnika", "texnikalar uchun"));
        categories.add(new Category(3L, "Elektronika", "elektronika uchun"));
        categories.add(new Category(4L, "Ko'chmas Mulk", "binolar uchun"));


        products.add(new Product(1L,"Olma", categories.get(0), null, 15000.0));
        products.add(new Product(2L,"Nok", categories.get(0), null, 25000.0));
        products.add(new Product(3L,"Anor", categories.get(0), null, 20000.0));

        products.add(new Product(4L,"Neksiya", categories.get(1), null, 80_000_000.0));
        products.add(new Product(5L,"Matiz", categories.get(1), null, 40_000_000.0));

        products.add(new Product(6L,"RedMe", categories.get(2), null, 2_000_000.0));
        products.add(new Product(7L, "Nokia", categories.get(2), null, 1_000_000.0));

        products.add(new Product(8L, "4 xonali uy", categories.get(3), null, 1_000_000.0));
        products.add(new Product(9L, "3 xonali uy", categories.get(3), null, 1_000_000.0));



        int choice;

        do {
            showMainMenu();

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    signIn();
                    break;

                case 2:
                    signUp();
                    break;
                default:
                    System.out.println("Incorrect option!");
            }






        } while (choice !=0 );



    }

    private static void signUp() {
        registrationService = new RegistrationServiceImpl();
        boolean isSuccess = registrationService.signUp();
        if (isSuccess)
            //TODO will write logic here
            System.out.println("Success!");
        else
            System.out.println("Something went wrong!");
    }

    private static void signIn() {
        registrationService = new RegistrationServiceImpl();
        boolean isSuccess = registrationService.signIn();

        System.out.println();
        if (isSuccess) {
            demonstrationService = new DemonstrationServiceImpl();

            switch (currentUser.getRole()) {
                case CUSTOMER:
                    demonstrationService.showCustomerMenu();
                    break;

                case SALESMAN:
                    demonstrationService.showSalesmanMenu();
                    break;

                case MANAGER:
                    demonstrationService.showManagerMenu();
                    break;

                case DIRECTOR:
                    demonstrationService.showDirectorMenu();
                    break;

            }
        } else {
            System.out.println("User not found!");
        }


    }

    private static void showMainMenu() {

        System.out.println("Menu");
        System.out.println("1. Sign In");
        System.out.println("2. Sign Up");
        System.out.println("0. Exit");

    }

}
