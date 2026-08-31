/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentClosureGovernanceService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.siteContained()) blockers.add("事故现场与持续风险尚未得到控制");
        if (!request.evidencePreserved()) blockers.add("现场证据与原始记录未完整保全");
        if (request.regulatoryNotificationRequired() && !request.regulatoryNotificationCompleted()) blockers.add("法定监管报告尚未完成");
        if (!request.rootCauseApproved()) blockers.add("根因分析尚未批准");
        if (request.openCriticalCorrectiveActions() > 0) blockers.add("存在未关闭的关键纠正措施");
        if (!blockers.isEmpty()) {
            actions.add("禁止结案，完成遏制、报告、根因和关键整改后复核");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.workerCommunicationCompleted() || !request.effectivenessVerified()) {
            if (!request.workerCommunicationCompleted()) actions.add("向相关员工传达经验教训与控制变化");
            if (!request.effectivenessVerified()) actions.add("验证纠正措施有效性并留存证据");
            return new Assessment(Decision.REVIEW, blockers, actions);
        }
        actions.add("批准结案并归档事故、根因、整改和验证证据");
        return new Assessment(Decision.CLOSE, blockers, actions);
    }

    public record Request(@NotBlank String incidentNo, boolean siteContained,
                          boolean evidencePreserved, boolean regulatoryNotificationRequired,
                          boolean regulatoryNotificationCompleted, boolean rootCauseApproved,
                          @Min(0) int openCriticalCorrectiveActions,
                          boolean workerCommunicationCompleted, boolean effectivenessVerified) {}
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    public enum Decision { CLOSE, REVIEW, BLOCKED }
}
