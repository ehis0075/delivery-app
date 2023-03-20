package com.app.deliveryapp.adminUser.service.implementation;

import com.app.deliveryapp.adminUser.dto.AdminUserDTO;
import com.app.deliveryapp.adminUser.dto.RegistrationRequestDTO;
import com.app.deliveryapp.adminUser.model.AdminUser;
import com.app.deliveryapp.adminUser.repository.AdminUserRepository;
import com.app.deliveryapp.adminUser.service.AdminUserService;
import com.app.deliveryapp.exception.GeneralException;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import com.app.deliveryapp.general.service.GeneralService;
import com.app.deliveryapp.util.GeneralUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final GeneralService generalService;

    private final AdminUserRepository adminUserRepository;

    public AdminUserServiceImpl(GeneralService generalService, AdminUserRepository adminUserRepository) {
        this.generalService = generalService;
        this.adminUserRepository = adminUserRepository;
    }

    @Override
    public AdminUserDTO createAdminUser(RegistrationRequestDTO requestDTO) {
        log.info("creating a user with payload = {}", requestDTO);

        //validate first name, last name
        GeneralUtil.validateName(requestDTO.getFirstName(), requestDTO.getLastName());

        // email to lower case
        String email = requestDTO.getEmail().toLowerCase();

        // validate email
        validateEmail(email);

        //create new user
        AdminUser adminUser = new AdminUser();
        adminUser.setFirstName(requestDTO.getFirstName());
        adminUser.setLastName(requestDTO.getLastName());
        adminUser.setEmail(email);
        adminUser.setPassword(requestDTO.getPassword());

        // save to db
        AdminUser savedAdminUser = saveAdminUser(adminUser);

        // convert to dto
        return getUserDTO(savedAdminUser);
    }

    public AdminUserDTO getUserDTO(AdminUser adminUser) {
        log.info("Converting Admin User to Admin User DTO");

        AdminUserDTO adminUserDTO = new AdminUserDTO();
        generalService.createDTOFromModel(adminUser, adminUserDTO);

        return adminUserDTO;
    }

    private void validateEmail(String email) {

        if (GeneralUtil.invalidEmail(email)) {
            log.info("Admin User email {} is invalid", email);
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "Admin User Email " + email + " is invalid!");
        }

        if (adminUserRepository.existsByEmail(email)) {
            throw new GeneralException(ResponseCodeAndMessage.ALREADY_EXIST_86.responseCode, "Admin user with Email " + email + " already exist");
        }
    }

    private AdminUser saveAdminUser(AdminUser adminUser) {
        log.info("::: saving admin user to db :::");
        return adminUserRepository.save(adminUser);
    }
}