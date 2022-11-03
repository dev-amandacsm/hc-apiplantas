package hcapiplantas.service;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category) throws DataAlreadyExistsException;

    Category updateCategory(Long id, Category category) throws DataNotFoundException;

    Category getCategoryById(Long id) throws DataNotFoundException;

    Iterable<Category> getAllCategories();
}
