package org.rdutta.localaccounts.utilities.features.mapper;

import org.rdutta.localaccounts.dto.auth_dto.AddressDto;
import org.rdutta.localaccounts.dto.auth_dto.UsersDto;
import org.rdutta.localaccounts.entities.sso.Address;
import org.rdutta.localaccounts.entities.sso.Users;
import org.rdutta.localaccounts.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsersMapper {

    private final AddressMapper addressMapper;

    @Autowired
    public UsersMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Users toUsers(UsersDto dto) {
        List<Address> addresses = addressMapper.toAddress(dto.addresses());
        Users users = Users.builder()
                .firstname(dto.firstName())
                .lastname(dto.lastName())
                .username(dto.username())
                .email(dto.email())
                .password(new BCryptPasswordEncoder().encode(dto.password()))
                .phone(dto.phone())
                .roles(Roles.valueOf(dto.role()))
                .dateOfBirth(dto.dob().toLocalDate())
                .createdAt(LocalDateTime.now())
                .build();

        users.setAddresses(addresses);
        return users;
    }

    public UsersDto toUsersDto(Users users) {
        List<AddressDto> addressDtoList = addressMapper.toAddressDto(users.getAddresses());

        return new UsersDto(
                users.getFirstname(),
                users.getLastname(),
                users.getUsername(),
                users.getPassword(),
                users.getEmail(),
                users.getPhone(),
                users.getRoles().name(),
                addressDtoList,
                users.getDateOfBirth().atStartOfDay(),
                users.getCreatedAt()
        );
    }
}