DELIMITER $$
CREATE TRIGGER trg_aud_ordem_servico_update
BEFORE UPDATE ON ordem_servico
FOR EACH ROW BEGIN
INSERT INTO ordem_servico_aud
SET processo_operacao = 'Altera��o',
obs_os = OLD.obs_os,
os_id = OLD.os_id,
vlr_total = OLD.vlr_total,
pct_desconto = OLD.pct_desconto,
cliente_codigo = OLD.cliente_codigo,
status_servico = OLD.status_servico,
usuario_operacao = 'Administrador',
tela = 'Tela Altera��o',
dt_operacao = NOW(); END$$
DELIMITER ;
