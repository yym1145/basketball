package server.service.impl;

import com.basketball.result.Result;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import server.mapper.EventMapper;
import server.service.EventService;
@RequiredArgsConstructor
@Service
public class EventImpl implements EventService {
    private final EventMapper eventMapper;
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
