/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.config;

import cn.zhuatech.ehs.model.*;
import cn.zhuatech.ehs.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Configuration
public class DataInitializer {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Bean
    CommandLineRunner seed(SafetyAreaRepository safetyAreas, SafetyInspectionRepository orders,
                           HazardControlRepository hazardControls, IncidentReportRepository incidentReports,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (safetyAreas.count() > 0) return;
            SafetyArea chemistry = safetyAreas.save(new SafetyArea("EHS-CHEM", "装配车间", "EHS 中心", 180));
            SafetyArea micro = safetyAreas.save(new SafetyArea("EHS-MICRO", "仓储物流区", "研发中心", 120));
            SafetyArea material = safetyAreas.save(new SafetyArea("EHS-MAT", "动力站房", "工程中心", 96));

            SafetyInspection t1 = orders.save(new SafetyInspection("INS-260801-018", "GB-T-228", "高处作业专项巡检", material, 24, 16, 1, LocalDate.now().plusDays(1), SafetyInspection.Status.RUNNING, "A区-03"));
            SafetyInspection t2 = orders.save(new SafetyInspection("INS-260801-021", "EHS-CHEM-12", "危化品仓库日常巡检", chemistry, 18, 8, 0, LocalDate.now().plusDays(1), SafetyInspection.Status.RUNNING, "C库-02"));
            SafetyInspection t3 = orders.save(new SafetyInspection("INS-260802-006", "ISO-4833", "配电室季度检查", micro, 12, 0, 0, LocalDate.now().plusDays(3), SafetyInspection.Status.RELEASED, "配电-01"));
            SafetyInspection t4 = orders.save(new SafetyInspection("INS-260717-015", "EHS-FORK-09", "叉车作业安全检查", chemistry, 20, 20, 1, LocalDate.now(), SafetyInspection.Status.COMPLETED, "物流-05"));

            hazardControls.saveAll(List.of(
                new HazardControl("HZD-HPLC-03", "高处作业隔离措施", chemistry, HazardControl.Status.RUNNING, 88),
                new HazardControl("HZD-ICP-02", "危化品泄漏控制", chemistry, HazardControl.Status.IDLE, 76),
                new HazardControl("HZD-UTM-05", "配电室联锁保护", material, HazardControl.Status.RUNNING, 91),
                new HazardControl("HZD-INC-08", "叉车人车分流控制", micro, HazardControl.Status.ALARM, 62)
            ));
            incidentReports.saveAll(List.of(
                new IncidentReport("INC-260801-032", t1, "留样复盘", 6, 0, IncidentReport.Result.PASSED, "周妍"),
                new IncidentReport("INC-260801-011", t2, "前处理复盘", 3, 0, IncidentReport.Result.PASSED, "陆承"),
                new IncidentReport("INC-260801-018", t4, "整改复核", 5, 1, IncidentReport.Result.FAILED, "周妍"),
                new IncidentReport("INC-260802-003", t3, "巡检登记确认", 4, 0, IncidentReport.Result.PENDING, "陆承")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "陆承", UserAccount.Role.SAFETY_OFFICER, "EHS-CHEM"),
                new UserAccount("planner", demo, "周妍", UserAccount.Role.EHS_MANAGER, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
