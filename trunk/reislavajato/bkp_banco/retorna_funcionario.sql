CREATE VIEW RETORNA_FUNCIONARIO AS
SELECT
  `f`.`funcionario_id` AS `funcionario_id`,
  `pf`.`nome` AS `nome`
FROM ((`funcionario` `f`
  JOIN `pessoa` `p`)
  JOIN `pessoa_fisica` `pf`)
WHERE ((`f`.`pessoa_pessoa_id` = `p`.`pessoa_id`)
AND (`pf`.`pessoa_fisica_id` = `p`.`pessoaFisica_pessoa_fisica_id`))