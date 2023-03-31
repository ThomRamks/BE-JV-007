package ADA.BEJV007.service;

import ADA.BEJV007.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Address;
import ADA.BEJV007.exceptions.AddressNotFoundException;
import ADA.BEJV007.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements GeneralService <Address> {

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
    public Address saveHtml(Address address) {
        repository.save(address);
        return address;
    }

    @Override
    public Address findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Endereço"));
    }

    @Override
    public Address update(Long id, Address address) {
        if(repository.existsById(id)){
            address.setId(id);
            return repository.save(address);
        }
        throw new NotFoundException("Endereço");
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new NotFoundException("Endereço");
        }
        repository.deleteById(id);
    }
}
