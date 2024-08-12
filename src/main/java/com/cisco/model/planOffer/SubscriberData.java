package com.cisco.model.planOffer;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberData {

    private Long id;
    private Integer dataUsageMb;
    private Integer dataRemainingMB;
    private Integer planId;
    private LocalDate planRenewalDate;//Date when the plan was renewed
}
