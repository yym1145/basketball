package server.mapper;

import com.basketball.entity.Stadium;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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
}
