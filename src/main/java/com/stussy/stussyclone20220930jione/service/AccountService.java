package com.stussy.stussyclone20220930jione.service;

import com.stussy.stussyclone20220930jione.dto.account.RegisterReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountService {
    public void duplicateEmail(RegisterReqDto registerReqDto) throws Exception;
    public void register(RegisterReqDto registerReqDto) throws Exception;
}
