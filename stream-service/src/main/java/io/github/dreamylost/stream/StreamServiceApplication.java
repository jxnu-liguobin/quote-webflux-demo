package io.github.dreamylost.stream;

import io.github.dreamylost.stream.user.User;
import io.github.dreamylost.stream.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * @author 梦境迷离
 * @version 1.0
 * @since 2020/11/23
 */
@SpringBootApplication
public class StreamServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamServiceApplication.class, args);
    }

    /**
     * 创建用户并保存
     *
     * @param userRepository
     * @return
     */
    @Bean
    public CommandLineRunner createUsers(UserRepository userRepository) {
        return strings -> {
            List<User> users = Arrays.asList(
                    new User("sdeleuze", "Sebastien Deleuze"),
                    new User("snicoll", "Stephane Nicoll"),
                    new User("rstoyanchev", "Rossen Stoyanchev"),
                    new User("smaldini", "Stephane Maldini"),
                    new User("simonbasle", "Simon Basle"),
                    new User("bclozel", "Brian Clozel")
            );
            userRepository.saveAll(users).blockLast(Duration.ofSeconds(3));
        };
    }

}
