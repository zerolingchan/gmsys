package com.neuedu.mapper;

import com.neuedu.model.RolePrivilege;
import java.util.List;

public interface RolePrivilegeMapper {
    int deleteByPrimaryKey(Integer rpid);

    int insert(RolePrivilege record);

    RolePrivilege selectByPrimaryKey(Integer rpid);

    List<RolePrivilege> selectAll();

    int updateByPrimaryKey(RolePrivilege record);
}