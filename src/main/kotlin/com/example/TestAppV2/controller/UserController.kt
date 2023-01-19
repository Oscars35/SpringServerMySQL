package com.example.TestAppV2.controller

import com.example.TestAppV2.request.UserRequest
import com.example.TestAppV2.service.UserService
import com.oscar.TestApp.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/users")
class UserController(@Autowired val userService: UserService) {

  @GetMapping
  fun getAllUsers(): List<User> {
    return this.userService.getAllUsers();
  }

  @GetMapping("/{id}")
  fun getUserById(@PathVariable("id") id: Int): User {
    return this.userService.getUserById(id);
  }

  @PostMapping("/add")
  fun insertUserById(@RequestBody userRequest: UserRequest): User {
    return this.userService.insertUserById(userRequest);
  }

}
