package server.mapper;

import com.basketball.dto.score.SelectOneEventScoreDTO;
import com.basketball.vo.score.SelectEventScoreVO;
import com.basketball.vo.score.SelectOneEventScoreVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {
    List<SelectEventScoreVO> selectEventScore(List<Long> matches);

    List<SelectOneEventScoreVO> selectOneEventScore(SelectOneEventScoreDTO selectOneEventScoreDTO);
}
