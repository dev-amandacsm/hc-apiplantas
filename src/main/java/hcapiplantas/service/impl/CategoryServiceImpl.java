package hcapiplantas.service.impl;

import hcapiplantas.model.entity.Category;
import hcapiplantas.repository.CategoryRepository;
import hcapiplantas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category createCategory(Category category) {
        return repository.save(category);
    }

}
