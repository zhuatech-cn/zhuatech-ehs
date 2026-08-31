/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.controller;

import cn.zhuatech.ehs.common.ApiResponse;
import cn.zhuatech.ehs.service.IncidentClosureGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/ehs")
public class IncidentClosureGovernanceController {
    private final IncidentClosureGovernanceService service;
    public IncidentClosureGovernanceController(IncidentClosureGovernanceService service) { this.service = service; }

    @PostMapping("/incident-closure-governance")
    public ApiResponse<IncidentClosureGovernanceService.Assessment> assess(
        @Valid @RequestBody IncidentClosureGovernanceService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
