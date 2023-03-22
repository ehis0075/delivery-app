package com.app.deliveryapp.adminUser.service;

import com.app.deliveryapp.adminUser.dto.AdminUserDTO;
import com.app.deliveryapp.adminUser.dto.RegistrationRequestDTO;
import com.app.deliveryapp.adminUser.model.AdminUser;

import java.util.List;

public interface AdminUserService {

    AdminUserDTO createAdminUser(RegistrationRequestDTO createAdminUserDto);

    List<AdminUser> getAllAdminUsers();

}

