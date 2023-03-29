package ADA.BEJV007.service;

import ADA.BEJV007.domain.Address;
import java.util.List;

public interface AddressService {
    List<Address> list();
    Address save(Address address);
    Address findById(Long id);
    Address update (Long id, Address address);
    void delete (Long id);
}
