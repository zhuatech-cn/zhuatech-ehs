/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.repository; import cn.zhuatech.ehs.model.SafetyInspection; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface SafetyInspectionRepository extends JpaRepository<SafetyInspection,Long>{/**
                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                          */
List<SafetyInspection> findAllByOrderByDueDateAsc();/**
                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                              */
List<SafetyInspection> findBySafetyAreaCodeOrderByDueDateAsc(String code);/**
                                                                                                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                        */
long countByStatus(SafetyInspection.Status status);}
