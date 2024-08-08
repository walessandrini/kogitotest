package com.cisco.model.subscriber;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    private LocalDate timeToLive;
    private LocalDate futureTimeToLive;

}
