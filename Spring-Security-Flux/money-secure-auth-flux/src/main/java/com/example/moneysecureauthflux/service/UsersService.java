package com.example.moneysecureauthflux.service;

import com.example.moneysecureauthflux.domain.Users;
import com.example.moneysecureauthflux.exception.handling.ApiErrorMessages;
import com.example.moneysecureauthflux.repository.UsersRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UsersService {
    //
    @Autowired
    private final UsersRepo userRepo;
    private final Logger LOG = LoggerFactory.getLogger(UsersService.class);

    public UsersService(UsersRepo usersRepo) {
        this.userRepo = usersRepo;

    }

    public Mono<Void> deleteUser(Long id) {
        return this.usersRepo.deleteById(id)
                .onErrorMap(err -> {
                    LOG.error("Error (deleteUser) : [{}]", err.getMessage());
                    throw new DatabaseException(ApiErrorMessages.INTERNAL_SERVER_ERROR + " [ " + err.getMessage() + " ]");
                });

    }
    public Mono<Users> getByCbuCode(String cbuCode) {
        return this.usersRepo.findFirstByCbuCode(cbuCode).doOnNext(u -> u.setPassword(null));
    }

    public Mono<Users> getByUsername(String username) {
        return this.usersRepo.findUsersByUsername(username);
    }

    public Flux<Users> getAllUsers() {
        return usersRepo
                .findAll()
                .doOnNext(u -> u.setPassword(null))
                .onErrorMap(e -> ErrorWrapper.databaseErrorWrapper(e,
                        "getAllUsers()"));
    }

    public Flux<Users> saveAllUsers(List<Users> users) {
        return usersRepo.saveAll(users)
                .onErrorMap(e -> ErrorWrapper.databaseErrorWrapper(e,
                        "saveAllUsers()"));
    }

    public Mono<Users> getUserByUsername(String username) {
        return usersRepo
                .findFirstByUsername(username)
                .onErrorMap(e -> ErrorWrapper.databaseErrorWrapper(e,
                        "getUserByUsername()"));
    }

    public Mono<Users> createUser(Users users) {
        return usersRepo
                .save(users)
                .onErrorMap(e -> ErrorWrapper.databaseErrorWrapper(e,
                        "createUser()"));
    }

    public Mono<Users> blockUser(Users input, Long id) {
        return usersRepo
                .findById(id)
                .filter(f -> f.getUsername().equals(input.getUsername()) && f.getIs_enabled() && f.getBranch_code().equals(input.getBranch_code()))
                .switchIfEmpty(Mono.error(new BadRequestException("The data is not proper for blocking!")))
                .doOnNext(u -> u.setIs_enabled(false))
                .flatMap(usersRepo::save)
                .doOnNext(u -> u.setPassword(null));
    }

    public Mono<Users> unblockUser(Users input, Long id) {
        return usersRepo
                .findById(id)
                .filter(f -> f.getUsername().equals(input.getUsername()) && !f.getIs_enabled() && f.getBranch_code().equals(input.getBranch_code()))
                .switchIfEmpty(Mono.error(new BadRequestException("The data is not proper for unblocking!")))
                .doOnNext(u -> u.setIs_enabled(true))
                .flatMap(usersRepo::save)
                .doOnNext(u -> u.setPassword(null));
    }

    public Mono<Users> updateUser(Users input, Long id) {
        return usersRepo
                .findById(id)
                .filter(f -> f.getUsername().equals(input.getUsername()) && f.getBranch_code().equals(input.getBranch_code()))
                .switchIfEmpty(Mono.error(new BadRequestException("The data is not proper for update!")))
                .doOnNext(u -> {
                    if (!Strings.isNullOrEmpty(input.getDescription()))
                        u.setDescription(input.getDescription());
                    if (input.getIs_enabled() != null)
                        u.setIs_enabled(input.getIs_enabled());
                    if (input.getName() != null)
                        u.setName(input.getName());
                    if (input.getPost_code() != null)
                        u.setPost_code(input.getPost_code());
                    if (input.getRegion_code() != 0)
                        u.setRegion_code(input.getRegion_code());
                    if (!Strings.isNullOrEmpty(input.getRegion_name()))
                        u.setRegion_name(input.getRegion_name());
                    if (input.getDistrict_code() != 0)
                        u.setDistrict_code(input.getDistrict_code());
                    if (!Strings.isNullOrEmpty(input.getDistrict_name()))
                        u.setDistrict_name(input.getDistrict_name());
                    if (input.getLocality() != null)
                        u.setLocality(input.getLocality());
                    if (input.getStreet() != null)
                        u.setStreet(input.getStreet());
                    if (input.getHouse() != null)
                        u.setHouse(input.getHouse());
                    if (input.getBuilding() != null)
                        u.setBuilding(input.getBuilding());
                })
                .flatMap(usersRepo::save)
                .doOnNext(u -> u.setPassword(null));
    }


}
