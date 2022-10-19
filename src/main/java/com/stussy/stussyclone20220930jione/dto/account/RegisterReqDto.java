package com.stussy.stussyclone20220930jione.dto.account;

import com.stussy.stussyclone20220930jione.domain.User;
import com.stussy.stussyclone20220930jione.dto.Validation.ValidationGroups;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Valid
public class RegisterReqDto {

    @NotBlank(message = "이름은 비워 둘 수 없습니다.",groups = ValidationGroups.NotBlankGroup.class)
    @Size(min=1,max=3, message = "이름은 3글자까지만 가능합니다.",groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[가-힇]*$",message = "한글만 입력합니다.",groups = ValidationGroups.PatternGroup.class)
    private String lastName;

    @NotBlank(message = "성은 비워 둘 수 없습니다.",groups = ValidationGroups.NotBlankGroup.class)
    @Size(min=1,max=2, message = "성은 2글자까지만 가능합니다.",groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[가-힇]*$",message = "한글만 입력합니다.",groups = ValidationGroups.PatternGroup.class)
    private String firstName;

    @NotBlank(message = "이메일은 비워 둘 수 없습니다.",groups = ValidationGroups.NotBlankGroup.class)
    @Email
    private String email;

    @NotBlank(message = "비밀번호는 비워 둘 수 없습니다.",groups = ValidationGroups.NotBlankGroup.class)
    @Size(min=8,max=16,message = "비밀번호는 8글자부터 16글자까지 입력하여야합니다.",groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$",groups = ValidationGroups.PatternGroup.class)
    private String password;

    public User toEntity() {
        return User.builder()
                .username(email)
                .password(new BCryptPasswordEncoder().encode(password))
                .name(firstName + lastName)
                .email(email)
                .role_id(1)
                .build();
    }


}
