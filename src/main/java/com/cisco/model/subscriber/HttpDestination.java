package com.cisco.model.subscriber;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpDestination extends Destination{
    private String target;
    private Map<String,String> metadata;
}
