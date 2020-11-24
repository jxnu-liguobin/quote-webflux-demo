package io.github.dreamylost.stream.portfolio;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;

/**
 * @author 梦境迷离
 * @version 1.0
 * @since 2020/11/23
 */
@Controller
public class HomeController {

    private final UserRepository userRepository;

    private final Flux<Quote> quoteStream;

    /**
     * 请求quotes存为流
     */
    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.quoteStream = WebClient.create("http://localhost:8081")
                .get()
                .uri("/quotes")
                .accept(APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(Quote.class)
                .share()
                .log();
    }

    /**
     * 返回quotes流
     */
    @GetMapping(path = "/quotes/feed", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Quote> fetchQuotesStream() {
        return this.quoteStream;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", this.userRepository.findAll());
        return "index";
    }

    @GetMapping("/quotes")
    public String quotes() {
        return "quotes";
    }
}
