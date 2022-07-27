package com.bit.fin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MapMapper {
    public int getClassSu(String class_location);
}
