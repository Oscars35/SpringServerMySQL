package com.example.TestAppV2.service

import com.oscar.TestApp.model.User
import org.springframework.stereotype.Service

interface UserService {
  fun getAllUsers(): List<User>;
}
