DROP TABLE IF EXISTS `app_registry`;

CREATE TABLE `app_registry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) DEFAULT NULL,
  `registry_key` varchar(255) DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_datetime` datetime DEFAULT NULL,
  `last_updated_datetime` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;