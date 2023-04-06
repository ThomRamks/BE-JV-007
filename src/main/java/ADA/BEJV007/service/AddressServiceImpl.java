package ADA.BEJV007.service;

import ADA.BEJV007.exceptions.NotFoundException;
import ADA.BEJV007.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import ADA.BEJV007.domain.Address;
import ADA.BEJV007.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements GeneralService <Address> {

    private final APIConsumer consumer;
    private final AddressRepository repository;
    private final ProfileRepository profileRepository;

    @Override
    public List<Address> list() {
        return (List<Address>) repository.findAll();
    }

    @Override
    public Address save(Address address) {
        Address addressAux = consumer.apiAddress(address);
        addressAux.setNumero(address.getNumero());
        addressAux.setAdicional(address.getAdicional());
        return repository.save(addressAux);
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
            Address addressAux = consumer.apiAddress(address);
            addressAux.setId(id);
            addressAux.setNumero(address.getNumero());
            addressAux.setAdicional(address.getAdicional());
            return repository.save(addressAux);
        }
        throw new NotFoundException("Endereço");
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new NotFoundException("Endereço");
        }
        if(profileRepository.existsByEndereco_Id(id)){
            profileRepository.findByEndereco_Id(id).setEndereco(null);
        }
        repository.deleteById(id);
    }
}
