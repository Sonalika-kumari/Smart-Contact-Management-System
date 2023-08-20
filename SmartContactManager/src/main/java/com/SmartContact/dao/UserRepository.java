package com.SmartContact.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SmartContact.entities.User;

public interface UserRepository  extends  JpaRepository<User, Integer>{

}
