package server.service;

import com.basketball.stadium.AddStadiumDTO;
import org.springframework.stereotype.Service;


public interface StadiumService {
    void addStadium(AddStadiumDTO addStadiumDTO);
}
