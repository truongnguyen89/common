USE football;
ALTER TABLE `stadium`
  ADD COLUMN `n_area_id` BIGINT NOT NULL DEFAULT 1 AFTER `s_phone`,
  ADD CONSTRAINT `stadium_area_fk` FOREIGN KEY (`n_area_id`) REFERENCES `area` (`n_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;