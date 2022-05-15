package model;

public class Product {

    private Long id;
    private String name;
    private Category category;
    private Category subCategory;
    private Double price;

    public Product() {

    }

    public Product(Long id, String name, Category category, Category subCategory, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.subCategory = subCategory;
        this.price = price;
    }


    public Product(String name, Category category, Category subCategory, Double price) {
        this.name = name;
        this.category = category;
        this.subCategory = subCategory;
        this.price = price;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Category subCategory) {
        this.subCategory = subCategory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return   name + "  |  " + "Price: " + price + "  |  " + category;


    }
}

