package com.stussy.stussyclone20220930jione.service.admin;

import com.stussy.stussyclone20220930jione.dto.admin.CategoryResponseDto;
import com.stussy.stussyclone20220930jione.dto.admin.ProductRegisterReqDto;

import java.util.List;

public interface ProductManagementService {


    public List<CategoryResponseDto> getCategoryList() throws Exception;

    public void registerMst(ProductRegisterReqDto productRegisterReqDto) throws Exception;

}