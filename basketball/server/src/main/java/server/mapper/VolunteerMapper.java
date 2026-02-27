package server.mapper;

import com.basketball.entity.Volunteer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VolunteerMapper {

    @Insert("insert into volunteer (first_name, last_name, gender, date_of_birth, telephone, email, occupation, event_id) " +
            "values (#{firstName}, #{lastName}, #{gender}, #{dateOfBirth}, #{telephone}, #{email}, #{occupation}, #{eventId})")
    void insert(Volunteer volunteer);

    @Delete("delete from volunteer where id = #{id}")
    void deleteById(Long id);
}
