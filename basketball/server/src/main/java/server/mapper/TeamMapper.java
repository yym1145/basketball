package server.mapper;

import com.basketball.dto.team.SelectTeamsDTO;
import com.basketball.dto.team.UpdateTeamDTO;
import com.basketball.entity.Team;
import com.basketball.vo.player.PlayerVO;
import com.basketball.vo.team.SelectTeamDetailVO;
import com.basketball.vo.team.SelectTeamsVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeamMapper {

    /**
     * 查询所有球队
     */
    Page<SelectTeamsVO> selectteams(SelectTeamsDTO selectTeamsDTO);

    /**
     * 查询球队基本信息
     */
    SelectTeamDetailVO selectTeamById(Long teamId);

    /**
     * 查询球队球员列表
     */
    List<PlayerVO> selectPlayersByTeamId( Long teamId, String playerName);

    /**
     * 根据名称查询球队（校验重复）
     */
    Team selectByName(String name);

    @Select("SELECT " +
            "id, name, contact_phone AS contactPhone, address, logo, established_date AS establishedDate " +
            "FROM team WHERE id = #{id}")
    Team selectById(Long id);
    /**
     * 插入球队
     */
    @Insert("INSERT INTO team (id,name, contact_phone, address, logo, established_date) VALUES (#{id},#{name},#{contactPhone},#{address},#{logo},#{establishedDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addTeam(Team team);

    /**
     *修改球队
     */
    int updateTeam(UpdateTeamDTO updateTeamDTO);
    /**
     * 删除球队
     */
    @Delete("DELETE FROM team WHERE id = #{id}")
    int deleteById(Long id);
}
