package hcapiplantas.service.impl;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.entity.Category;
import hcapiplantas.repository.CategoryRepository;
import hcapiplantas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category createCategory(Category category) throws DataAlreadyExistsException {
        if(repository.findByName(category.getName()).isEmpty())
            return repository.save(category);
        throw new DataAlreadyExistsException(category.getName());
    }

    @Override
    public Category updateCategory(Long id, Category category) throws DataNotFoundException {
        Category existingCategory = getCategoryById(id);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return repository.save(existingCategory);
    }

    @Override
    public Category getCategoryById(Long id) throws DataNotFoundException {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(id.toString()));
    }

    @Override
    public Iterable<Category> getAllCategories() {
        return repository.findAll();
    }
}
