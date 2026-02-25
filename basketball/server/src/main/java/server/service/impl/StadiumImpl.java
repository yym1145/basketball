package server.service.impl;

import com.basketball.entity.Stadium;
import com.basketball.stadium.AddStadiumDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import server.mapper.StadiumMapper;
import server.service.StadiumService;
import server.service.UserService;
@RequiredArgsConstructor
@Service
public class StadiumImpl implements StadiumService {
    private final StadiumMapper  stadiumMapper;
    @Override
    public void addStadium(AddStadiumDTO addStadiumDTO) {
        Stadium stadium = new Stadium();
        stadium.setId(addStadiumDTO.getStadiumId());
        stadium.setAddress(addStadiumDTO.getAddress());
        stadium.setStadiumName(addStadiumDTO.getStadiumName());
        BeanUtils.copyProperties(addStadiumDTO,stadium);
        stadiumMapper.AddStadium(stadium);

    }
}
