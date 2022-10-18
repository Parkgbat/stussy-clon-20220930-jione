package service;


import com.stussy.stussyclone20220930jione.exception.CustomValidationException;
import com.stussy.stussyclone20220930jione.domain.User;
import com.stussy.stussyclone20220930jione.dto.account.RegisterReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;



    @Override
    public boolean checkDuplicateEmail(String email) {

        User user = accountRepository.findUserByEmail(email);
        if(user != null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("duplicateFlag", "이미 가입된 이메일입니다");
            throw new CustomValidationException("DuplicateEmail Error", errorMap);
        }

        return true;
    }

    @Override
    public boolean register(RegisterReqDto registerReqDto) throws Exception {
        return false;
    }
}
