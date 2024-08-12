package com.cisco.service.subscriber3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cisco.model.subscriber.Destination;
import com.cisco.model.subscriber.HttpDestination;
import com.cisco.model.subscriber.LogDestination;

@Service
public class SubscriberService {
    public List<Destination> createDestinations() {
        List<Destination> destinations = new ArrayList<>();
        Map<String,String> metadata = new HashMap<>();
        metadata.put("tfbisevent", "SubscriberUpdate");
        Destination httpDestination= new HttpDestination("direQT",metadata);
        destinations.add(httpDestination);

        Map<String,String> tags = new HashMap<>();
        tags.put("tfbisevent", "SubscriberUpdate");
        Destination logDestination= new LogDestination(tags);
        destinations.add(logDestination);
        return destinations;
    }
}
