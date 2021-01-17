package com.example.demo.repos;

import com.example.demo.model.UpdateInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateInfoRepo extends CrudRepository<UpdateInfo, Integer> {
}