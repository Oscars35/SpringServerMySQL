package com.example.TestAppV2.dao

import com.oscar.TestApp.model.User

interface UserDao {
  fun getAllUsers(): List<User>;
}
