DELIMITER $$
CREATE TRIGGER trg_aud_ordem_servico_delete
BEFORE DELETE ON ordem_servico
FOR EACH ROW BEGIN
INSERT INTO ordem_servico_aud
SET processo_operacao = 'Exclus�o',
obs_os = OLD.obs_os,
os_id = OLD.os_id,
vlr_total = OLD.vlr_total,
pct_desconto = OLD.pct_desconto,
obs_os = OLD.obs_os,
usuario_operacao = 'Administrador',
tela = 'Tela Exclus�o',
dt_operacao = NOW(); END$$
DELIMITER ;
