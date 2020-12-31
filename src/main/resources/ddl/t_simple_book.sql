CREATE TABLE `t_simple_book` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '文章标题',
  `user` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '用户名',
  `image_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '用户头像',
  `user_home` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '用户主页地址',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;