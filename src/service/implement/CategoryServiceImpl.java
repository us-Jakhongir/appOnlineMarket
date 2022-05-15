package service.implement;

import model.Category;
import realization.OnlineMarketDemo;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public boolean addCategory(Category category) {

        if (!OnlineMarketDemo.categories.contains(category)) {
            OnlineMarketDemo.categories.add(category);
            return true;
        }
        return false;

    }

    @Override
    public boolean editCategory(Category category) {
        return false;
    }

    @Override
    public boolean deleteCategory(Long id) {
        return false;
    }

    @Override
    public List<Category> getAllcategory() {
        List<Category> categories = OnlineMarketDemo.categories;


        return categories;

    }
}
