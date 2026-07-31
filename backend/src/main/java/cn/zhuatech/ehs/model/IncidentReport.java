/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.ehs.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="ehs_incident_report") public class IncidentReport extends BaseEntity {
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String incidentReportNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private SafetyInspection safetyInspection;
    @Column(nullable=false,length=30) private String incidentReportType; @Column(nullable=false) private int incidentReportQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    protected IncidentReport(){} public IncidentReport(String incidentReportNo,SafetyInspection safetyInspection,String incidentReportType,int incidentReportQty,int defectQty,Result result,String inspector){this.incidentReportNo=incidentReportNo;this.safetyInspection=safetyInspection;this.incidentReportType=incidentReportType;this.incidentReportQty=incidentReportQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    public String getIncidentReportNo(){return incidentReportNo;} public SafetyInspection getSafetyInspection(){return safetyInspection;} public String getIncidentReportType(){return incidentReportType;} public int getIncidentReportQty(){return incidentReportQty;} public int getDefectQty(){return defectQty;} public Result getResult(){return result;} public String getInspector(){return inspector;}
}
