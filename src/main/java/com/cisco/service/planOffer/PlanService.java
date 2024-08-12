package com.cisco.service.planOffer;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cisco.model.planOffer.Plan;
import com.cisco.model.planOffer.SubscriberData;

@Service
public class PlanService {
    private static List<Plan> plans = List.of(new Plan(1, 3072), new Plan(2, 5120), new Plan(3, 10240), new Plan(4, 20480));
    
    public List<Plan> getPlans(){
        return plans;
    }

    public Plan getPlan(Integer id){
        return plans.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public Integer getPlanId(SubscriberData subscriber){
        return subscriber.getPlanId();
    }

    //Best plan to last till the  end of the month
    public Plan getBestPlanToOffer(Plan currentPlan, SubscriberData subscriberData){
        Plan planToOffer = null;
        Integer elapsedDays = Period.between(subscriberData.getPlanRenewalDate(),  LocalDate.now()).getDays();//Days from last plan renewal
        if (elapsedDays == 0){
            planToOffer= this.getPlans().stream().max(Comparator.comparing(Plan::getDataMb)).orElse(null);
        }
        else{
            Integer mbRemaining = currentPlan.getDataMb() - subscriberData.getDataUsageMb();
            Integer remainingDays = 30 - elapsedDays;
            Integer minimumMbToOffer = ((remainingDays * subscriberData.getDataUsageMb()) / elapsedDays) - mbRemaining;
            Optional<Plan> planToOfferOpt=this.getPlans().stream().filter(p-> p.getDataMb() >= minimumMbToOffer).findFirst();
            if(planToOfferOpt.isEmpty()){
                planToOffer = this.getPlans().stream().max(Comparator.comparing(Plan::getDataMb)).orElse(null);
            }
            else{
                planToOffer = planToOfferOpt.orElse(null);
            }
        }
        return planToOffer;
    }

}
