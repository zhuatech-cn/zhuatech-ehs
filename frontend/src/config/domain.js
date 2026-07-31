/* Copyright 2026 上海如静知华信息科技有限公司 */
export const domain={
 code:'EHS',systemName:'环境、健康与安全管理系统',englishName:'ENVIRONMENT HEALTH AND SAFETY',
 theme:{primary:'#277055',dark:'#183c30',accent:'#c4862b'},
 workspace:'EHS 中心 / 安全区域运营',fieldWorkspace:'装配车间',period:'2026-08-01 · 周六',liveText:'风险控制数据链路正常',
 fieldContextLabel:'当前安全区域',fieldContext:'日班 · 08:30—17:30',fieldUser:'陆承',fieldRole:'安全员',adminUser:'周妍',adminRole:'安全区域主管',
 adminTitle:'安全区域运营驾驶舱',adminBreadcrumb:'安全区域运营 / 今日态势',adminSubtitle:'集中查看巡检登记、巡检、复盘、风险控制与时限风险。',exportAction:'导出巡检日报',createAction:'新建安全巡检',
 chartTitle:'巡检完成趋势',chartSubtitle:'当日累计完成率 / 计划目标',chartLabels:['08:30','09:30','10:30','11:30','13:30','14:30','15:30','16:30','17:30'],loadTitle:'安全区域负荷',loadSubtitle:'进行中巡检占可用能力',recordsTitle:'进行中巡检',recordsSubtitle:'按承诺时限与异常优先显示',issueTitle:'安全与整改风险',issueSubtitle:'需要安全区域主管处理的事项',
 recordName:'安全巡检',itemName:'作业点 / 项目',unitName:'安全区域',batchName:'作业批次',planName:'计划项目',doneName:'已完成',exceptionName:'异常',unitLabel:'项',
 listBreadcrumb:'巡检管理 / 任务台账',listSubtitle:'统一管理巡检登记、任务分派、巡检、复盘与整改归档。',listSummary:[['今日计划巡检','38'],['进行中巡检','17'],['待复核','8'],['超时风险','2',true]],tabs:['全部','待确认','巡检中','待复核','已完成'],
 fieldBreadcrumb:'巡检执行 / 我的工作台',fieldTitle:'现场安全工作台',fieldSubtitle:'当前 7 项进行中巡检 · 2 项控制措施待确认 · 安全员陆承',fieldSecondary:'交接记录',reportAction:'录入结果',fieldNoticeTitle:'作业条件符合要求',fieldNotice:'作业许可、PPE 与隔离措施均已核验',
 steps:['巡检登记确认','作业前确认','现场巡检','整改复核','整改归档'],documentAction:'查看安全制度',printAction:'打印作业点标签',resourceCardTitle:'风险控制状态',resourceValueLabel:'风险值',resourceHealthLabel:'措施有效率',quickSubtitle:'安全区域高频业务入口',quickActions:[['结果录入','/shopfloor/report','检查项与整改结果'],['作业点流转','/shopfloor/material','隐患位置与整改责任'],['控制确认','/shopfloor/resources','控制清单与确认记录'],['事件上报','/shopfloor/andon','隐患、未遂事件与事故']],
 reportDefaults:[3,0],reportTitle:'巡检结论录入',reportSubtitle:'记录原始结果、异常数量和巡检过程备注。',reportSuccess:'巡检结论已保存并进入复盘队列',reportPlaceholder:'填写现场现象、临时措施或整改建议',reportFootnote:'提交后写入原始记录并生成整改轨迹',ruleTitle:'制度控制要求',ruleSubtitle:'EHS-CHEM-12 · V4.3',rules:[['作业许可','有效'],['PPE 配备率','100%'],['能量隔离','已确认'],['控制措施','有效',true]],fieldTotals:[['16','已完成项目'],['1','异常结果'],['5','待复核结果'],['98.2%','巡检记录完整率']],
 adminMenus:[['/admin','home','运营驾驶舱'],['/admin/work-orders','order','安全巡检'],['/admin/samples','box','作业点管理'],['/admin/schedule','calendar','排班预约'],['/admin/methods','process','制度与标准'],['/admin/reviews','quality','整改复核'],['/admin/resources','machine','风险控制'],['/admin/report','chart','安全分析']],
 fieldMenus:[['/shopfloor','home','我的工作台'],['/shopfloor/report','report','结果录入'],['/shopfloor/tasks','order','待检任务'],['/shopfloor/material','box','作业点流转'],['/shopfloor/resources','machine','控制确认'],['/shopfloor/andon','risk','事件上报',1]],
 moduleTitles:{tasks:['待检任务','查看任务优先级、作业点状态与承诺时限'],material:['作业点流转','跟踪接收、分样、留样与销毁全过程'],resources:['控制确认','管理风险控制档期、校准和使用记录'],andon:['事件上报','登记并跟踪 OOS、OOT 与环境事件'],samples:['作业点管理','管理作业点登记、标签、位置和生命周期'],schedule:['排班预约','协调人员、风险控制和制度的可用时间'],methods:['制度与标准','维护安全制度、限度和标准物质'],reviews:['整改复核','执行措施复核、整改记录批准和电子签名'],report:['安全分析','分析周转时间、一次通过率和事件趋势']},
 tagline:'让每一份巡检结论都有完整整改记录链',storyTitle:'从巡检登记到整改记录，<br/>每个结果都可复盘、可追溯。',storyText:'连接作业点、制度、风险控制、人员与原始数据的安全区域数字底座。',pattern:[2,3,8,9,10,15,16,17,22,23,24,29,30,17],loginStats:[['98.2%','巡检记录完整率'],['17','当前进行中巡检'],['1.4 天','平均整改周期']],loginTitle:'安全区域EHS 中心',adminDemo:'巡检 / 隐患 / 整改',fieldDemo:'巡检 / 结果 / 事件'
}
export const records=[
 {no:'INS-260801-018',name:'高处作业专项巡检',code:'EHS-WAH-08',unit:'动力站房',group:'EHS 中心',plan:24,done:16,exception:1,due:'08-02',batch:'A区-03',status:'巡检中',progress:67,priority:'加急'},
 {no:'INS-260801-021',name:'危化品仓库日常巡检',code:'EHS-CHEM-12',unit:'装配车间',group:'EHS 中心',plan:18,done:8,exception:0,due:'08-02',batch:'C库-02',status:'巡检中',progress:44,priority:'正常'},
 {no:'INS-260802-006',name:'配电室季度检查',code:'EHS-POWER-04',unit:'仓储物流区',group:'研发中心',plan:12,done:0,exception:0,due:'08-04',batch:'配电-01',status:'待确认',progress:0,priority:'正常'},
 {no:'INS-260717-015',name:'叉车作业安全检查',code:'EHS-FORK-09',unit:'装配车间',group:'EHS 中心',plan:20,done:20,exception:1,due:'08-01',batch:'物流-05',status:'已完成',progress:100,priority:'正常'},
 {no:'INS-260801-024',name:'承包商入场检查',code:'EHS-VENDOR-06',unit:'装配车间',group:'EHS 中心',plan:15,done:10,exception:0,due:'08-03',batch:'施工-07',status:'待复核',progress:67,priority:'关注'}]
