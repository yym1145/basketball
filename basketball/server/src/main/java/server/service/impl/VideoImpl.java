package server.service.impl;



import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.annotation.CleanUpFilesOnError;
import com.basketball.annotation.FilePreSignature;
import com.basketball.dto.video.SelectAllVideoDTO;
import com.basketball.dto.video.UploadVideoDTO;
import com.basketball.entity.Video;
import com.basketball.exception.BaseException;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.vo.video.GetVideoDetailsVO;
import com.basketball.vo.video.SelectAllVideoVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import server.mapper.VideoMapper;
import server.service.FileService;
import server.service.VideoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoImpl implements VideoService {

    private final VideoMapper videoMapper;

    private final FileService fileService;

    @Override
    @CleanUpFilesOnError
    public String uploadVideo(UploadVideoDTO uploadVideoDTO, MultipartFile videoFile) {
        Video video = new Video();
        video.setId(String.valueOf(IdWorker.getId()));
        BeanUtils.copyProperties(uploadVideoDTO, video);
        if (videoFile != null) {
            video.setVideoFileId(String.valueOf(fileService.upload(videoFile)));
        }
        videoMapper.insertVideo(video);
        return video.getId();
    }

    @Override
    @FilePreSignature
    public PageResult<SelectAllVideoVO> selectAllVideo(SelectAllVideoDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        Page<SelectAllVideoVO> page = videoMapper.selectAllVideo(dto);
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    @FilePreSignature
    public GetVideoDetailsVO getVideoDetails(String id) {
        Video video = videoMapper.getByIdVideo(id);
        if (video == null) {
            throw new BaseException("视频不存在");
        }
        GetVideoDetailsVO vo = videoMapper.getVideoDetails(id);
        return vo;

    }
}
