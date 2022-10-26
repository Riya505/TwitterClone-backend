package com.nestdigital.TwitterCloneApp.dao;

import com.nestdigital.TwitterCloneApp.model.PostModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface PostDao extends CrudRepository<PostModel,Integer> {

  @Query(value = "SELECT p.id, p.`post`, p.`posted_date`,p.user_id, u.name FROM `post` p JOIN user_data u ON u.id=p.user_id",nativeQuery = true)
    List<Map<String,String>> ViewAllPosts();
@Query(value = "SELECT p.id, p.`post`, p.`posted_date`,p.user_id, u.name FROM `post` p JOIN user_data u ON u.id=p.user_id WHERE p.`user_id`=:user_id",nativeQuery = true)
    List<Map<String,String>> view(Integer user_id);
}
