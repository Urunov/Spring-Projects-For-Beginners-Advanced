package uz.edu.travelservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uz.edu.travelservice.repository.TravelClubRepository;
import uz.edu.travelservice.service.TravelClubServiceImpl;

@SpringBootTest
class TravelServiceApplicationTests {

    @Autowired
    private TravelClubServiceImpl travelClubService;

    @MockBean
    private TravelClubRepository travelClubRepository;

    @Test
    void contextLoads() {

    }



}


/**
 * Each class Service and Controller
 * click right click on mouse and Go to and chooose Test case
 * create each method for test.
 * */