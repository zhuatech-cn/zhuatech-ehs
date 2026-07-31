/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.ehs.repository; import cn.zhuatech.ehs.model.IncidentReport; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface IncidentReportRepository extends JpaRepository<IncidentReport,Long>{List<IncidentReport> findTop10ByOrderByIdDesc();long countByResult(IncidentReport.Result result);}
