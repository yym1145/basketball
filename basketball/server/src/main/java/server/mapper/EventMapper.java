package server.mapper;

import com.basketball.dto.event.UpdateEventDTO;
import com.basketball.dto.event.UpdateEventTeamDTO;
import com.basketball.entity.Event;
import com.basketball.entity.TeamInEvent;
import com.basketball.vo.event.SelectEventListVO;
import com.basketball.vo.event.SelectEventVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface EventMapper {

    @Insert("insert into event(id, name, start_date, end_date, event_type_id, status_id, remark) " +
            "values(#{id}, #{name}, #{startDate}, #{endDate}, #{eventTypeId}, #{statusId}, #{remark})")
        void addEvent(Event event);

    @Insert("insert into teaminevent(id, event_id, team_id) " +
            "values(#{id}, #{eventId}, #{teamId})")
    void addTeamInEvent(TeamInEvent teamInEvent);

    List<SelectEventListVO> selectEventList();

    SelectEventVO selectEventDetails(Long id);

    int updateEvent(UpdateEventDTO updateEventDTO);

    @Select("select * from event where id = #{id}")
    Event selectById(Long id);

    @Delete("DELETE FROM teaminevent WHERE event_id = #{id} ")
    void deleteByEventId(Long id);

    /**
     * 查询需要删除的赛事id是否存在
     * @param id
     * @return
     */
    @Select("select event.id from event where id=#{id}")
    boolean selectEventById(Long id);

    /**
     * 删除赛事
     * @param id
     */
    @Delete("delete from event where id=#{id}")
    void deleteEventById(Long id);
}
