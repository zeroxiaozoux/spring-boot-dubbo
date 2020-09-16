package com.zero.core.dao;

import com.zero.core.mode.Screenshot;

public interface ScreenshotMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Screenshot record);

    int insertSelective(Screenshot record);

    Screenshot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Screenshot record);

    int updateByPrimaryKey(Screenshot record);
}