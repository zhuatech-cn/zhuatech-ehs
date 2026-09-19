/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.controller; import cn.zhuatech.ehs.common.ApiResponse; import cn.zhuatech.ehs.dto.EhsDto.*; import cn.zhuatech.ehs.service.EhsService; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin") @PreAuthorize("hasAnyRole('EHS_MANAGER','QUALITY','ADMIN')") public class EhsAdminController {private final EhsService service;/**
                                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                              */
public EhsAdminController(EhsService service){this.service=service;}/**
                                                                                                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                  */
@GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(service.adminDashboard());}/**
                                                                                                                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                       */
@GetMapping("/work-orders") public ApiResponse<List<SafetyInspectionView>> orders(){return ApiResponse.ok(service.safetyInspections());}}
