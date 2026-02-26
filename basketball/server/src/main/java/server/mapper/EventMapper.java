package server.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EventMapper {
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
