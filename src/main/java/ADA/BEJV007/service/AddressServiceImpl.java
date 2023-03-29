package ADA.BEJV007.service;

import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Address;
import ADA.BEJV007.exceptions.AddressNotFoundException;
import ADA.BEJV007.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Override
    public List<Address> list() {
        return (List<Address>) repository.findAll();
    }

    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Override
    public Address findById(Long id) {
        return repository.findById(id).orElseThrow(AddressNotFoundException::new);
    }

    @Override
    public Address update(Long id, Address address) {
        if(repository.existsById(id)){
            address.setId(id);
            return repository.save(address);
        }
        throw new AddressNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new AddressNotFoundException();
        }
        repository.deleteById(id);
    }
}
