package com.linmou.conterler;

import com.linmou.anno.anno;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author linmou
 * @date 2020/9/19 - 22:03
 */
@Controller
public class user {
    @RequestMapping("/user")
    @anno
    public ResponseEntity<String> a(@RequestParam("username")String username){
        return ResponseEntity.ok("哈");
    }
    @RequestMapping("/user1")
    public ResponseEntity<String> a1(){
        return ResponseEntity.ok("ssssa");
    }

}
