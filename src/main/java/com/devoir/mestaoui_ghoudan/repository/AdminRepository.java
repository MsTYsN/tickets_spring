package com.devoir.mestaoui_ghoudan.repository;

import com.devoir.mestaoui_ghoudan.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
