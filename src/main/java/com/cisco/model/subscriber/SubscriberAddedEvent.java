package com.cisco.model.subscriber;

import java.time.Instant;
import lombok.Data;

@Data
public class SubscriberAddedEvent {
    private Instant createdOn;
    private Subscriber newSubscriber;
}
