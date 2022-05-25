package com.devoir.mestaoui_ghoudan.repository;

import com.devoir.mestaoui_ghoudan.models.Developpeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloppeurRepository extends JpaRepository<Developpeur, Long> {
}
