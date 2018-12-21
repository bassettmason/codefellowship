package com.bassettmason.codefellowship;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {

    public Optional<ApplicationUser> findByUserName(String userName);
}

