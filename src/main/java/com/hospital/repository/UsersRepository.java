package com.hospital.repository;

import com.hospital.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByIdentityNo(long identityNo);
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);

    List<Users> findByName(String name);
    List<Users> findBySurname(String surname);

}
