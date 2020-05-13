package service;

import entity.Department;
import entity.User;

import java.util.List;

public interface IUserService {
    int checkUser(User user);
    List<Department> getDepartmentList();
}
