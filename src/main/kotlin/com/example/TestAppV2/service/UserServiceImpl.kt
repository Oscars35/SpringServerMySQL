package com.example.TestAppV2.service

import com.example.TestAppV2.dao.UserDao
import com.example.TestAppV2.request.UserRequest
import com.oscar.TestApp.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired val userDao: UserDao): UserService {
  override fun getAllUsers(): List<User> {
    val users: List<User> = this.userDao.getAllUsers();
    return users;
  }

  override fun getUserById(id: Int): User {
    val user: User = this.userDao.getUserById(id);
    return user;
  }

  override fun insertUserById(request: UserRequest): User {
    val user: User = this.userDao.insertUserById(request);
    return user;
  }
}
