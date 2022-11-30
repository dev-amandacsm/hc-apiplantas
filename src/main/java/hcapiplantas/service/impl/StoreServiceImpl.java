package hcapiplantas.service.impl;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.StoreRequestDto;
import hcapiplantas.model.entity.Store;
import hcapiplantas.repository.DistrictRepository;
import hcapiplantas.repository.StoreRepository;
import hcapiplantas.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository repository;
    private final DistrictRepository districtRepository;

    @Override
    public Store createStore(StoreRequestDto request) throws DataAlreadyExistsException, DataNotFoundException {
        if(repository.findByName(request.getName()).isPresent())
            throw new DataAlreadyExistsException(request.getName());

        Store store = new Store();
        store.setName(request.getName());
        store.setDescription(request.getDescription());
        store.setContact(request.getContact());
        store.setStreet(request.getStreet());
        store.setAddressComplement(request.getAddressComplement());
        store.setDistrict(districtRepository.findByName(request.getDistrictName()).orElseThrow(() -> new DataNotFoundException(request.getDistrictName())));

        return repository.save(store);
    }

    @Override
    public Store getStoreById(Long id) throws DataNotFoundException {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(id.toString()));
    }

    @Override
    public List<Store> getAllStores() {
        List<Store> stores = new ArrayList<>();
        repository.findAll().forEach(stores::add);
        return stores;
    }

    @Override
    public List<Store> getAllStoresLimited(Long numberOfResults) {
        return new ArrayList<>(repository.findAllLimited(numberOfResults));
    }

}
