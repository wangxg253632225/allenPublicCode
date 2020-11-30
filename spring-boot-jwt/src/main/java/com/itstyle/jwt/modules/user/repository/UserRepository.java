package com.itstyle.jwt.modules.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itstyle.jwt.modules.user.model.User;

/**
 * 用户管理
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
