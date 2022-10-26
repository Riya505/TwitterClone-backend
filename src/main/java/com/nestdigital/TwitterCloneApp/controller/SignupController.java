package com.nestdigital.TwitterCloneApp.controller;

import com.nestdigital.TwitterCloneApp.dao.SignupDao;
import com.nestdigital.TwitterCloneApp.model.SignupModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SignupController {
    @Autowired
    private SignupDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userData",consumes = "application/json",produces = "application/json")
    public String userData(@RequestBody SignupModel signup){
        System.out.println(signup.toString());
        dao.save(signup);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public List<SignupModel> Login(@RequestBody SignupModel signup){
        return (List<SignupModel>) dao.Signup(signup.getEmail(),signup.getPassword());
    }
}
