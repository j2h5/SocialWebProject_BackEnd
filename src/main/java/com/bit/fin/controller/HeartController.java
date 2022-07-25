//package com.bit.fin.controller;
//
//
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.*;
//
//import com.bit.fin.model.Heart;
//import com.bit.fin.model.Message;
//import com.bit.fin.service.HeartService;
//
//import java.util.HashMap;
//
//@RestController
//@RequiredArgsConstructor
//public class HeartController {
//
//    private final HeartService heartService;
//
//    @GetMapping("/classs/{classId}/heart")
//    public HashMap<String, Object> getHeart(@PathVariable Long classId, @AuthenticationPrincipal PrincipalDetails userDetails) {
//        return heartService.getHeart(classId, userDetails.getUser().getId());
//    }
//
//    @PostMapping("/classs/{classId}/heart")
//    public ResponseEntity createHeart(@PathVariable Long classId, @AuthenticationPrincipal PrincipalDetails userDetails){
//        Heart heart = heartService.createHeart(classId, userDetails.getUser().getId());
//        if(heart == null){
//            Message message = new Message("이미좋아요 상태입니다.");
//            return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/classs/{classId}/heart")
//    public ResponseEntity deleteHeart(@PathVariable Long classId, @AuthenticationPrincipal PrincipalDetails userDetails){
//        Heart heart = heartService.DeleteHeart(classId, userDetails.getUser().getId());
//        if(heart == null){
//            Message message = new Message("취소할 좋아요가 없습니다.");
//            return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return ResponseEntity.ok().build();
//    }
//}
