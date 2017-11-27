package br.com.reislavajato.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReisLavajatoUtil {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static boolean ehVazio(String valor) {
		return valor == null || valor.trim().length() == 0;
	}

	public static String formatarData(Date data) {
		if (data != null) {
			return sdf.format(data);
		} else {
			return "";
		}
	}

	public static Date adicionarDias(Date data, int dias) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DATE, dias);
		return cal.getTime();
	}

	public static HttpSession getSession() {
		return (HttpSession) ReisLavajatoUtil.getRequest().getSession(true);
	}

	public static HttpServletRequest getRequest() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();
		return (HttpServletRequest) ec.getRequest();
	}

	public static HttpServletResponse getResponse() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();
		return (HttpServletResponse) ec.getResponse();
	}

	public static String recuperaDiretorioRaiz() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		ServletContext ctx = (ServletContext) externalContext.getContext();
		return ctx.getRealPath("/");
	}

	public static void gerarRelatorioFaces(String caminhoRelatorio, @SuppressWarnings("rawtypes") Collection dados,
			Map parametros) throws IOException, JRException {
		FacesContext context = FacesContext.getCurrentInstance();
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dados);
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		String nomePdf = caminhoRelatorio.substring(7);
		response.setContentType("application/pdf");
		response.addHeader("Content-disposition", "inline; filename=\"" + nomePdf.replace("jasper", "pdf"));
		ServletOutputStream out = response.getOutputStream();
		InputStream streamRelatorio = context.getExternalContext().getResourceAsStream(caminhoRelatorio);
		@SuppressWarnings("unchecked")
		JasperPrint impressao = JasperFillManager.fillReport(streamRelatorio, parametros, dataSource);
		JasperExportManager.exportReportToPdfStream(impressao, out);
		out.close();
		context.responseComplete();
	}

}
