package io.arrogantprogrammer;

public record DaprMessage(String pubSubName, String topicName, String body) {

}
