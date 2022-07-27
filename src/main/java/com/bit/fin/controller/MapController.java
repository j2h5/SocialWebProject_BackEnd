package com.bit.fin.controller;

import com.bit.fin.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
