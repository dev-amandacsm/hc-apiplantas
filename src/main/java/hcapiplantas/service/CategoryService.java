package hcapiplantas.service;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.model.entity.Category;

public interface CategoryService {

    Category createCategory(Category category) throws DataAlreadyExistsException;

}
