package com.neuedu.mapper;

import com.neuedu.model.T_user;
import java.util.List;

public interface T_userMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(T_user record);

    T_user selectByPrimaryKey(Integer userId);

    List<T_user> selectAll();

    int updateByPrimaryKey(T_user record);
}