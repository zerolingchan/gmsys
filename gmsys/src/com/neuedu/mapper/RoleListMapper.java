package com.neuedu.mapper;

import com.neuedu.model.RoleList;
import java.util.List;

public interface RoleListMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(RoleList record);

    RoleList selectByPrimaryKey(Integer rid);

    List<RoleList> selectAll();

    int updateByPrimaryKey(RoleList record);
}