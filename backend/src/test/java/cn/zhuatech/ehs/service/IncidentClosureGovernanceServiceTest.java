/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class IncidentClosureGovernanceServiceTest {
    private final IncidentClosureGovernanceService service = new IncidentClosureGovernanceService();

    @Test void closesFullyGovernedIncident() {
        var result = service.assess(new IncidentClosureGovernanceService.Request(
            "INC-001", true, true, true, true, true, 0, true, true));
        assertThat(result.decision()).isEqualTo(IncidentClosureGovernanceService.Decision.CLOSE);
    }

    @Test void blocksUnsafeOrNoncompliantClosure() {
        var result = service.assess(new IncidentClosureGovernanceService.Request(
            "INC-002", false, false, true, false, false, 2, true, true));
        assertThat(result.decision()).isEqualTo(IncidentClosureGovernanceService.Decision.BLOCKED);
        assertThat(result.blockers()).hasSize(5);
    }

    @Test void reviewsCommunicationAndEffectivenessGaps() {
        var result = service.assess(new IncidentClosureGovernanceService.Request(
            "INC-003", true, true, false, false, true, 0, false, false));
        assertThat(result.decision()).isEqualTo(IncidentClosureGovernanceService.Decision.REVIEW);
        assertThat(result.actions()).hasSize(2);
    }
}
