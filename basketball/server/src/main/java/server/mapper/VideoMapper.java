package server.mapper;

import com.basketball.dto.video.SelectAllVideoDTO;
import com.basketball.entity.Video;
import com.basketball.vo.video.GetVideoDetailsVO;
import com.basketball.vo.video.SelectAllVideoVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoMapper {

    @Insert("insert into video(id, introduce, view_count, particulars, publisher, publish_date, video_file_id) " +
            "VALUES (#{id}, #{introduce}, #{viewCount}, #{particulars}, #{publisher}, #{publishDate}, #{videoFileId})")
    void insertVideo(Video video);

    Page<SelectAllVideoVO>selectAllVideo(SelectAllVideoDTO dto);

    @Select("select * from video where id=#{id}")
    Video getByIdVideo(String id);

    GetVideoDetailsVO getVideoDetails(String id);
}
