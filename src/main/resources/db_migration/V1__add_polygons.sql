-- ----------------------------
-- Table structure for `t_polygons`
-- ----------------------------
DROP TABLE IF EXISTS `t_polygons`;
CREATE TABLE `t_polygons` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `provider_id` bigint(64) ,
   `P` NUMERIC(20,10) NULL,
   `Q` NUMERIC(20,10) NULL,
   `lat` NUMERIC(20,10) NULL,
   `lng` NUMERIC(20,10) NULL,
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1440 DEFAULT CHARSET=utf8;