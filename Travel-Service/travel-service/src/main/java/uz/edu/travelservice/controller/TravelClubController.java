package uz.edu.travelservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.edu.travelservice.exception.TravelClubNotFoundException;
import uz.edu.travelservice.model.TravelClub;
import uz.edu.travelservice.service.TravelClubServiceImpl;

import java.util.List;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 12/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@RestController
@RequestMapping("/api/v1/club")
public class TravelClubController {
    //
    @Autowired
    private TravelClubServiceImpl travelClubService;
    private final Logger LOG = LoggerFactory.getLogger(TravelClubController.class);

    @PostMapping("/store/club")
    public TravelClub getTravelClub(@RequestBody TravelClub travelClub) {
        return travelClubService.registrationClub(travelClub);
    }

    @GetMapping("/all/club")
    public List<TravelClub> clubList() {
        return travelClubService.findAll();
    }

    @GetMapping("/{id}")
    public TravelClub clubById(Long id) {
        return travelClubService.findById(id).get();
    }

    @DeleteMapping("/club/{id}")
    public String deleteTravelById(@PathVariable("id") Long clubId) throws TravelClubNotFoundException {
        travelClubService.remove(clubId);
        // LOG.info("Inside the delete Student of Controller : ");
        LOG.warn("Inside the delte of Club: {}", clubId);
        return "Deleted . Successfully..";
    }

    @PutMapping("/update/club/{id}")
    public void updateTravelValue(@PathVariable Long id, @RequestBody TravelClub club) throws TravelClubNotFoundException {
        LOG.info("Inside the updated Club of Controller : ");
        travelClubService.modify(id, club);
    }

}
