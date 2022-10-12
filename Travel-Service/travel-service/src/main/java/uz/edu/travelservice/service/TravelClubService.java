package uz.edu.travelservice.service;

import uz.edu.travelservice.model.TravelClub;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 11/10/22
 * Email: hamdamboy.urunov@gmail.com
 */

public interface TravelClubService {

    String registrationClub(TravelClub club);
    TravelClub findById(String id);
}
