DELIMITER $$

CREATE TRIGGER trg_aud_financeiro_delete
BEFORE DELETE ON financeiro
FOR EACH ROW BEGIN
INSERT INTO financeiro_aud 
SET processo_operacao = 'Exclusão',
vlr_docto = OLD.vlr_docto,
observacao = OLD.observacao,
cliente_codigo =  OLD.cliente_codigo,
documento =  OLD.documento,
dt_vecto = OLD.dt_vecto,
status =  OLD.status,
tela = 'Tela Exclusão',
dt_baixa = OLD.dt_baixa,
tipo_documento = OLD.tipo_documento,
usuario_operacao = 'Administrador',
dt_operacao = NOW();

END$$

DELIMITER;
