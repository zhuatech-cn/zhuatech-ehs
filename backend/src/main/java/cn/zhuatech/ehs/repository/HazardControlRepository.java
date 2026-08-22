/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.repository; import cn.zhuatech.ehs.model.HazardControl; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface HazardControlRepository extends JpaRepository<HazardControl,Long>{List<HazardControl> findAllByOrderByCodeAsc();long countByStatus(HazardControl.Status status);}
