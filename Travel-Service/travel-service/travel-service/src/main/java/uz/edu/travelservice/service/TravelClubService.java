package uz.edu.travelservice.service;

import uz.edu.travelservice.exception.TravelClubNotFoundException;
import uz.edu.travelservice.model.TravelClub;

import java.util.List;
import java.util.Optional;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 11/10/22
 * Email: hamdamboy.urunov@gmail.com
 */

public interface TravelClubService {

    TravelClub registrationClub(TravelClub club);

    Optional<TravelClub> findById(Long id) throws TravelClubNotFoundException;

    List<TravelClub> findClubByName(String name);

    List<TravelClub> findAll();

    void modify(Long clubId, TravelClub travelClub) throws TravelClubNotFoundException;

    void remove(Long clubId) throws TravelClubNotFoundException;
}
