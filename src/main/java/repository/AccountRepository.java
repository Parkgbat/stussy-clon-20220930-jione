package repository;


import com.stussy.stussyclone20220930jione.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {


        public int save(User user);
        public User findUserByEmail(String Email);
}
