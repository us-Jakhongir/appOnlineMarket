package model;

import java.util.List;
import java.util.Map;

public class Warehouse {

    private Long id;
    private String name;
    private Integer number;
    private List<Product> products;

    public Warehouse(Long id, String name, Integer number, List<Product> products) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.products = products;
    }

    public Warehouse(){

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Warehouse: " +
                "id: " + id + "\n" +
                "name: " + name + "\n" +
                "number: " + number +
                "products: " + products +
                "\n";
    }
}
