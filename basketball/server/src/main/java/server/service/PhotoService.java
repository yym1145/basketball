package server.service;

import com.basketball.dto.photo.SelectMatchPhotoListDTO;
import com.basketball.dto.photo.UploadPhotoDTO;
import com.basketball.result.PageResult;
import com.basketball.result.Result;
import com.basketball.vo.photo.SelectAllMatchPhotoVO;
import com.basketball.vo.photo.SelectMatchPhotoVO;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
    String uploadPhoto(UploadPhotoDTO uploadPhotoDTO, MultipartFile file);

    PageResult<SelectAllMatchPhotoVO> selectAllMatchPhoto(SelectMatchPhotoListDTO selectMatchPhotoListDTO);

    SelectMatchPhotoVO selectMatchPhoto(Long id);
}
