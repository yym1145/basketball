package server.mapper;

import com.basketball.dto.photo.SelectMatchPhotoListDTO;
import com.basketball.entity.MatchPhoto;
import com.basketball.vo.photo.SelectAllMatchPhotoVO;
import com.basketball.vo.photo.SelectMatchPhotoVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MatchPhotoMapper {

    @Insert("insert into matchphoto(id, match_id, file_id, description) VALUES (#{id}, #{matchId}, #{fileId}, #{description})")
    void uploadPhoto(MatchPhoto matchPhoto);

    Page<SelectAllMatchPhotoVO> selectAllMatchPhoto(SelectMatchPhotoListDTO selectMatchPhotoListDTO);

    SelectMatchPhotoVO selectMatchPhoto(Long id);
}
