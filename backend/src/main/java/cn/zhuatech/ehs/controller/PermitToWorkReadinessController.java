/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.ehs.controller;

import cn.zhuatech.ehs.common.ApiResponse;
import cn.zhuatech.ehs.service.PermitToWorkReadinessService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ehs/insights")
public class PermitToWorkReadinessController {
    private final PermitToWorkReadinessService service;
    public PermitToWorkReadinessController(PermitToWorkReadinessService service) { this.service = service; }
    @PostMapping("/permit-to-work-readiness")
    public ApiResponse<PermitToWorkReadinessService.Result> evaluate(
        @Valid @RequestBody PermitToWorkReadinessService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
