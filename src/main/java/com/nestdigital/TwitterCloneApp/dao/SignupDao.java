package com.nestdigital.TwitterCloneApp.dao;

import com.nestdigital.TwitterCloneApp.model.SignupModel;
import org.springframework.data.repository.CrudRepository;

public interface SignupDao extends CrudRepository<SignupModel,Integer> {
}
