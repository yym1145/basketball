package server.mapper;

import com.basketball.entity.Volunteer;
import com.basketball.vo.volunteer.VolunteerVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VolunteerMapper {

    @Insert("insert into volunteer (id, first_name, last_name, gender, date_of_birth, telephone, email, occupation, event_id) " +
            "values (#{id}, #{firstName}, #{lastName}, #{gender}, #{dateOfBirth}, #{telephone}, #{email}, #{occupation}, #{eventId})")
    void insert(Volunteer volunteer);

    @Delete("delete from volunteer where id = #{id}")
    void deleteById(Long id);

    void updateVolunteer(Volunteer volunteer);

    Page<VolunteerVO> selectVolunteer(Volunteer volunteer);

    @Select("select * from volunteer where id = #{id}")
    VolunteerVO selectDetailVolunteer(Long id);
}
