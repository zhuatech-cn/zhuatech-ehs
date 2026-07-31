/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.ehs.repository; import cn.zhuatech.ehs.model.SafetyInspection; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface SafetyInspectionRepository extends JpaRepository<SafetyInspection,Long>{List<SafetyInspection> findAllByOrderByDueDateAsc();List<SafetyInspection> findBySafetyAreaCodeOrderByDueDateAsc(String code);long countByStatus(SafetyInspection.Status status);}
