package com.app.deliveryapp.adminUser.controller;

import com.app.deliveryapp.adminUser.dto.AdminUserDTO;
import com.app.deliveryapp.adminUser.dto.RegistrationRequestDTO;
import com.app.deliveryapp.adminUser.service.AdminUserService;
import com.app.deliveryapp.general.dto.Response;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.general.service.GeneralService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adminUsers")
public class UserController {

    private final GeneralService generalService;

    private final AdminUserService adminUserService;

    public UserController(GeneralService generalService, AdminUserService adminUserService) {
        this.generalService = generalService;
        this.adminUserService = adminUserService;
    }

    @PostMapping("/registration")
    public Response createAdminUser(@RequestBody RegistrationRequestDTO requestDTO) {

        AdminUserDTO data = adminUserService.createAdminUser(requestDTO);
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
