package server.mapper;

import com.basketball.dto.team.SelectTeamsDTO;
import com.basketball.vo.team.SelectTeamsVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMapper {

    Page<SelectTeamsVO> selectteams(SelectTeamsDTO selectTeamsDTO);
}
