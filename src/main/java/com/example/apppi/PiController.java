package com.example.apppi;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PiController {

    @Autowired
    calculator c;

//    @Autowired
//    private CacheManager cacheManager;

    @GetMapping("/login")
    ResponseEntity<Boolean> login(HttpSession session) {
        System.out.println("login " + session.getId());
        session.setAttribute("login", Boolean.TRUE);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping("/pi")
    ResponseEntity<Long> pi(HttpSession session) {
        System.out.println("pi " + session.getId());
        if (session.getAttribute("login") == null || !(boolean) (session.getAttribute("login"))) {
            return new ResponseEntity<Long>(-1L, HttpStatus.UNAUTHORIZED);
        }

        long startTime = System.currentTimeMillis();
        double pi = c.getPI(10_000_000);
        long endTime = System.currentTimeMillis();
        return ResponseEntity.ok(Long.valueOf(endTime - startTime));
    }

//    @RequestMapping(value = "clearCache")
//    public void clearCache() {
//        for (String name : cacheManager.getCacheNames()) {
//            cacheManager.getCache(name).clear();
//        }
//    }

}