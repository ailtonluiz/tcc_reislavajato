ALTER TABLE `lavajato`.`cargo_aud` 
CHANGE COLUMN `cargo_aud_id` `cargo_aud_id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `lavajato`.`financeiro_aud` 
CHANGE COLUMN `financeiro_aud_id` `financeiro_aud_id` BIGINT(20) NOT NULL AUTO_INCREMENT ;


ALTER TABLE `lavajato`.`ordem_servico_aud` 
CHANGE COLUMN `ordem_servico_aud_id` `ordem_servico_aud_id` BIGINT(20) NOT NULL AUTO_INCREMENT ;


ALTER TABLE `lavajato`.`servico_aud` 
CHANGE COLUMN `servico_aud_id` `servico_aud_id` BIGINT(20) NOT NULL AUTO_INCREMENT ;


ALTER TABLE `lavajato`.`cliente_aud` 
CHANGE COLUMN `cliente_aud_id` `cliente_aud_id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `lavajato`.`comissao` 
CHANGE COLUMN `comissao_id` `comissao_id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

