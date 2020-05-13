package service.impl;

import entity.Department;
import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public int checkUser(User user){
        int result = userMapper.checkUser(user);
        if(result == 1){
            return 1;
        }
        return 0;
    }

    @Override
    public List<Department> getDepartmentList() {
        List<Department> departmentList = userMapper.getDepartmentList();
        return departmentList;
    }
}