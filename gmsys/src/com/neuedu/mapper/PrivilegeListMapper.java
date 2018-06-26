package com.neuedu.mapper;

import com.neuedu.model.PrivilegeList;
import java.util.List;

public interface PrivilegeListMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(PrivilegeList record);

    PrivilegeList selectByPrimaryKey(Integer pid);

    List<PrivilegeList> selectAll();

    int updateByPrimaryKey(PrivilegeList record);
}