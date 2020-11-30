package io.github.dreamylost.stream.websocket;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author 梦境迷离
 * @version 1.0
 * @since 2020/11/30
 */
public class EchoWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(session.receive().doOnNext(WebSocketMessage::retain).delayElements(Duration.ofSeconds(1)).log());
    }
}