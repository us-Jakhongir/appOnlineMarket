package service;

import model.Product;
import model.Warehouse;

public interface WarehouseService {


    boolean addProduct(Warehouse warehouse);

    boolean deleteProduct(Long id);


}
