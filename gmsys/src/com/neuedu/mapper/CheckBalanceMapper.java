package com.neuedu.mapper;

import com.neuedu.model.CheckBalance;
import java.util.List;

public interface CheckBalanceMapper {
    int deleteByPrimaryKey(Integer chid);

    int insert(CheckBalance record);

    CheckBalance selectByPrimaryKey(Integer chid);

    List<CheckBalance> selectAll();

    int updateByPrimaryKey(CheckBalance record);
}