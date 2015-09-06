package com.equivi.mailsy.application.data.dao;


import com.equivi.mailsy.application.data.model.AppRegistryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRegistryDao extends JpaRepository<AppRegistryEntity, Long> {

    AppRegistryEntity findByRegistryKey(String registryKey);
}
