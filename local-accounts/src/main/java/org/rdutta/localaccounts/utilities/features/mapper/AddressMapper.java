package org.rdutta.localaccounts.utilities.features.mapper;

import org.rdutta.localaccounts.dto.auth_dto.AddressDto;
import org.rdutta.localaccounts.entities.sso.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressMapper {

    public List<Address> toAddress(List<AddressDto> addressDtoList) {
        return addressDtoList.stream().map(dto -> Address.builder()
                .street(dto.street())
                .city(dto.city())
                .state(dto.state())
                .zipCode(dto.zipcode())
                .country(dto.country())
                .build()).collect(Collectors.toList());
    }

    public List<AddressDto> toAddressDto(List<Address> addresses) {
        return addresses.stream().map(address -> new AddressDto(
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getCountry()
        )).collect(Collectors.toList());
    }
}