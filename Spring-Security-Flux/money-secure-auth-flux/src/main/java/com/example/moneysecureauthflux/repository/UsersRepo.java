package com.example.moneysecureauthflux.repository;

import com.example.moneysecureauthflux.domain.Users;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@Repository
public interface UsersRepo extends ReactiveCrudRepository<Users, Long> {

    Mono<Users> findUsersByUsername(String username);

    Mono<Users> findFirstByUsername(String username);

    Mono<Users> findFirstByCbuCode(String cbuCode);
}
