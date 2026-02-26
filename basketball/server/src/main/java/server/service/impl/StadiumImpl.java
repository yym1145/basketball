package server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.basketball.entity.Stadium;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.stadium.AddStadiumDTO;
import com.basketball.stadium.StadiumPageQueryDTO;
import com.basketball.stadium.UpdateStadiumDTO;
import com.basketball.vo.Stadium.PageStadiumVO;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import server.mapper.StadiumMapper;
import server.service.StadiumService;
import server.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StadiumImpl implements StadiumService {
    private final StadiumMapper  stadiumMapper;

    /**
     * 新增场馆
     * @param addStadiumDTO
     */
    @Override
    public void addStadium(AddStadiumDTO addStadiumDTO) {
        Stadium stadium = new Stadium();
        stadium.setId(addStadiumDTO.getStadiumId());
        stadium.setAddress(addStadiumDTO.getAddress());
        stadium.setName(addStadiumDTO.getStadiumName());
        BeanUtils.copyProperties(addStadiumDTO,stadium);
        stadiumMapper.AddStadium(stadium);
    }

    /**
     * 删除场馆
     * @param id
     */
    @Override
    public Result deleteStadium(Long id) {
        Result result = new Result<>();
        if (stadiumMapper.selectStadiumById(id)) {
            stadiumMapper.deleteStadiumById(id);
            result.setMsg("删除成功");
            return result;
        }
        return result;
    }

    /**
     * 修改场馆
     * @param updateStadiumDTO
     */
    @Override
    public void updateStadium(UpdateStadiumDTO updateStadiumDTO) {
        Stadium stadium = new Stadium();
        BeanUtils.copyProperties(updateStadiumDTO, stadium);
        stadiumMapper.updateStadium(stadium);
    }

    /**
     * 查询所有场馆
     * @param stadiumPageQueryDTO
     * @return
     */
    @Override
    public PageResult<PageStadiumVO> pageStadium(StadiumPageQueryDTO stadiumPageQueryDTO) {
        PageHelper.startPage(stadiumPageQueryDTO.getPage(),stadiumPageQueryDTO.getPageSize());
        Page<PageStadiumVO> page = stadiumMapper.pageStadium(stadiumPageQueryDTO);
        long total = page.getTotal();
        List<PageStadiumVO> roles = page.getResult();
        return new PageResult<>(total, roles);
    }
}
