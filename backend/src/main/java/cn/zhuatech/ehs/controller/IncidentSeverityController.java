/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.ehs.controller;

import cn.zhuatech.ehs.common.ApiResponse;
import cn.zhuatech.ehs.service.IncidentSeverityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class IncidentSeverityController {
    private final IncidentSeverityService service;
    public IncidentSeverityController(IncidentSeverityService service) { this.service = service; }
    @PostMapping("/incident-severity")
    public ApiResponse<IncidentSeverityService.Result> assess(@Valid @RequestBody IncidentSeverityService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
