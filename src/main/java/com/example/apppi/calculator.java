package com.example.apppi;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class calculator {

    //@Cacheable(value = "pi")
    public double getPI(int num)
    {
        double pi, n = 0, test = 0;
        for(int i = 0; i < num; i++)
        {
            double x = Math.random() % 100;
            double y = Math.random() % 100;
            n++;
            if(x*x+y*y <= 100*100)
            {
                test++;
            }
        }
        pi = test/n;
        return pi;
    }
}
