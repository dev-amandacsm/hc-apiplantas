package hcapiplantas.controller;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.StoreRequestDto;
import hcapiplantas.model.dto.StoreResponseDto;
import hcapiplantas.model.entity.Store;
import hcapiplantas.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lojas")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<StoreResponseDto> createStore(@Valid @RequestBody StoreRequestDto request) throws DataAlreadyExistsException, URISyntaxException, MalformedURLException, DataNotFoundException {
        Store store = storeService.createStore(request);
        StoreResponseDto storeResponseDto = StoreResponseDto.fromEntityToResponse(store);
        storeResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + store.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(storeResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponseDto> getStoreById(@PathVariable String id) throws DataNotFoundException, URISyntaxException, MalformedURLException {
        Store store = storeService.getStoreById(Long.valueOf(id));
        return ResponseEntity.ok(StoreResponseDto.fromEntityToResponse(store));
    }

    @GetMapping
    public ResponseEntity<List<StoreResponseDto>> getAllStoresLimited() throws URISyntaxException {
        List<StoreResponseDto> storeResponseDtoList = new ArrayList<>();
        List<Store> stores = storeService.getAllStoresLimited(4L);

        for (Store store : stores) {
            StoreResponseDto storeResponseDto = StoreResponseDto.fromEntityToResponse(store);
            storeResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + store.getId()));
            storeResponseDtoList.add(storeResponseDto);
        }

        return ResponseEntity.ok(storeResponseDtoList);
    }
}
