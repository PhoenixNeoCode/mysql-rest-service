CREATE TABLE IF NOT EXISTS `temperature` (
  `id` int(11) NOT NULL,
  `temperature` double NOT NULL,
  `date_time` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

ALTER TABLE `temperature`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `temperature`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;

