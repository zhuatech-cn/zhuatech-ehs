/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.ehs.repository; import cn.zhuatech.ehs.model.SafetyArea; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface SafetyAreaRepository extends JpaRepository<SafetyArea,Long>{Optional<SafetyArea> findByCode(String code);}
