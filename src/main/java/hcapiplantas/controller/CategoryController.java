package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.CategoryRequestDto;
import hcapiplantas.model.dto.CategoryResponseDto;
import hcapiplantas.model.entity.Category;
import hcapiplantas.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) throws DataNotFoundException {
        return ResponseEntity.ok(convertToDto(service.getCategoryById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(){
        List<CategoryResponseDto> categories = new ArrayList<>();
        service.getAllCategories().forEach(category -> categories.add(convertToDto(category)));
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto request) throws DataAlreadyExistsException {
        Category category = convertToEntity(request);
        CategoryResponseDto response = convertToDto(service.createCategory(category));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryRequestDto request) throws DataNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(service.updateCategory(id, convertToEntity(request))));
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
