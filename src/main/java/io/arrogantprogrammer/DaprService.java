package io.arrogantprogrammer;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

@ApplicationScoped
public class DaprService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DaprService.class);

    static final DaprClient daprClient = (new DaprClientBuilder()).build();

    public void sendMessage(final DaprMessage daprMessage){

        daprClient.publishEvent(daprMessage.pubSubName(), daprMessage.topicName(), daprMessage.body()).block();
        LOGGER.info("sent: {}");
    }

    
}