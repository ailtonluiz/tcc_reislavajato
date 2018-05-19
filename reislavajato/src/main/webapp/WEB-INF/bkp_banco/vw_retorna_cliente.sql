CREATE VIEW RETORNA_CLIENTE AS 
SELECT
  `pf`.`nome` AS `nome`,
  `c`.`codigo` AS `codigo`
FROM ((`cliente` `c`
  JOIN `pessoa` `p`)
  JOIN `pessoa_fisica` `pf`)
WHERE ((`c`.`pessoa_pessoa_id` = `p`.`pessoa_id`)
AND (`pf`.`pessoa_fisica_id` = `p`.`pessoaFisica_pessoa_fisica_id`))