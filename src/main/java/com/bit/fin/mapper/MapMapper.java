package com.bit.fin.mapper;

import com.bit.fin.dto.MapDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapMapper {
    public int getClassSu(String class_location);
    public List<MapDto> getClassNum(String class_location);
}
