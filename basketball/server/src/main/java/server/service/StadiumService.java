package server.service;

import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.stadium.AddStadiumDTO;
import com.basketball.stadium.StadiumPageQueryDTO;
import com.basketball.stadium.UpdateStadiumDTO;
import com.basketball.vo.Stadium.PageStadiumVO;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;


public interface StadiumService {
    /**
     * 新增场馆
     * @param addStadiumDTO
     */
    void addStadium(AddStadiumDTO addStadiumDTO);

    /**
     *删除场馆
     * @param id
     */
    Result deleteStadium(Long id);

    /**
     * 修改场馆
     * @param updateStadiumDTO
     */
    void updateStadium(UpdateStadiumDTO updateStadiumDTO);

    /**
     *分页查询
     * @param stadiumPageQueryDTO
     * @return
     */
    PageResult<PageStadiumVO> pageStadium(StadiumPageQueryDTO stadiumPageQueryDTO);
}
