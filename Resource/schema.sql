#理化检查表
create table physical_chemical_inspection(
    id int not null auto_increment,
    patient_id int not null,
    total_bile_acid varchar(20),
    liver_function_albumin varchar(20),
    liver_function_globulin varchar(20),
    liver_function_ALT varchar(20),
    liver_function_AST varchar(20),
    liver_function_GGT varchar(20),
    liver_function_ALP varchar(20),
    liver_function_total_cholesterol varchar(20),
    liver_function_total_bilirubin varchar(20),
    liver_function_direct_bilirubin varchar(20),
    liver_function_Rglobulin varchar(20),
    renal_function_BUN varchar(20),
    renal_function_Cr varchar(20),
    clotting_PT varchar(20),
    clotting_INR varchar(20),
    blood_routine_RBC varchar(20),
    blood_routine_Hb varchar(20),
    blood_routine_WBC varchar(20),
    blood_routine_neutrophils varchar(20),
    blood_routine_lymphocytes varchar(20),
    blood_routine_eosinophils varchar(20),
    blood_routine_platelets varchar(20),
    liver_disease_autoantibodies_AMA varchar(10),
    liver_disease_autoantibodies_AMA_M2 varchar(10),
    liver_disease_autoantibodies_anti_smooth_muscle_antibody varchar(10),
    liver_disease_autoantibodies_liver_kidney_microsomal_antibodies varchar(10),
    liver_disease_autoantibodies_hepatocyte_solute_antigen varchar(10),
    liver_disease_autoantibodies_soluble_liver_pancreatic_antigen varchar(10),
    liver_disease_autoantibodies_other varchar(10),
    ANA_homogeneous varchar(10),
    ANA_particle varchar(10),
    ANA_peripheral varchar(10),
    ANA_nucleolus varchar(10),
    ANA_nucleolus_enhancement varchar(10),
    ANA_nuclear varchar(10),
    ANA_centromere varchar(10),
    ANA_other varchar(10),
    humoral_immunity_IgG varchar(20),
    humoral_immunity_IgA varchar(20),
    humoral_immunity_IgM varchar(20),
    humoral_immunity_immune_complexf varchar(20),
    humoral_immunity_complementC3 varchar(20),
    humoral_immunity_complementC4 varchar(20),
    humoral_immunity_IgE varchar(20),
    humoral_immunity_Klight_chain varchar(20),
    humoral_immunity_Nlight_chain varchar(20),
    cellular_immunity_CD3 varchar(20),
    cellular_immunity_CD4 varchar(20),
    cellular_immunity_CD8 varchar(20),
    cellular_immunity_CD56 varchar(20),
    cellular_immunity_CD2 varchar(20),
    cellular_immunity_CD4_CD8 varchar(20),
    rheumatic_immune_related_antibodies varchar(100),
    CT_MRI int(20),
    liver_hardness_Fibroscan varchar(20),
    liver_hardness_Fibrotest varchar(20),
    liver_puncture_pathology varchar(100),
    copper_protein varchar(20),
    a_f_p varchar(20) ,
    carcinoembryonic_antigenCEA varchar(20),
    ca125 varchar(20),
    hbsag varchar(20),
    hbsab varchar(20),
    hbeag varchar(20),
    hbeab varchar(20),
    hbcab varchar(20),
    hbv_rna varchar(20),
    antiHCVantibody varchar(20),
    hcv_rna varchar(20),
    protein varchar(20),
    red_blood_cell varchar(20),
    white_blood_cell varchar(20),
    bilirubin varchar(20),
    ca199 varchar(20),
    complete boolean default false,
    follow_up boolean,
    follow_up_date datetime,
    image_url varchar(50);
    primary key(id)
);


