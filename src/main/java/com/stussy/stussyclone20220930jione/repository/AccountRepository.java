package com.stussy.stussyclone20220930jione.repository;


import com.stussy.stussyclone20220930jione.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {


        public User findUserByEmail(String email) throws Exception;
        public int saveUser(User user) throws Exception;
}
