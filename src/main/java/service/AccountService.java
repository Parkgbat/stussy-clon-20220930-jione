package service;

import com.stussy.stussyclone20220930jione.dto.account.RegisterReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountService {
    public boolean checkDuplicateEmail(String email);
    public boolean register(RegisterReqDto registerReqDto) throws Exception;
}
