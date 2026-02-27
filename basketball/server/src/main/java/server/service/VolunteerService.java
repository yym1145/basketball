package server.service;

import com.basketball.dto.volunteer.VolunteerDTO;

public interface VolunteerService {
    void addVolunteer(VolunteerDTO volunteerDTO);

    void deleteVolunteer(Long id);
}
