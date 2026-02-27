package server.service;

import com.basketball.dto.event.AddEventDTO;
import com.basketball.dto.event.UpdateEventDTO;
import com.basketball.dto.event.UpdateEventTeamDTO;
import com.basketball.result.Result;
import com.basketball.vo.event.SelectEventListVO;
import com.basketball.vo.event.SelectEventVO;

import java.util.List;

public interface EventService {
    String addEvent(AddEventDTO addEventDTO);

    List<SelectEventListVO> selectEventList();

    SelectEventVO selectEventDetails(Long id);

    Result<String> updateEvent(UpdateEventDTO updateEventDTO);

    Object updateEventTeam(UpdateEventTeamDTO updateEventTeamDTO);
}
