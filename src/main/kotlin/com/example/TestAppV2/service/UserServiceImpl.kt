package com.example.TestAppV2.service

import com.example.TestAppV2.dao.UserDao
import com.oscar.TestApp.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired val userDao: UserDao): UserService {
  override fun getAllUsers(): List<User> {
    val users: List<User> = this.userDao.getAllUsers();
    return users;
  }
}
