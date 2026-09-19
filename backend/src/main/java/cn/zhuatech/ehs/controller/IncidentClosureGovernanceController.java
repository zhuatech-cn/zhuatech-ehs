/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.controller;

import cn.zhuatech.ehs.common.ApiResponse;
import cn.zhuatech.ehs.service.IncidentClosureGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/ehs")
public class IncidentClosureGovernanceController {
    private final IncidentClosureGovernanceService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public IncidentClosureGovernanceController(IncidentClosureGovernanceService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/incident-closure-governance")
    public ApiResponse<IncidentClosureGovernanceService.Assessment> assess(
        @Valid @RequestBody IncidentClosureGovernanceService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
