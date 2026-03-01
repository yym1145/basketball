package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.volunteer.SelectVolunteerDTO;
import com.basketball.dto.volunteer.UpdateVolunteerDTO;
import com.basketball.dto.volunteer.VolunteerDTO;
import com.basketball.entity.Volunteer;
import com.basketball.result.PageResult;
import com.basketball.vo.volunteer.VolunteerVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import server.mapper.VolunteerMapper;
import server.service.VolunteerService;

import java.util.List;

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
        volunteer.setId(IdWorker.getId());
        volunteerMapper.insert(volunteer);
    }

    @Override
    public void deleteVolunteer(Long id) {
        volunteerMapper.deleteById(id);
    }

    @Override
    public void updateVolunteer(UpdateVolunteerDTO updateVolunteerDTO) {
        Volunteer volunteer=new Volunteer();
        String fullName = updateVolunteerDTO.getName();
        String lastName = fullName.substring(0, 1);
        String firstName = fullName.substring(1);
        org.springframework.beans.BeanUtils.copyProperties(updateVolunteerDTO, volunteer);
        volunteer.setLastName(lastName);
        volunteer.setFirstName(firstName);
        volunteerMapper.updateVolunteer(volunteer);
    }

    @Override
    public PageResult<VolunteerVO> selectVolunteer(SelectVolunteerDTO selectVolunteerDTO) {
        PageHelper.startPage(selectVolunteerDTO.getPage(), selectVolunteerDTO.getPageSize());
        Volunteer volunteer = new Volunteer();
        String fullName = selectVolunteerDTO.getName();
        if (StringUtils.hasText(fullName)) {
            String lastName = fullName.substring(0, 1);
            volunteer.setLastName(lastName);
            if (fullName.length() > 1) {
                String firstName = fullName.substring(1);
                volunteer.setFirstName(firstName);
            } else {
                volunteer.setFirstName(null);
            }
        }
        volunteer.setEventId(selectVolunteerDTO.getEventId());
        Page<VolunteerVO> page = volunteerMapper.selectVolunteer(volunteer);
        long total = page.getTotal();
        List<VolunteerVO> volunteerList = page.getResult();
        return new PageResult<>(total, volunteerList);
    }

    @Override
    public VolunteerVO selectDetailVolunteer(Long id) {
        return volunteerMapper.selectDetailVolunteer(id);
    }


}
