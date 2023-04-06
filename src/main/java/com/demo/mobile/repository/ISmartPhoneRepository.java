package com.demo.mobile.repository;

import com.demo.mobile.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends JpaRepository<Smartphone, Long> {
}
