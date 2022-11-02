package hcapiplantas.service.impl;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.model.entity.Category;
import hcapiplantas.repository.CategoryRepository;
import hcapiplantas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category createCategory(Category category) throws DataAlreadyExistsException {
        if(ObjectUtils.isEmpty(repository.findByName(category.getName())))
            return repository.save(category);
        throw new DataAlreadyExistsException(category.getName());
    }
}
