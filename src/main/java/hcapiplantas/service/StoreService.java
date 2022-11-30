package hcapiplantas.service;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.StoreRequestDto;
import hcapiplantas.model.entity.Store;

import java.util.List;

public interface StoreService {
    Store createStore(StoreRequestDto request) throws DataAlreadyExistsException, DataNotFoundException;

    Store getStoreById(Long id) throws DataNotFoundException;

    List<Store> getAllStores();

    List<Store> getAllStoresLimited(Long numberOfResults);
}
