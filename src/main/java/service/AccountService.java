package service;

import com.stussy.stussyclone20220930jione.dto.RegisterReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountService {
    public void register(RegisterReqDto registerReqDto) throws Exception;
}
