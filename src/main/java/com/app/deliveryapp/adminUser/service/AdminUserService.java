package com.app.deliveryapp.adminUser.service;

import com.app.deliveryapp.adminUser.dto.AdminUserDTO;
import com.app.deliveryapp.adminUser.dto.RegistrationRequestDTO;

public interface AdminUserService {

    AdminUserDTO createAdminUser(RegistrationRequestDTO createAdminUserDto);

}

