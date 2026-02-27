package server.mapper;

import com.basketball.entity.Player;
import com.basketball.entity.Position;
import com.basketball.entity.Team;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PlayerMapper {
    /**
     * 根据球队id查询球队信息
     * @param teamId 球队id
     * @return 球队信息
     */
    @Select("select * from team where id = #{teamId}")
    Team selectTeamById(String teamId);

    /**
     * 根据球员职位id查询球员职位信息
     * @param positionId 球员职位id
     * @return 球员职位信息
     */
    @Select("select * from position where id = #{positionId}")
    Position selectPositionById(Integer positionId);

     /**
     * 新增球员
     * @param player 球员信息
     * @return 球员id
     */
     @Insert("insert into player(id, first_name, last_name, gender, date_of_birth, weight, height, shirt_number," +
             " position_id, team_id, photo) VALUES (#{id}, #{firstName}, #{lastName}, #{gender}, #{dateOfBirth}, " +
             "#{weight}, #{height}, #{shirtNumber}, #{positionId}, #{teamId}, #{photo})")
    void insertPlayer(Player player);

     /**
     * 根据球员id查询球员信息
     * @param id 球员id
     * @return 球员信息
     */
     @Select("select * from player where id = #{id}")
    Player selectPlayer(String id);

     /**
     * 删除球员
     * @param id 球员id
     */
     @Delete("delete from player where id = #{id}")
    void deletePlayer(String id);

     /**
     * 更新球员信息
     * @param player 球员信息
     */
    void updatePlayer(Player player);
}
