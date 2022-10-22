package uz.edu.travelservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.travelservice.exception.TravelClubNotFoundException;
import uz.edu.travelservice.model.TravelClub;
import uz.edu.travelservice.repository.TravelClubRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    private final Logger LOG = LoggerFactory.getLogger(TravelClubServiceImpl.class);

    @Override
    public TravelClub registrationClub(TravelClub club) {
        LOG.info("REQUEST registration club : {} ", club);
        return travelClubRepository.save(club);
    }

    @Override
    public Optional<TravelClub> findById(Long id){
        try {
            Optional<TravelClub> club = travelClubRepository.findById(id);
            if (club.isEmpty()) {
                throw new TravelClubNotFoundException("Agency is not exist this:  " + id);
            }
        }catch (Exception e){
            System.out.println("Agency is not exist this:  ");
        }
        return travelClubRepository.findById(id);
    }

    @Override
    public List<TravelClub> findClubByName(String name) {

        try {
            TravelClub travelClub = travelClubRepository.findByClubName(name);
            if (travelClub.getClubName().equals("") || travelClub.getClubName() == null) {
                throw new TravelClubNotFoundException("Cloud not find the same " + name);
            }
           // return (List<TravelClub>) travelClubRepository.findByClubName(name);
        } catch (Exception e){
            System.out.println(e);
        }
        LOG.info("REQUEST find By Name: ");
        return (List<TravelClub>) travelClubRepository.findByClubName(name);

    }

    @Override
    public List<TravelClub> findAll() {

        return travelClubRepository.findAll();
    }

    @Override
    public void modify(Long clubId, TravelClub club) throws TravelClubNotFoundException {
        TravelClub clubDB = travelClubRepository.findById(clubId).get();

        if (Objects.nonNull(club.getClubName()) &&
                !"".equalsIgnoreCase(club.getIntroduction())) {
            clubDB.setClubName(club.getClubName());
        } else{
            throw new TravelClubNotFoundException("Please, find correct club information.");
        }
        if (Objects.nonNull(club.getIntroduction()) &&
                !"".equalsIgnoreCase(club.getIntroduction())) {
            clubDB.setIntroduction(club.getIntroduction());
        }
        travelClubRepository.save(clubDB);
    }
    @Override
    public void remove(Long clubId) throws TravelClubNotFoundException {
        if (clubId ==0) {
            throw new TravelClubNotFoundException("In database not included this id: " + clubId);
        }
        travelClubRepository.deleteById(clubId);
    }
}
