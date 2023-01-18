package com.example.TestAppV2.dao

import com.example.TestAppV2.request.UserRequest
import com.oscar.TestApp.model.User
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.support.JdbcDaoSupport
import org.springframework.stereotype.Repository
import javax.sql.DataSource


@Repository
class UserDaoImpl (@Autowired val dataSource3: DataSource): JdbcDaoSupport(), UserDao{

  @PostConstruct
  private fun initialize() {
    setDataSource(this.dataSource3);
  }
  override fun getAllUsers(): List<User> {
    val sql = "SELECT * FROM Users"
    val rows = jdbcTemplate!!.queryForList(sql)
    val result: MutableList<User> = ArrayList<User>()
    for (row in rows) {
      val emp = User(row["id"].toString().toInt(), row["name"].toString());
      result.add(emp)
    }
    return result;
  }

  override fun getUserById(id: Int): User {
    val sql = "SELECT * FROM Users WHERE id=$id";
    val rows = jdbcTemplate!!.queryForList(sql);
    val user = User(rows[0]["id"].toString().toInt(), rows[0]["name"].toString());
    return user;
  }

  override fun insertUserById(request: UserRequest): User {
    val sql = "INSERT INTO Users(name) VALUES ('${request.name}')";
    jdbcTemplate!!.execute(sql);
    val sql2 = "SELECT * FROM Users ORDER BY ID DESC LIMIT 1";
    val rows = jdbcTemplate!!.queryForList(sql2);
    val user = User(rows[0]["id"].toString().toInt(), rows[0]["name"].toString());
    return user;
  }
}
