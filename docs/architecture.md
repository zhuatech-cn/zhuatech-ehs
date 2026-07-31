# Ehs 架构

版权所有 © 2026 上海如静知华信息科技有限公司。

浏览器通过 Vue 管理端或安全员端访问 Spring Boot REST API。安全层完成 JWT 与角色鉴权，业务层负责安全巡检、作业点、风险控制、复盘和结果记录，JPA/Flyway 管理 MySQL 数据。

管理端角色为 `EHS_MANAGER`、`QUALITY`、`ADMIN`；执行端角色为 `SAFETY_OFFICER`。正式部署建议将风险控制连接置于独立采集服务，并隔离安全区域网络和办公网络。
