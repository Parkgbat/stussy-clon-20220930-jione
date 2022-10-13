package com.stussy.stussyclone20220930jione.api;

import com.stussy.stussyclone20220930jione.aop.annotation.LogAspect;
import com.stussy.stussyclone20220930jione.dto.CMRespDto;
import com.stussy.stussyclone20220930jione.dto.RegisterReqDto;
import com.stussy.stussyclone20220930jione.dto.Validation.ValidationSequence;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    

    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody  RegisterReqDto registerReqDto, BindingResult bindingResult) {


        return ResponseEntity.created(null).body(new CMRespDto<> ( "회원가입 성공", registerReqDto));

    }



}
