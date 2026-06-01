package com.korit.ch03.mapper;

import com.korit.ch03.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    int insert(Role role);

}