export const resources=[{code:'HZD-WAH-03',name:'高处作业隔离措施',unit:'装配车间',status:'运行',health:88,value:'2',valueUnit:'级',note:'隔离措施 8 项 · 已确认 8 项'},{code:'HZD-UTM-05',name:'配电室联锁保护',unit:'动力站房',status:'运行',health:91,value:'96',valueUnit:'%',note:'联锁试验有效至 2026-10'},{code:'HZD-INC-08',name:'叉车人车分流控制',unit:'仓储物流区',status:'报警',health:62,value:'4',valueUnit:'级',note:'人车分流警示标识待补充'}]
export const reviews=[{no:'REV-260801-032',title:'高处作业许可复核',type:'整改复核',detail:'12 个检查点 · 周妍',result:'通过'},{no:'REV-260801-011',title:'危化品库能量隔离复盘',type:'措施复核',detail:'18 个检查项 · 顾清',result:'待确认'},{no:'REV-260717-018',title:'叉车通道未遂事件调查',type:'事件评审',detail:'INC-260717-02',result:'异常'}]
export const adminMetrics=[['今日计划巡检','38','较昨日增加 8 份','blue'],['按时完成率','96.8%','目标值 ≥ 95.0%','green'],['待复核结果','8','其中 2 项加急','orange'],['事件 / OOS','2','1 项进入调查','red']]
export const fieldMetrics=[['今日任务','7','18 个巡检事项','blue'],['已完成','16','当前进度 67%','green'],['待复核','5','数据已完整提交','orange'],['风险控制档期','本班次有效','高处作业控制','slate']]
export const chartActual=[8,18,29,42,49,61,72,84,91],chartTarget=[10,21,32,43,38,65,76,87,98]
export const loads=[['装配车间',92,'12 项在检'],['动力站房',78,'8 项在检'],['仓储物流区',71,'6 项在检'],['实验研发区',56,'5 项在检']]
export const issues=[{type:'风险控制',title:'危化品库通风监测中断',detail:'HZD-INC-08 · 持续 12 分钟',status:'调查中'},{type:'结果',title:'叉车通道出现人员闯入',detail:'INC-260717-02 · 等待责任人确认',status:'待判定'},{type:'时限',title:'承包商动火票即将到期',detail:'剩余 90 分钟',status:'协调中'}]
