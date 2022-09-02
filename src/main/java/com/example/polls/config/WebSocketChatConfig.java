package com.example.polls.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketChatConfig implements WebSocketMessageBrokerConfigurer {
	
	private String relayHost = "127.0.0.1";

    private int relayPort = 61613;
    		//15672;

    private String clientLogin = "guest";

    private String clientPasscode = "guest";

    private String systemLogin = "guest";

    private String systemPasscode = "guest";

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websocketApp").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableStompBrokerRelay("/topic").setRelayHost(relayHost).setRelayPort(relayPort).setClientLogin(clientLogin)
				.setClientPasscode(clientPasscode);

	}
}