#肝脏病理学检查
create table liver_pathology(
    id int not null auto_increment,
    patient_id int not null,
    add_date date not null,#添加时间
    pathology_number varchar(50) not null,#医院病理号，可填，默认为病人编号
    inflammation_leaflets int,#小叶内炎症
    interfacial_inflammation int,#界面性炎症
    portal_area_inflammation int,#汇管区炎症
    lymphocyte_plasma_cell_infiltration int,#淋巴细胞浆细胞浸润
    fibrous_tissue_hyperplasia int,#纤维组织增生
    inflammation_bile_duct int,#胆管炎症
    hepatocellular_steatosis int,#肝细胞脂肪变性
    rose_sample int,#玫瑰花结样改变
    HBs_Ag int,#HBsAg染色
    HBc_Ag int,#HBcAg染色
    HCV int,#HCV染色
    other int,#其他
    diagnosis int,#诊断(分期分级)
    remarks text,#备注
    complete boolean default false,#是否完成
    choose boolean,
    primary key(id)
);
#骨密度
create table bone_density(
    id int not null auto_increment,
    patient_id int not null,
    measuring_time date not null,#检测时间
    lumbar_spine float,#腰椎
    lumbar_spine_t int ,#腰椎T值
    femoral_neck float,#股骨颈
    femoral_neck_t int,#股骨颈T值
    big_trochanter float,#大粗隆
    big_trochanter_t int ,#大粗隆T值
    full_hip float,#全髋
    full_hip_t int,#全髋T值
    diagnosis int,#诊断
    remarks varchar(100),#备注
    complete boolean default false,#是否完成
    follow_up boolean,
    follow_up_date datetime,
    primary key(id)
);

#简化AIH诊断
create table simple_AIH(
    id int not null auto_increment,
    patient_id int not null,
    ANA_SMA1 int,#ANA与SMA阴性阳性
    ANA_SMA2 int,#ANA与SMA的比率
    anti_lkm int,#anti-lkm
    anti_sla int,
    IgG int,
    liver int,#肝组织学
    eliminate_viral_hepatitis int,#排除病毒性肝炎
    result int,
    complete boolean default false,
    primary key(id)
);
#治疗前复杂AIH诊断
create table complex_AIH_before_treatment(
    id int not null auto_increment,
    patient_id int not null,
    woman int,#是否为女性
    history_drugs int,#药物史
    ALP_AST int,#ALP（正常上限的倍数）：AST（或ALT）（正常上限的倍数）比值
    alcohol_intake int,#平均酒精摄入量
    serum_globulin_normal int,#血清球蛋白或IgG与正常值的比值
    liver_check int,#肝脏组织学检查
    ANA int,
    other_immune_diseases int,#是否有其他免疫疾病
    AMA_positive int,#AMA阳性
    other_available_parameters int,#其他可用的参数
    hepatitis_virus_markers int,#肝炎病毒标志物
    complete boolean default false,
    primary key(id)
);
#治疗后复杂AIH诊断
create table complex_AIH_after_treatment(
    id int not null auto_increment,
    patient_id int not null,
    woman int,#是否为女性
    history_drugs int,#药物史
    ALP_AST int,#ALP（正常上限的倍数）：AST（或ALT）（正常上限的倍数）比值
    alcohol_intake int,#平均酒精摄入量
    serum_globulin_normal int,#血清球蛋白或IgG与正常值的比值
    liver_check int,#肝脏组织学检查
    ANA int,
    other_immune_diseases int,#是否有其他免疫疾病
    AMA_positive int,#AMA阳性
    other_available_parameters int,#其他可用的参数
    hepatitis_virus_markers int,#肝炎病毒标志物
    response_treatment int,# 治疗后反应
    complete boolean default false,
    primary key(id)
);

