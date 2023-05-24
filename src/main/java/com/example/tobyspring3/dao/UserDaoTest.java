package com.example.tobyspring3.dao;

import com.example.tobyspring3.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        User user = new User();
        user.setId("4");
        user.setName("4444");
        user.setPassword("1234");
        userDao.add(user);

        User selectedUser = userDao.get("4");
        System.out.println("selectedUser.getId() = " + selectedUser.getId());
        System.out.println("selectedUser.getName() = " + selectedUser.getName());
        System.out.println("selectedUser.getPassword() = " + selectedUser.getPassword());
    }
}
