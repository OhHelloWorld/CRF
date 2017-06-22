
##医院数据
INSERT INTO `hospital`(`hospital_name`)VALUES("上海华西医院");
INSERT INTO `hospital`(`hospital_name`)VALUES("上海仁和医院");
INSERT INTO `hospital`(`hospital_name`)VALUES("北京华西医院");
INSERT INTO `hospital`(`hospital_name`)VALUES("北京人和医院");

##系统角色数据
INSERT INTO `sys_role`(`sys_role_name`)VALUES("normal");
INSERT INTO `sys_role`(`sys_role_name`)VALUES("manager");

##系统权限表
##INSERT INTO `sys_permission`(`sys_permission_name`)VALUES(`添加医院`);
##INSERT INTO `sys_permission`(`sys_permission_name`)VALUES(`普通使用`);

##用户数据E
INSERT INTO
 `user`(
 	`real_name`, `user_name`, 
 	`account`, `password`, 
 	`salt`, `hospital_id`, `sys_role_id`)
 VALUES("宋天健", "宋天健", "15285900082", "67175aca5d4817fdacc8275ff0b167c8", "32e750a79391bf38549750388ab16eb8", 1, 1);

 INSERT INTO
 `user`(
 	`real_name`, `user_name`, 
 	`account`, `password`, 
 	`salt`, `hospital_id`, `sys_role_id`)
 VALUES("彭佳慧", "彭佳慧", "15285900083", "c716b5b271b0ec2e4e535aeadf21abed", "8e878508c432c4e19004e648d8fd02b2", 2, 1);

 INSERT INTO
 `user`(
 	`real_name`, `user_name`, 
 	`account`, `password`, 
 	`salt`, `hospital_id`, `sys_role_id`)
 VALUES("贾瑞", "贾瑞", "15285900084", "54e91edb2e7cd4b2ac7036fecd78f26a", "9b9d0688fc12d0ceb0c2b83aeaf3bfac", 3, 1);






##项目角色管理
INSERT INTO `project_role`(`project_role_name`)VALUES("发起人");#1
INSERT INTO `project_role`(`project_role_name`)VALUES("联合发起人");#2
INSERT INTO `project_role`(`project_role_name`)VALUES("数据管理员");#3
INSERT INTO `project_role`(`project_role_name`)VALUES("分中心研究者");#4
INSERT INTO `project_role`(`project_role_name`)VALUES("临床监查员");#5
INSERT INTO `project_role`(`project_role_name`)VALUES("录入员");#6

##项目角色对应的权限
INSERT INTO `project_permission`(`project_permission_name`)VALUES("邀请");#1
INSERT INTO `project_permission`(`project_permission_name`)VALUES("踢出人员");#2
INSERT INTO `project_permission`(`project_permission_name`)VALUES("删除项目");#4
INSERT INTO `project_permission`(`project_permission_name`)VALUES("暂停／打开数据收集");#4
INSERT INTO `project_permission`(`project_permission_name`)VALUES("发布新版本");#5
INSERT INTO `project_permission`(`project_permission_name`)VALUES("编辑项目相关内容");#6
INSERT INTO `project_permission`(`project_permission_name`)VALUES("解锁表单");#7
INSERT INTO `project_permission`(`project_permission_name`)VALUES("完成核查");#8
INSERT INTO `project_permission`(`project_permission_name`)VALUES("完成校验");#9
INSERT INTO `project_permission`(`project_permission_name`)VALUES("保存表单");#10
INSERT INTO `project_permission`(`project_permission_name`)VALUES("提交表单");#11
INSERT INTO `project_permission`(`project_permission_name`)VALUES("修改问题");#12
INSERT INTO `project_permission`(`project_permission_name`)VALUES("查看问题历史");#13
INSERT INTO `project_permission`(`project_permission_name`)VALUES("查看质疑历史");#14
INSERT INTO `project_permission`(`project_permission_name`)VALUES("提出质疑");#15
INSERT INTO `project_permission`(`project_permission_name`)VALUES("对项目参与人员进行工作分配");#16
INSERT INTO `project_permission`(`project_permission_name`)VALUES("回应质疑");#17
INSERT INTO `project_permission`(`project_permission_name`)VALUES("新增案例");#18
INSERT INTO `project_permission`(`project_permission_name`)VALUES("查看所有案例");#19


##项目权限对应的角色
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 1);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 2);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 3);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 4);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 5);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 6);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 7);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 8);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 9);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 10);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 11);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 12);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 13);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 14);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 15);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 16);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 17);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 18);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(1, 19);


INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 1);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 2);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 3);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 4);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 5);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 6);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 7);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 8);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 9);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 10);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 11);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 12);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 13);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 14);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 15);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 16);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 17);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 18);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(2, 19);


INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(3, 16);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(3, 7);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(3, 8);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(3, 13);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(3, 14);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(3, 15);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(3, 17);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(3, 19);

INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(4, 16);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(4, 18);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(4, 10);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(4, 11);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(4, 12);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(4, 13);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(4, 14);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(4, 17);

INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(5, 9);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(5, 13);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(5, 14);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(5, 15);

INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(6, 18);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(6, 10);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(6, 11);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(6, 12);
INSERT INTO `project_role_permission`(`project_role_id`, `project_permission_id`)VALUES(6, 17);