#治疗方案
create table treatment_programs(
    id int not null auto_increment,
    patient_id int not null,
    qds_time datetime,
    qds_dose float,
    qds_heal int,
    qdsl_time datetime,
    qdsl_dose float,
    qdsl_heal int,
    jjq_time datetime,
    jjq_dose float,
    jjq_heal int,
    bdnd_time datetime,
    bdnd_dose float,
    bdnd_heal int,
    lcpl_time datetime,
    lcpl_dose float,
    lcpl_heal int,
    mtx_time datetime,
    mtx_dose float,
    mtx_heal int,
    cysa_time datetime,
    cysa_dose float,
    cysa_heal int,
    ctx_time datetime,
    ctx_dose float,
    ctx_heal int,
    mtmk_time datetime,
    mtmk_dose float,
    mtmk_heal int,
    qsxs_time datetime,
    qsxs_dose float,
    qsxs_heal int,
    xqyd_time datetime,
    xqyd_dose float,
    xqyd_heal int,
    fnbt_time datetime,
    fnbt_dose float,
    fnbt_heal int,
    bzbt_time datetime,
    bzbt_dose float,
    bzbt_heal int,
    gyz_time datetime,
    gyz_details varchar(50),
    gyz_result varchar(10),
    gyz_reason varchar(10),
    complete boolean default false,#是否完成
    follow_up boolean,
    follow_up_date datetime,
    primary key(id)
);

#中药方剂，中成药
create table chinese_medicine_prescription(
    id int not null auto_increment,
    patient_id int not null,
    chinese_medicine_time Date,
    chinese_medicine_formulas_dose varchar(50),
    chinese_medicine_heal varchar(20),
    a_proprietary_medicine_time Date,
    a_proprietary_medicine_name varchar(30),
    a_proprietary_medicine_heal varchar(20),
    b_proprietary_medicine_time Date,
    b_proprietary_medicine_name varchar(30),
    b_proprietary_medicine_heal varchar(20),
    complete boolean default false,#是否完成
    follow_up boolean,
    follow_up_date datetime,
    primary key(id)
);

#最后诊断和特殊情况
create table final_diagnosis_special_circumstances(
    id int not null auto_increment,
    patient_id int not null,
    PBC_clinical varchar(50),#PBC临床分期
    AIH_clinical varchar(50),#AIH临床分期
    children boolean not null,
    gestation_period boolean not null,
    repeated_relapse boolean not null,
    resistant_to_steroid_treatment boolean not null,
    patients_with_chronic_hepatitis_b boolean not null,
    patients_with_chronic_hepatitis_c boolean not null,
    overlapping_aihpbc boolean not null,
    overlapping_aihpsc boolean not null,
    autoimmune_cholangitis boolean not null,
    final_diagnosis_other boolean not null,
    complete boolean default false,
    primary key(id)
);

#四诊信息表（带随访）
create table four_diagnostic_information(
    id int not null auto_increment,
    patient_id int not null,
    fatigue int,
    skin_itching int,
    two_eyes_dry int,
    blurred_vision int,
    depression int,
    irritability int,
    insomnia int,
    easy_wake_up int,
    tinnitus int,
    dry_mouth int,
    mouth_pain int,
    bad_breath int,
    nausea int,
    belching int,
    abdominal_distention int,
    flank_pain_stinging int,
    flank_pain_swell int,
    flank_pain_dull int,
    flank_pain_discomfort int,
    anorexia int,
    aphrodisiac_cold int,
    limb int,
    backache_foot_soft int,
    hand_foot_fan_hot int,
    urine_yellow int,
    constipation int,
    loose_stools int,
    perspiration int,
    night_sweats int,
    lower_extremity_edema int,
    face_dull int,
    eye_yellow int,
    body_yellow int,
    spider_nevus int,
    liver_palm int,
    abdominal_veins int,
    yellow_tumor int,
    complete boolean default false,
    follow_up boolean,
    follow_up_date datetime,
    primary key(id)
);

#舌脉象表（带随访）
create table tongue_pulse(
    id int not null auto_increment,
    patient_id int not null,
    tongue varchar(20),
    tongue_part varchar(20),
    tongue_partial_description varchar(20),
    tongue_body varchar(20),
    mossy varchar(20),
    mossy_part varchar(20),
    mossy_partial_description varchar(20),
    tongue_color varchar(20),
    tongue_color_part varchar(20),
    tongue_color_partial_description varchar(20),
    sublingual_varicose_veins varchar(20),
    left_pulse varchar(20),
    right_pulse varchar(20),
    complete boolean default false,
    follow_up boolean,
    follow_up_date datetime,
    primary key(id)
);

