package server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.basketball.entity.Stadium;
import com.basketball.stadium.StadiumPageQueryDTO;
import com.basketball.vo.Stadium.PageStadiumVO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StadiumMapper {
    /**
     * 新增场馆
     *
     * @param stadium
     */
    @Insert("INSERT INTO stadium(id,name,address)" +
            " VALUES (#{id},#{stadiumName},#{address})")
    //插入后返回主键ID
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void AddStadium(Stadium stadium);

    /**
     * 查询需要删除的场馆是否存在
     * @param id
     * @return
     */
    @Select("select stadium.id from stadium where id=#{id}")
    boolean selectStadiumById(Long id);

    /**
     * 删除场馆
     * @param id
     */
    @Delete("delete from stadium where id=#{id}")
    void deleteStadiumById(Long id);

    /**
     * 修改场馆
     * @param stadium
     */
    void updateStadium(Stadium stadium);
    /**
     * 查询场馆
     * @param stadiumPageQueryDTO
     * @return
     */
    Page<PageStadiumVO> pageStadium(StadiumPageQueryDTO stadiumPageQueryDTO);


}
