package com.example.TestAppV2.dao

import com.example.TestAppV2.request.UserRequest
import com.oscar.TestApp.model.User

interface UserDao {
  fun getAllUsers(): List<User>;
  fun getUserById(id: Int): User;
  fun insertUserById(request: UserRequest): User;
}
