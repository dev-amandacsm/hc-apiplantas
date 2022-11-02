package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.model.dto.CategoryRequestDto;
import hcapiplantas.model.dto.CategoryResponseDto;
import hcapiplantas.model.entity.Category;
import hcapiplantas.service.impl.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl service;

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto request) throws DataAlreadyExistsException {
        Category category = convertToEntity(request);
        CategoryResponseDto response = convertToDto(service.createCategory(category));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    private Category convertToEntity(CategoryRequestDto data){
        Category category = new Category();
        category.setName(data.getName());
        category.setDescription(data.getDescription());
        return category;
    }

    private CategoryResponseDto convertToDto(Category data){
        return CategoryResponseDto
                .builder()
                .id(data.getId().toString())
                .name(data.getName())
                .description(data.getDescription())
                .build();
    }

}
