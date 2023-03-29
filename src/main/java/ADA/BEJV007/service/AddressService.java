package org.example.service;

import org.example.domain.Address;
import java.util.List;

public interface AddressService {
    List<Address> list();
    Address save(Address address);
    Address findById(Long id);
    Address update (Long id, Address address);
    void delete (Long id);
}
