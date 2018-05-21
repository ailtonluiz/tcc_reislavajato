CREATE 
	DEFINER = 'reislavajato'@'%'
TRIGGER lavajato.trg_insere_comissao_movimento
	AFTER INSERT
	ON lavajato.ordem_servico_movimento
	FOR EACH ROW
BEGIN
 INSERT INTO comissao ( cliente_id,
						     os_id, 
                             vlr_comissao)
VALUES (
NEW.funcionario_id,
NEW.os_id,
NEW.vlr_unitario = (SELECT 
        ROUND(((`os`.`vlr_total` * `om`.`pct_comissao`) / 100),
                2)
    FROM
        (`ordem_servico` `os`
        JOIN `ordem_servico_movimento` `om`)
    WHERE
        (`os`.`os_id` = `om`.`os_id`)));
   
  
END