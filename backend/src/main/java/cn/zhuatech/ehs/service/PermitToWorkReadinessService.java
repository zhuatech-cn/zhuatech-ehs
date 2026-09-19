/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.ehs.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class PermitToWorkReadinessService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Result evaluate(Request request) {
        int score = 100;
        if (!request.permitApproved()) score -= 35;
        if (request.highRiskWork() && !request.gasTestValid()) score -= 25;
        if (request.highRiskWork() && !request.lockoutTagoutReady()) score -= 25;
        if (request.trainedWorkers() < request.requiredWorkers()) score -= 20;
        if (!request.emergencyPlanReady()) score -= 15;
        if (request.simultaneousOperations()) score -= 10;
        score = Math.max(0, score);
        boolean hardBlock = !request.permitApproved()
            || request.highRiskWork() && (!request.gasTestValid() || !request.lockoutTagoutReady());
        String decision = hardBlock ? "BLOCK" : score < 80 ? "PREPARE" : "READY";
        List<String> actions = new ArrayList<>();
        if (!request.permitApproved()) actions.add("完成作业许可审批与现场负责人签字");
        if (!request.gasTestValid() && request.highRiskWork()) actions.add("重新执行气体检测并记录有效时间");
        if (!request.lockoutTagoutReady() && request.highRiskWork()) actions.add("完成能源隔离与上锁挂牌验证");
        if (request.trainedWorkers() < request.requiredWorkers()) actions.add("补齐具备资质的作业人员");
        if (actions.isEmpty()) actions.add("允许开工并执行班前安全交底");
        return new Result(request.jobNo(), score, decision, actions);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String jobNo, boolean highRiskWork,
                          boolean gasTestValid, boolean lockoutTagoutReady,
                          @Min(0) int trainedWorkers, @Min(1) int requiredWorkers,
                          boolean permitApproved, boolean emergencyPlanReady,
                          boolean simultaneousOperations) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Result(String jobNo, int readinessScore, String decision, List<String> actions) {}
}
