package hcapiplantas.service.impl;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.entity.Category;
import hcapiplantas.repository.CategoryRepository;
import hcapiplantas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.swing.text.html.Option;
import java.util.Optional;

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
        Optional<Category> existingCategory = repository.findById(id);
        if(existingCategory.isEmpty())
            throw new DataNotFoundException(id.toString());
        existingCategory.get().setName(category.getName());
        existingCategory.get().setDescription(category.getDescription());
        return repository.save(existingCategory.get());
    }
}
