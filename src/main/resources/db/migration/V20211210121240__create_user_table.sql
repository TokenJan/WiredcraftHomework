CREATE TABLE `t_user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name` varchar(255) NOT NULL COMMENT '姓名',
    `address` varchar(255) NULL COMMENT '地址',
    `description` varchar(255) NULL COMMENT '描述',
    `date_of_birth` date NULL COMMENT '生日',
    `created_at` datetime NOT NULL COMMENT '创建时间',
    `updated_at` datetime NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
);
