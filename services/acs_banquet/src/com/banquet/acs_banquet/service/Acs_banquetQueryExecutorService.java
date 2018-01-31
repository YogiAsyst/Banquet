/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/

package com.banquet.acs_banquet.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.InputStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.banquet.acs_banquet.models.query.*;

public interface Acs_banquetQueryExecutorService {

    Page<GetCat3ProductResponse> executeGet_cat_3_product(Pageable pageable);

    InputStream getPpictureContentForGet_cat_3_product(Integer pcode, String pname, String pdescription, Integer prating, String catName) throws EntityNotFoundException;

    Downloadable exportGet_cat_3_product(ExportType exportType, Pageable pageable);

    Page<GetCat1ProductResponse> executeGet_cat_1_product(Pageable pageable);

    InputStream getPpictureContentForGet_cat_1_product(Integer pcode, String pname, String pdescription, Integer prating, String catName) throws EntityNotFoundException;

    Downloadable exportGet_cat_1_product(ExportType exportType, Pageable pageable);

    Page<GetCat4ProductResponse> executeGet_cat_4_product(Pageable pageable);

    InputStream getPpictureContentForGet_cat_4_product(Integer pcode, String pname, String pdescription, Integer prating, String catName) throws EntityNotFoundException;

    Downloadable exportGet_cat_4_product(ExportType exportType, Pageable pageable);

    Page<GetCat2ProductResponse> executeGet_cat_2_product(Pageable pageable);

    InputStream getPpictureContentForGet_cat_2_product(Integer pcode, String pname, String pdescription, Integer prating, String catName) throws EntityNotFoundException;

    Downloadable exportGet_cat_2_product(ExportType exportType, Pageable pageable);

}


