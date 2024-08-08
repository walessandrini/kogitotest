package com.cisco.model.subscriber;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDestination extends Destination{
    private Map<String,String>  tags;
}
