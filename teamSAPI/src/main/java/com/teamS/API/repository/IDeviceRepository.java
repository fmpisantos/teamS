package com.teamS.API.repository;

import com.teamS.API.DAO.Security.User.Devices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeviceRepository extends JpaRepository<Devices, Long> {
    Devices findByUserId(long userId);
}
