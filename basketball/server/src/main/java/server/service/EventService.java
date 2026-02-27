package server.service;

import com.basketball.dto.event.AddEventDTO;
import com.basketball.dto.event.UpdateEventDTO;
import com.basketball.dto.event.UpdateEventTeamDTO;
import com.basketball.result.Result;
import com.basketball.vo.event.SelectEventListVO;
import com.basketball.vo.event.SelectEventVO;
import org.springframework.data.redis.core.script.ReactiveScriptExecutor;

import java.util.List;

public interface EventService {
    /**
     * 添加赛事
     * @param addEventDTO
     * @return
     */
    String addEvent(AddEventDTO addEventDTO);

    /**
     * 查询赛事列表
     * @return
     */
    List<SelectEventListVO> selectEventList();

    /**
     * 查询赛事详情
     * @param id
     * @return
     */
    SelectEventVO selectEventDetails(Long id);

    /**
     * 修改赛事
     * @param updateEventDTO
     * @return
     */
    Result<String> updateEvent(UpdateEventDTO updateEventDTO);

     /**
     * 修改赛事队伍
     * @param updateEventTeamDTO
     * @return
     */
    Result<String> updateEventTeam(UpdateEventTeamDTO updateEventTeamDTO);

    /**
     * 删除赛事
     * @param id
     */
    Result deleteEvent(Long id);
}
