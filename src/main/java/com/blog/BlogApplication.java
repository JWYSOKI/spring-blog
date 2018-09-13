package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

//    @Bean
//    public AdsService adsService() {
//        return new AdsService();
//    }

//    @Bean
//    public AdSvc adSvc() {
//        return new AdSvc();
//    }
//
//
//    @Bean
//    public PostService PostService() {
//        return new PostService();
//    }

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}