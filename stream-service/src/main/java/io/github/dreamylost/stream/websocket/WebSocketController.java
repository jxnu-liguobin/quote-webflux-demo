package io.github.dreamylost.stream.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 梦境迷离
 * @version 1.0
 * @since 2020/11/30
 */
@Controller
public class WebSocketController {

    @GetMapping("/websocket")
    public String websocket() {
        return "websocket";
    }
}