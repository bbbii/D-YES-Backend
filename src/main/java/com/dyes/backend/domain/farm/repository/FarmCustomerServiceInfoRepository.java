package com.dyes.backend.domain.farm.repository;

import com.dyes.backend.domain.farm.entity.Farm;
import com.dyes.backend.domain.farm.entity.FarmCustomerServiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FarmCustomerServiceInfoRepository extends JpaRepository<FarmCustomerServiceInfo, Long> {
    FarmCustomerServiceInfo findByFarm(Farm farm);

    @Query("select fcs FROM FarmCustomerServiceInfo fcs join fetch fcs.farm")
    List<FarmCustomerServiceInfo> findByFarmAddressAddressContaining(String farmLocation);
}
