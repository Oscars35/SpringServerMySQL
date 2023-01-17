package com.example.TestAppV2.controller

import com.example.TestAppV2.service.UserService
import com.oscar.TestApp.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(@Autowired val userService: UserService) {

  @GetMapping
  fun getAllUsers(): List<User> {
    return this.userService.getAllUsers();
  }

}
