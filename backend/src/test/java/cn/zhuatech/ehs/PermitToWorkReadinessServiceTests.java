/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs;

import cn.zhuatech.ehs.service.PermitToWorkReadinessService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class PermitToWorkReadinessServiceTests {
    private final PermitToWorkReadinessService service = new PermitToWorkReadinessService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksHighRiskJobWithoutIsolation() {
        var result = service.evaluate(new PermitToWorkReadinessService.Request(
            "JOB-01", true, true, false, 3, 3, true, true, false));
        assertEquals("BLOCK", result.decision());
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void allowsFullyPreparedJob() {
        var result = service.evaluate(new PermitToWorkReadinessService.Request(
            "JOB-02", true, true, true, 4, 4, true, true, false));
        assertEquals("READY", result.decision());
        assertEquals(100, result.readinessScore());
    }
}
