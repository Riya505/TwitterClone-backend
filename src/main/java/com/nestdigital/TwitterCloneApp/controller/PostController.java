package com.nestdigital.TwitterCloneApp.controller;

import com.nestdigital.TwitterCloneApp.dao.PostDao;
import com.nestdigital.TwitterCloneApp.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {
    @Autowired
    private PostDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addposts",consumes = "application/json",produces = "application/json")
    public String Posts(@RequestBody PostModel post)
    {
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        post.setPosted_date(currentdate);
        System.out.println(post.toString());
        dao.save(post);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewposts")
    public List<Map<String,String>> viewposts(){
        return (List<Map<String,String>>) dao.ViewAllPosts();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/single",consumes = "application/json",produces = "application/json")
    List<Map<String,String>> Viewsingle(@RequestBody PostModel post){
        return (List<Map<String,String>>) dao.view(post.getUser_id());
    }
}
