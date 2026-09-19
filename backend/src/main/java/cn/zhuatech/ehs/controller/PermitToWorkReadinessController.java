/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.controller;

import cn.zhuatech.ehs.common.ApiResponse;
import cn.zhuatech.ehs.service.PermitToWorkReadinessService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/ehs/insights")
public class PermitToWorkReadinessController {
    private final PermitToWorkReadinessService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public PermitToWorkReadinessController(PermitToWorkReadinessService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/permit-to-work-readiness")
    public ApiResponse<PermitToWorkReadinessService.Result> evaluate(
        @Valid @RequestBody PermitToWorkReadinessService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
