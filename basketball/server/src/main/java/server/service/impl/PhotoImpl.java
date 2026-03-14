package server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.basketball.annotation.CleanUpFilesOnError;
import com.basketball.annotation.FilePreSignature;
import com.basketball.dto.photo.SelectMatchPhotoListDTO;
import com.basketball.dto.photo.UploadPhotoDTO;
import com.basketball.entity.MatchPhoto;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.vo.photo.SelectAllMatchPhotoVO;
import com.basketball.vo.photo.SelectMatchPhotoVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import server.mapper.MatchPhotoMapper;
import server.service.FileService;
import server.service.PhotoService;

@Service
@RequiredArgsConstructor
public class PhotoImpl implements PhotoService {

    private final MatchPhotoMapper matchPhotoMapper;

    private final FileService fileService;
    @Override
    @CleanUpFilesOnError
    public String uploadPhoto(UploadPhotoDTO uploadPhotoDTO, MultipartFile file) {
        MatchPhoto matchPhoto = new MatchPhoto();
        matchPhoto.setId(IdWorker.getId());
        matchPhoto.setMatchId(uploadPhotoDTO.getMatchId());
        matchPhoto.setDescription(uploadPhotoDTO.getDescription());
        if (file != null){
            matchPhoto.setFileId(fileService.upload(file));
        }
        matchPhotoMapper.uploadPhoto(matchPhoto);
        return String.valueOf(matchPhoto.getId());
    }

    @Override
    @FilePreSignature
    public PageResult<SelectAllMatchPhotoVO> selectAllMatchPhoto(SelectMatchPhotoListDTO selectMatchPhotoListDTO) {
        PageHelper.startPage(selectMatchPhotoListDTO.getPage(), selectMatchPhotoListDTO.getPageSize());
        Page<SelectAllMatchPhotoVO> page = matchPhotoMapper.selectAllMatchPhoto(selectMatchPhotoListDTO);
        return new PageResult<>(page.getTotal(),page.getResult());
    }

    @Override
    @FilePreSignature
    public SelectMatchPhotoVO selectMatchPhoto(Long id) {
        return matchPhotoMapper.selectMatchPhoto(id);
    }
}
