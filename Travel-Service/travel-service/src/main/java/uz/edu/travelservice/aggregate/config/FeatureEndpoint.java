package uz.edu.travelservice.aggregate.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 12/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Component
@Endpoint(id = "features")
public class FeatureEndpoint {
    //
    private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

    public FeatureEndpoint(){
        featureMap.put("TravelClub", new Feature( true));
        featureMap.put("Member", new Feature( true));
        featureMap.put("Membership", new Feature( false));
    }

    @ReadOperation
    public Map<String, Feature> features(){
        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName){
        return featureMap.get(featureName);
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature{
        private boolean isEnabled;
    }
}
