package server.service;

import com.basketball.dto.volunteer.SelectVolunteerDTO;
import com.basketball.dto.volunteer.UpdateVolunteerDTO;
import com.basketball.dto.volunteer.VolunteerDTO;
import com.basketball.result.PageResult;
import com.basketball.vo.volunteer.VolunteerVO;

public interface VolunteerService {
    void addVolunteer(VolunteerDTO volunteerDTO);

    void deleteVolunteer(Long id);

    void updateVolunteer(UpdateVolunteerDTO updateVolunteerDTO);

    PageResult<VolunteerVO> selectVolunteer(SelectVolunteerDTO selectVolunteerDTO);

    VolunteerVO selectDetailVolunteer(Long id);
}
