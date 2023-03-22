package com.app.deliveryapp.adminUser.controller;

import com.app.deliveryapp.adminUser.dto.AdminUserDTO;
import com.app.deliveryapp.adminUser.dto.RegistrationRequestDTO;
import com.app.deliveryapp.adminUser.model.AdminUser;
import com.app.deliveryapp.adminUser.service.AdminUserService;
import com.app.deliveryapp.general.dto.Response;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.general.service.GeneralService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adminUsers")
public class AdminUserController {

    private final GeneralService generalService;

    private final AdminUserService adminUserService;

    public AdminUserController(GeneralService generalService, AdminUserService adminUserService) {
        this.generalService = generalService;
        this.adminUserService = adminUserService;
    }

//    @PostMapping("/registration")
//    public Response createAdminUser(@RequestBody RegistrationRequestDTO requestDTO) {
//
//        AdminUserDTO data = adminUserService.createAdminUser(requestDTO);
//        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
//    }

    @PostMapping("/registration")
    public ResponseEntity<?> createAdminUser(@RequestBody RegistrationRequestDTO requestDTO) {

        AdminUserDTO data = adminUserService.createAdminUser(requestDTO);

        return  ResponseEntity.ok(data);
    }
    @GetMapping()
    public Response getAllAdminUser() {

        List<AdminUser> data = adminUserService.getAllAdminUsers();
        return generalService.prepareResponse(ResponseCodeAndMessage.SUCCESSFUL_0, data);
    }

}
