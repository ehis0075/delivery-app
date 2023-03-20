package com.app.deliveryapp.adminUser.repository;

import com.app.deliveryapp.adminUser.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    boolean existsByEmail(String email);

    AdminUser findByEmail(String email);

}
