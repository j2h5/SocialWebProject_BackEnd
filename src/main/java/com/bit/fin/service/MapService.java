package com.bit.fin.service;

import com.bit.fin.dto.MapDto;
import com.bit.fin.mapper.MapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    @Autowired
    private MapMapper mapMapper;

    public int getClassSu(String class_location){return mapMapper.getClassSu(class_location);}
    public List<MapDto> getClassNum(String class_location){
        return mapMapper.getClassNum(class_location);
    }
}
