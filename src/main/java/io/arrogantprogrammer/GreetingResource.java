package io.arrogantprogrammer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

    @Inject
    DaprService daprService;

    String greeting = "Hello RESTEasy";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        daprService.sendMessage(new DaprMessage("pubsub", "greetings", greeting));
        return greeting;
    }
}