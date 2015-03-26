package com.simple.reading.admin.mapper;

import java.util.List;

import com.simple.reading.admin.entities.RoleEntity;

public interface RoleMapper {

	public RoleEntity getRoleByLevel(int level);

	public List<RoleEntity> getRoleAll();

	public void addRole(RoleEntity roleEntity);

	public void updateRole(RoleEntity roleEntity);

	public void deleteRole(RoleEntity roleEntity);

}
