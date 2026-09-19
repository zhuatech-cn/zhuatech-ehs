/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class IncidentClosureGovernanceServiceTest {
    private final IncidentClosureGovernanceService service = new IncidentClosureGovernanceService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void closesFullyGovernedIncident() {
        var result = service.assess(new IncidentClosureGovernanceService.Request(
            "INC-001", true, true, true, true, true, 0, true, true));
        assertThat(result.decision()).isEqualTo(IncidentClosureGovernanceService.Decision.CLOSE);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUnsafeOrNoncompliantClosure() {
        var result = service.assess(new IncidentClosureGovernanceService.Request(
            "INC-002", false, false, true, false, false, 2, true, true));
        assertThat(result.decision()).isEqualTo(IncidentClosureGovernanceService.Decision.BLOCKED);
        assertThat(result.blockers()).hasSize(5);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void reviewsCommunicationAndEffectivenessGaps() {
        var result = service.assess(new IncidentClosureGovernanceService.Request(
            "INC-003", true, true, false, false, true, 0, false, false));
        assertThat(result.decision()).isEqualTo(IncidentClosureGovernanceService.Decision.REVIEW);
        assertThat(result.actions()).hasSize(2);
    }
}
