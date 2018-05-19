CREATE VIEW RETONAR_COMISSAO AS 
SELECT
  ROUND(((`os`.`vlr_total` * `om`.`pct_comissao`) / 100), 2) AS `vlr_comissao`
FROM (`ordem_servico` `os`
  JOIN `ordem_servico_movimento` `om`)
WHERE (`os`.`os_id` = `om`.`os_id`)