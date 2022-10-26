package com.nestdigital.TwitterCloneApp.dao;

import com.nestdigital.TwitterCloneApp.model.SignupModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SignupDao extends CrudRepository<SignupModel,Integer> {

    @Query(value = "SELECT `id`, `dob`, `email`, `name`, `password`, `phone`, `place` FROM `user_data` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    List<SignupModel> Signup(String email,String password);
}