#患者表
create table patient(
    id int not null auto_increment,
    identifier varchar(50),
    name varchar(20),
    gender varchar(5),
    height float(5,2),
    weight float(5,2),
    smoke boolean,
    drink boolean,
    family_history varchar(20),
    nation varchar(20),
    birthday datetime,
    bmi int,
    degree_of_education varchar(20),
    first_time_liver_injury datetime,
    investigate_hospital varchar(50),
    telephone varchar(20),
    duration_of_visit varchar(50),
    first_visit_age int,
    first_visit_time datetime,
    smoke_drink_fam_his varchar(50),
    concurrent_auto_disease varchar(50),
    concurrent_auto_date datetime,
    con_auto_dis_first_or_not boolean,
    complete boolean,
    hospital_id long,
    project_id long,
    primary key(id)
);
#用户表
create table user(
    id int not null auto_increment,
    real_name varchar(20) not null,
    account varchar(100) not null,
    password varchar(100) not null,
    salt varchar(255) not null,
    hospital_id int not null,
    sys_role_id int default 1,
    email varchar(100),
    primary key(id)
);
#角色表
create table sys_role(
    id int not null auto_increment,
    sys_role_name varchar(20) not null,
    primary key(id)
);
#角色_权限关联表
create table sys_role_permission(
    id int not null auto_increment,
    sys_role_id int not null,
    sys_permission_id int not null,
    primary key(id)
);
#权限表
create table sys_permission(
    id int not null auto_increment,
    sys_permission_name varchar(50) not null,
    primary key(id)
); 

#项目角色
create table project_role(
    id int not null auto_increment,
    project_role_name varchar(20) not null,
    primary key(id)
);
#角色_权限关联表
create table project_role_permission(
    id int not null auto_increment,
    project_role_id int not null,
    project_permission_id int not null,
    primary key(id)
);
#权限表
create table project_permission(
    id int not null auto_increment,
    project_permission_name varchar(50) not null,
    primary key(id)
); 

#项目表
create table project(
    id int not null auto_increment,
    project_name varchar(50) not null,
    organizer varchar(30) not null,
    create_time datetime not null,
    introduction text not null,
    is_collect boolean default true,
    primary key(id)
);
#医院表
create table hospital(
    id int not null auto_increment,
    hospital_name varchar(50) not null,
    address varchar(255) not null,
    address_detail varchar(255) not null,
    telephone varchar(30) not null,
    special_major varchar(100) not null,
    manage_range varchar(100) not null,
    introduction text,
    image_url varchar(255) not null,
    primary key(id)
);
#用户_医院关联表
create table user_hospital(
    id int not null auto_increment,
    user_id int not null,
    hospital_id int not null,
    primary key(id)
);
#项目_医院关联表
create table project_hospital(
    project_id int not null,
    hospital_id int not null
);
#用户_项目_角色三方关联表
create table user_project_role(
    id int not null auto_increment,
    user_id int not null,
    project_id int not null,
    project_role_id int not null,
    accept boolean,
    primary key(id)
);

#信息表
create table message (
	id int not null auto_increment,
	content text not null,
	received_user_id int not null,
	readed boolean default false,
	primary key(id)
);

#ishak评分
create table ishak(
    id int not null auto_increment,
    patient_id int,
    add_date date,
    portal_area_inflammation int,#门脉区炎症
    lobular_mobility int,#小叶内活动度
    interface_inflammation int,#界面炎
    confluent_necrosis int,#融合性坏死
    fibrosis int,#纤维化评分
    choose boolean,
    complete boolean,
    primary key(id)
);

#HAI评分
create table hai(
    id int not null auto_increment,
    add_date date,
    patient_id int,
    portal_area_inflammation int,#门脉区炎症
    lobular_mobility int,#小叶内活动度
    interface_inflammation int,#界面炎
    choose boolean,
    complete boolean,
    primary key(id)
);





  