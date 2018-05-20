DELIMITER $$

CREATE 
	TRIGGER trg_insere_financeiro
	AFTER INSERT
	ON ordem_servico
	FOR EACH ROW
BEGIN
 INSERT INTO financeiro 
( vlr_docto, 
observacao, 
cliente_codigo, 
    documento,
    dt_vecto,
    status, 
    tipo_documento,
    tela)
VALUES (
NEW.vlr_total,
NEW.os_id,
NEW.cliente_codigo,
   SYSDATE()+0,
  current_date(),
  'Aberto',
  'Conta a receber',
  'Ordem de Servico');

END$$
DELIMITER;