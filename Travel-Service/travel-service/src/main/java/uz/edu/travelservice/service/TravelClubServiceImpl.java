package uz.edu.travelservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.travelservice.model.TravelClub;
import uz.edu.travelservice.repository.TravelClubRepository;

import java.util.logging.Logger;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 11/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Service
public class TravelClubServiceImpl implements TravelClubService {

    @Autowired
    private TravelClubRepository travelClubRepository;

    @Override
    public String registrationClub(TravelClub club) {

       TravelClub saveClub = travelClubRepository.save(club);
        /**
         * 1. LOG
         * 2. Exception
         * 3. Logic (save)
         * */
        return saveClub.getId();
    }

    @Override
    public TravelClub findById(String id) {
        /**
         * 1. LOG
         * 2. Exception
         * 3. Logic (save)
         * */
        return null;
    }
}
