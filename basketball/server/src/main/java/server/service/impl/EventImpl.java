package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.dto.event.AddEventDTO;
import com.basketball.dto.event.UpdateEventDTO;
import com.basketball.dto.event.UpdateEventTeamDTO;
import com.basketball.entity.Event;
import com.basketball.entity.TeamInEvent;
import com.basketball.result.Result;
import com.basketball.vo.event.SelectEventListVO;
import com.basketball.vo.event.SelectEventVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import server.mapper.EventMapper;
import server.service.EventService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventImpl implements EventService {

    private final EventMapper eventMapper;
    @Override
    public String addEvent(AddEventDTO addEventDTO) {
        Event event = new Event();
        BeanUtils.copyProperties(addEventDTO, event);
        event.setId(IdWorker.getId());
        event.setStatusId(1L); // 默认状态为未开始
        eventMapper.addEvent(event);
        Long eventId = event.getId();
        for (Long teamId : addEventDTO.getTeamIdList()) {
            TeamInEvent teamInEvent = new TeamInEvent();
            teamInEvent.setId(IdWorker.getId());
            teamInEvent.setEventId(eventId);
            teamInEvent.setTeamId(teamId);
            eventMapper.addTeamInEvent(teamInEvent);
        }
        return String.valueOf(eventId);
    }

    @Override
    public List<SelectEventListVO> selectEventList() {
        return eventMapper.selectEventList();
    }

    @Override
    public SelectEventVO selectEventDetails(Long id) {
        return eventMapper.selectEventDetails(id);
    }

    @Override
    public Result<String> updateEvent(UpdateEventDTO updateEventDTO) {
        if (eventMapper.updateEvent(updateEventDTO)==1){
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    @Override
    public Result<String> updateEventTeam(UpdateEventTeamDTO updateEventTeamDTO) {
        Event event = eventMapper.selectById(updateEventTeamDTO.getId());
        if (event == null) {
            throw new IllegalArgumentException("赛事不存在");
        }
        eventMapper.deleteByEventId(updateEventTeamDTO.getId());
        for (Long teamId : updateEventTeamDTO.getTeamIdList()) {
            TeamInEvent teamInEvent = new TeamInEvent();
            teamInEvent.setId(IdWorker.getId());
            teamInEvent.setEventId(updateEventTeamDTO.getId());
            teamInEvent.setTeamId(teamId);
            eventMapper.addTeamInEvent(teamInEvent);
        }
        return Result.success("修改成功");
    }

    @Override
    public Result deleteEvent(Long id) {
        Result result = new Result<>();
        if (eventMapper.selectEventById(id)) {
            eventMapper.deleteEventById(id);
            result.setMsg("删除成功");
            return result;
        }
        return result;
    }
}
