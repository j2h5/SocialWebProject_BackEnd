package com.bit.fin.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("mapa")
@Data
public class MapDto {
    private int class_num;
}
