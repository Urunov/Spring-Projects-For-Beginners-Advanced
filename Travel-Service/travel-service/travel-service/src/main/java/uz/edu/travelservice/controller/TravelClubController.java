package uz.edu.travelservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.edu.travelservice.model.TravelClub;
import uz.edu.travelservice.service.TravelClubService;
import uz.edu.travelservice.service.TravelClubServiceImpl;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 12/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@RestController
@RequestMapping("/api/v1")
public class TravelClubController {
    //
    @Autowired
    private TravelClubServiceImpl travelClubService;

    @PostMapping("/store/club")
    public TravelClub getTravelClub(TravelClub travelClub){
       return travelClubService.registrationClub(travelClub);
    }
}
