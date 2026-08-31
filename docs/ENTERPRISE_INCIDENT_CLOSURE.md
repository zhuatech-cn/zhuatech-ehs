# 企业级事故事件结案治理

[知华科技（上海如静知华信息科技有限公司）](https://www.zhuatech.cn/)为 EHS 开源版增加事故结案门禁。

`POST /api/enterprise/ehs/incident-closure-governance` 检查现场遏制、证据保全、监管报告、根因批准、关键整改、员工沟通和有效性验证，返回 `CLOSE / REVIEW / BLOCKED`。

生产使用时应根据所在地法律法规配置报告时限与分级要求，并将调查证据和审批轨迹纳入受控档案。
