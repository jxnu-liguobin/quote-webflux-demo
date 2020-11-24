package io.github.dreamylost.stream.portfolio;

import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author 梦境迷离
 * @version 1.0
 * @since 2020/11/23
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findUserByGithub(String github);
}
