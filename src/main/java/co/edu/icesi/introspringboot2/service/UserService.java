package co.edu.icesi.introspringboot2.service;


import co.edu.icesi.introspringboot2.entity.User;

public interface UserService {
    User findByUsername(String username);
}
