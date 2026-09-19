/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.service;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class IncidentSeverityService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Result assess(Request request) {
        int score = Math.min(100, Math.min(20, request.peopleAffected() * 5)
            + (request.medicalTreatment() ? 15 : 0) + (request.lostTime() ? 25 : 0)
            + (request.environmentalRelease() ? 20 : 0)
            + (request.propertyDamage().compareTo(BigDecimal.valueOf(100_000)) >= 0 ? 15 : 0)
            + (request.controlFailure() ? 15 : 0) + (request.repeatedIncident() ? 10 : 0));
        String severity = score >= 75 ? "CRITICAL" : score >= 50 ? "MAJOR" : score >= 25 ? "MODERATE" : "MINOR";
        String response = score >= 75 ? "EMERGENCY" : score >= 50 ? "IMMEDIATE_INVESTIGATION" : "STANDARD_REVIEW";
        List<String> actions = new ArrayList<>();
        if (request.medicalTreatment() || request.lostTime()) actions.add("启动人员救治、报告和停工评估");
        if (request.environmentalRelease()) actions.add("控制泄漏并通知环境责任人");
        if (request.controlFailure()) actions.add("隔离失效控制措施并开展根因分析");
        if (request.repeatedIncident()) actions.add("升级管理层复盘并验证纠正措施有效性");
        return new Result(request.incidentNo(), score, severity, response, actions);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String incidentNo, @Min(0) int peopleAffected,
                          boolean medicalTreatment, boolean lostTime,
                          boolean environmentalRelease,
                          @DecimalMin("0") BigDecimal propertyDamage,
                          boolean controlFailure, boolean repeatedIncident) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Result(String incidentNo, int severityScore, String severity,
                         String response, List<String> actions) {}
}
