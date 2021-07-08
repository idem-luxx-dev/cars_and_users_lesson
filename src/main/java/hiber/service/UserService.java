package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(Object user);
    List<User> listUsers();
    public User getUserByCar(String model, int series);

}
