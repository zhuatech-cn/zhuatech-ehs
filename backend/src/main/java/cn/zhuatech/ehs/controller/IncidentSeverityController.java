/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.controller;

import cn.zhuatech.ehs.common.ApiResponse;
import cn.zhuatech.ehs.service.IncidentSeverityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/admin")
public class IncidentSeverityController {
    private final IncidentSeverityService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public IncidentSeverityController(IncidentSeverityService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/incident-severity")
    public ApiResponse<IncidentSeverityService.Result> assess(@Valid @RequestBody IncidentSeverityService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
