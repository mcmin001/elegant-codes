package com.elegant.codes.dao.user;

import com.elegant.codes.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserDao extends JpaRepository<User,String>, Serializable {
}
