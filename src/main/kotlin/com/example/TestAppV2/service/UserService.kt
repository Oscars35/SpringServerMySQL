package com.example.TestAppV2.service

import com.example.TestAppV2.request.UserRequest
import com.oscar.TestApp.model.User
import org.springframework.stereotype.Service

interface UserService {
  fun getAllUsers(): List<User>;
  fun getUserById(id: Int): User;
  fun insertUserById(request: UserRequest): User;
}
