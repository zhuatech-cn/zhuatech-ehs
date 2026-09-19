/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="ehs_incident_report") public class IncidentReport extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String incidentReportNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private SafetyInspection safetyInspection;
    @Column(nullable=false,length=30) private String incidentReportType; @Column(nullable=false) private int incidentReportQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected IncidentReport(){} /**
                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                  */
public IncidentReport(String incidentReportNo,SafetyInspection safetyInspection,String incidentReportType,int incidentReportQty,int defectQty,Result result,String inspector){this.incidentReportNo=incidentReportNo;this.safetyInspection=safetyInspection;this.incidentReportType=incidentReportType;this.incidentReportQty=incidentReportQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getIncidentReportNo(){return incidentReportNo;} /**
                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                   */
public SafetyInspection getSafetyInspection(){return safetyInspection;} /**
                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                           */
public String getIncidentReportType(){return incidentReportType;} /**
                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                             */
public int getIncidentReportQty(){return incidentReportQty;} /**
                                                                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                          */
public int getDefectQty(){return defectQty;} /**
                                                                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                       */
public Result getResult(){return result;} /**
                                                                                                                                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                 */
public String getInspector(){return inspector;}
}
