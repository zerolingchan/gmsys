package com.neuedu.mapper;

import com.neuedu.model.Demo;
import java.util.List;

public interface DemoMapper {
    int insert(Demo record);

    List<Demo> selectAll();
}