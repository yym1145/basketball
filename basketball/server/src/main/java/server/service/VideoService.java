package server.service;

import com.basketball.dto.video.SelectAllVideoDTO;
import com.basketball.dto.video.UploadVideoDTO;
import com.basketball.result.PageResult;
import com.basketball.vo.video.GetVideoDetailsVO;
import com.basketball.vo.video.SelectAllVideoVO;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
    /**
     * 上传视频
     * @param uploadVideoDTO 视频信息
     * @param videoFile 视频文件
     * @return 视频ID
     */
    String uploadVideo(UploadVideoDTO uploadVideoDTO, MultipartFile videoFile);

     /**
     * 查询所有视频
     * @param dto 查询参数
     * @return 视频列表
     */
     PageResult<SelectAllVideoVO> selectAllVideo(SelectAllVideoDTO dto);

     /**
     * 查询视频详情
     * @param id 视频ID
     * @return 视频详情
     */
     GetVideoDetailsVO getVideoDetails(String id);
}
