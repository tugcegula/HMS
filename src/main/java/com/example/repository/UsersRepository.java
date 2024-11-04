package com.example.repository;

import com.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByIdentityNo(long identityNo);
    List<Users> findByName(String name);
    List<Users> findBySurname(String surname);

}
