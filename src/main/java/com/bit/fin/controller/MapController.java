package com.bit.fin.controller;

import com.bit.fin.dto.MapDto;
import com.bit.fin.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/map")
public class MapController {

    @Autowired
    private MapService mapService;

    @GetMapping("/getClassSu")
    public int getClassSu(@RequestParam String class_location){
        return mapService.getClassSu(class_location);
    }

    @GetMapping("/getClassNum")
    public List<MapDto> getClassNum(@RequestParam String class_location){
        List<MapDto> return1 = mapService.getClassNum(class_location);
        System.out.println("return1 = " + return1);
        return return1;
    }
}
