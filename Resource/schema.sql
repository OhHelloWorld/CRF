#患者表
create table patient(
    id int not null auto_increment,
    identifier varchar(50) not null,
    name varchar(20) not null,
    gender varchar(5) not null,
    age int not null,
    height float(5,2) not null,
    weight float(5,2) not null,
    smoke boolean not null,
    drink boolean not null,
    family_history boolean not null,
    hepatitis_diagnosis_time datetime not null,
    cirrhosis_diagnosis_time datetime not null,
    western_medicine_diagnosis varchar(200) not null,
    chinese_medicine_diagnosis varchar(200) not null,
    western_medicine_treatment varchar(200) not null,
    chinese_medicine_treatment varchar(200) not null,
    complete boolean not null,
    primary key(id)
);
#四诊信息表
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
    complete boolean not null,
    primary key(id)
);
#舌脉象表
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
    complete boolean not null,
    primary key(id)
);
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
    complete boolean not null,
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
    Introduction text not null,
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

#模块化生成的信息记录表
create table information(
    id int not null auto_increment,
    information_name varchar(50) not null,
    project_id int not null,
    hospital_id int not null,
    primary key(id)
);

#信息记录表_输入题关联表
create table information_input(
    id int not null auto_increment,
    information_id int not null,
    input_modular_id int not null,
    primary key(id)
);

#信息记录表_文本输入题关联表
create table information_bigInput(
    id int not null auto_increment,
    information_id int not null,
    bigInput_modular_id int not null,
    primary key(id)
);

#信息记录表_单选题关联表
create table information_radio(
    id int not null auto_increment,
    information_id int not null,
    radio_modular_id int not null,
    primary key(id)
);

#信息记录表_多选题关联表
create table information_multiSelect(
    id int not null auto_increment,
    information_id int not null,
    multiSelect_modular_id int not null,
    primary key(id)
);

#信息记录表_日期题关联表
create table information_date(
    id int not null auto_increment,
    information_id int not null,
    date_modular_id int not null,
    primary key(id)
);


#输入题模块表
create table input_modular(
    id int not null auto_increment,
    description varchar(100) not null,
    input_length int,
    input_limit int not null,
    unit varchar(50),
    primary key(id)
);

#文本输入题模块表
create table bigInput_modular(
    id int not null auto_increment,
    description varchar(100) not null,
    bigInput_length int,
    bigInput_limit int not null,
    primary key(id)
);

#单选题模块表
create table radio_modular(
    id int not null auto_increment,
    description varchar(100) not null,
    primary key(id)
);

#多选题模块表
create table multiSelect_modular(
    id int not null auto_increment,
    description varchar(100) not null,
    primary key(id)
);

#日期题模块表
create table date_modular(
    id int not null auto_increment,
    description varchar(100) not null,
    primary key(id)
);

#模块化生成的输入题的用户输入存储表
create table patient_input_modular_entry(
    id int not null auto_increment,
    patient_id int not null,
    information_id int not null,
    input_modular_id int not null,
    input_data varchar(200) not null,
    primary key(id)
);

#模块化生成的文本输入题的用户文本输入存储表
create table patient_bigInput_modular_entry(
    id int not null auto_increment,
    patient_id int not null,
    information_id int not null,
    input_modular_id int not null,
    input_data varchar(255) not null,
    primary key(id)
);

#模块化生成的单选题的用户选择存储表
create table patient_radio_modular_entry(
    id int not null auto_increment,
    patient_id int not null,
    information_id int not null,
    radio_modular_id int not null,
    description varchar(100) not null,
    status boolean,
    primary key(id)
);

#模块化生成的多选题的用户选择存储表
create table patient_multiSelect_modular_entry(
    id int not null auto_increment,
    patient_id int not null,
    information_id int not null,
    radio_modular_id int not null,
    description varchar(100) not null,
    status boolean,
    primary key(id)
);

#模块化生成的日期题的用户输入存储表
create table patient_date_modular_entry(
    id int not null auto_increment,
    patient_id int not null,
    information_id int not null,
    date_modular_id int not null,
    date_data varchar(255) not null,
    primary key(id)
);


#患者_信息记录表 关联表
create table information_patient(
    id int not null auto_increment,
    patient_id int not null,
    information_id int not null,
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

#病例
create table cases(
	id int not null auto_increment,
	case_name varchar(100) not null,
	case_category varchar(100) not null,
	create_time datetime not null,
	project_id int not null,
	hospital_id int not null,
	primary key(id)
)





  