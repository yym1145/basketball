package server.service.impl;

import com.basketball.dto.volunteer.VolunteerDTO;
import com.basketball.entity.Volunteer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.mapper.VolunteerMapper;
import server.service.VolunteerService;

@RequiredArgsConstructor
@Service
public class VolunteerImpl implements VolunteerService {

    private final VolunteerMapper volunteerMapper;

    @Override
    public void addVolunteer(VolunteerDTO volunteerDTO) {
        Volunteer volunteer=new Volunteer();
        String fullName = volunteerDTO.getName();
        String lastName = fullName.substring(0, 1);
        String firstName = fullName.substring(1);
        org.springframework.beans.BeanUtils.copyProperties(volunteerDTO, volunteer);
        volunteer.setLastName(lastName);
        volunteer.setFirstName(firstName);
        volunteerMapper.insert(volunteer);
    }

    @Override
    public void deleteVolunteer(Long id) {
        volunteerMapper.deleteById(id);
    }
}
