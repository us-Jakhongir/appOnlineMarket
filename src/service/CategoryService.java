package service;

import model.Category;

import java.util.List;

public interface CategoryService<category> {

    boolean  addCategory(Category category);

    boolean editCategory(Category category);

    boolean deleteCategory(Long id);



    List<Category> getAllcategory();


}
