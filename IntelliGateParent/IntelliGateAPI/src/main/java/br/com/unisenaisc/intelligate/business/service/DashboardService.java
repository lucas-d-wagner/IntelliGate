package br.com.unisenaisc.intelligate.business.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import br.com.unisenaisc.intelligate.business.repository.LogAcessoRepository;
import br.com.unisenaisc.intelligate.common.api.bean.DashboardDataBean;
import br.com.unisenaisc.intelligate.common.api.bean.DashboardFilterBean;
import br.com.unisenaisc.intelligate.common.api.bean.VeiculoLogAcessoBean;
import br.com.unisenaisc.intelligate.common.api.bean.VeiculosPorDataBean;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;
import br.com.unisenaisc.intelligate.common.util.SystemProperties;
import br.com.unisenaisc.intelligate.model.entity.LogAcesso;

@ManagedBean
public class DashboardService {

	private final BigDecimal CEM = new BigDecimal(100);
	
	@Inject
	private LogAcessoRepository logAcessoRepository;
	
	public DashboardDataBean getDataWithFilter(DashboardFilterBean filter) throws BusinessCheckedException {
		DashboardDataBean dashboardDataBean = new DashboardDataBean();
		
		List<LogAcesso> acessosDeHoje = buscarAcessosDeHoje();
		List<LogAcesso> acessosDeHojeAindaAcessados = apenasAindaAcessados(acessosDeHoje);
		
		List<LogAcesso> acessosPorMes = buscarAcessosMesReferencia(filter.getDataConsulta());
		
		Long totalCarros = getNroCarros(acessosDeHoje);
		Long totalMotos = getNroMotos(acessosDeHoje);
		
		Long nroCarrosAcessados = getNroCarros(acessosDeHojeAindaAcessados);
		Long nroMotosAcessados = getNroMotos(acessosDeHojeAindaAcessados);
		
		BigDecimal taxaOcupacaoCarros = getTaxaOcupacaoCarros(new BigDecimal(nroCarrosAcessados));
		BigDecimal taxaOcupacaoMotos = getTaxaOcupacaoMotos(new BigDecimal(nroMotosAcessados));
		
		Long totalCarrosPeriodo = getNroCarros(acessosPorMes);
		Long totalMotosPeriodo = getNroMotos(acessosPorMes);
		
		Long tempoMediaPermanenciaCarros = getTempoMediaPermanenciaCarros(acessosPorMes);
		Long tempoMediaPermanenciaMotos = getTempoMediaPermanenciaMotos(acessosPorMes);
		
		List<VeiculoLogAcessoBean> veiculosAcessados = convertToBean(acessosDeHojeAindaAcessados);
		
		List<VeiculosPorDataBean> veiculosPorDataList = getVeiculosPorData(acessosPorMes, filter.getDataConsulta());
		
		dashboardDataBean.setTotalCarros(totalCarros);
		dashboardDataBean.setTotalMotos(totalMotos);
		dashboardDataBean.setNroCarrosAcessados(nroCarrosAcessados);
		dashboardDataBean.setNroMotosAcessados(nroMotosAcessados);
		dashboardDataBean.setTaxaOcupacaoCarros(taxaOcupacaoCarros);
		dashboardDataBean.setTaxaOcupacaoMotos(taxaOcupacaoMotos);
		
		dashboardDataBean.setTotalCarrosPeriodo(totalCarrosPeriodo);
		dashboardDataBean.setTotalMotosPeriodo(totalMotosPeriodo);
		dashboardDataBean.setTempoMedioOcupacaoPeriodoCarros(tempoMediaPermanenciaCarros);
		dashboardDataBean.setTempoMedioOcupacaoPeriodoMotos(tempoMediaPermanenciaMotos);

		dashboardDataBean.setVeiculosAcessados(veiculosAcessados);
		
		dashboardDataBean.setVeiculosPorDataList(veiculosPorDataList);
		
		return dashboardDataBean;
	}
	
	private List<LogAcesso> buscarAcessosDeHoje() {
        Calendar calendar = Calendar.getInstance();
		
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dataInicio = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date dataFim = calendar.getTime();
        
        return logAcessoRepository.findWithInterval(dataInicio, dataFim);
	}
	
	private List<LogAcesso> apenasAindaAcessados(List<LogAcesso> acessos) {
		return notNull(acessos).stream().filter(l -> l.getDataHoraSaida() == null).collect(Collectors.toList());
	}
	
	private List<LogAcesso> buscarAcessosMesReferencia(Date mesReferencia) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mesReferencia);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dataInicio = calendar.getTime();

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date dataFim = calendar.getTime();
        
		return logAcessoRepository.findWithInterval(dataInicio, dataFim);
	}
	
	private Long getNroCarros(List<LogAcesso> acessos) {
		return notNull(acessos).stream().filter(l -> l.getVeiculo().isCarro()).count();
	}
	
	private Long getNroMotos(List<LogAcesso> acessos) {
		return notNull(acessos).stream().filter(l -> l.getVeiculo().isMoto()).count();
	}
	
	private BigDecimal getTaxaOcupacaoCarros(BigDecimal nroCarrosAcessados) {
		BigDecimal lotacaoMaximaCarros = SystemProperties.getLotacaoMaximaCarros();
		return nroCarrosAcessados.multiply(CEM).divide(lotacaoMaximaCarros, 1, RoundingMode.HALF_UP);
	}

	private BigDecimal getTaxaOcupacaoMotos(BigDecimal nroMotosAcessados) {
		BigDecimal lotacaoMaximaMotos = SystemProperties.getLotacaoMaximaMotos();
		return nroMotosAcessados.multiply(CEM).divide(lotacaoMaximaMotos, 1, RoundingMode.HALF_UP);
	}
	
	private Long getTempoMediaPermanenciaCarros(List<LogAcesso> logAcessos) {
		List<LogAcesso> logAcessosCarros = notNull(logAcessos).stream().filter(l -> l.getVeiculo().isCarro()).collect(Collectors.toList());
		return getTempoMediaPermanencia(logAcessosCarros);
	}
	
	private Long getTempoMediaPermanenciaMotos(List<LogAcesso> logAcessos) {
		List<LogAcesso> logAcessosMotos = notNull(logAcessos).stream().filter(l -> l.getVeiculo().isMoto()).collect(Collectors.toList());
		return getTempoMediaPermanencia(logAcessosMotos);
	}
	
	private Long getTempoMediaPermanencia(List<LogAcesso> logAcessos) {
		List<Long> temposDePermanencia = notNull(logAcessos).stream()
			.filter(log -> log.getDataHoraEntrada() != null && log.getDataHoraSaida() != null)
            .map(log -> log.getDataHoraSaida().getTime() - log.getDataHoraEntrada().getTime())
            .collect(Collectors.toList());
		
		Long totalTempoPermanencia = notNull(temposDePermanencia).stream().mapToLong(Long::longValue).sum();
		
		Integer qtdeTempos = notNull(temposDePermanencia).size();
		
		if(atLeastOne(temposDePermanencia)) {
			return TimeUnit.MILLISECONDS.toMinutes(totalTempoPermanencia / qtdeTempos);
		}

		return 0L;
	}
	
	private List<VeiculoLogAcessoBean> convertToBean(List<LogAcesso> logAcessos) {
		return notNull(logAcessos).stream().map(this::createBean).collect(Collectors.toList());
	}
	
	private VeiculoLogAcessoBean createBean(LogAcesso logAcesso) {
		VeiculoLogAcessoBean veiculoLogAcessoBean = new VeiculoLogAcessoBean();
		
		veiculoLogAcessoBean.setTipo(logAcesso.getVeiculo().getTipoVeiculo().getDescricao());
		veiculoLogAcessoBean.setPlaca(logAcesso.getVeiculo().getPlaca());
		veiculoLogAcessoBean.setModelo(logAcesso.getVeiculo().getModelo());
		veiculoLogAcessoBean.setDataEntrada(logAcesso.getDataHoraEntrada());
		
		return veiculoLogAcessoBean;
	}
	
    public List<VeiculosPorDataBean> getVeiculosPorData(List<LogAcesso> logAcessos, Date mesReferencia) {
        List<VeiculosPorDataBean> resultado = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.setTime(mesReferencia);
        int mes = cal.get(Calendar.MONTH);
        int ano = cal.get(Calendar.YEAR);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        int ultimoDia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int dia = 1; dia <= ultimoDia; dia++) {
            cal.set(Calendar.DAY_OF_MONTH, dia);
            Date diaAtual = cal.getTime();

            final int diaLog = dia;
            
            List<LogAcesso> logsDoDia = notNull(logAcessos).stream()
            								.filter(log -> {
            			                        Calendar logCal = Calendar.getInstance();
            			                        logCal.setTime(log.getDataHoraEntrada());
            			                        return logCal.get(Calendar.DAY_OF_MONTH) == diaLog &&
            			                               logCal.get(Calendar.MONTH) == mes &&
            			                               logCal.get(Calendar.YEAR) == ano;
            								}).collect(Collectors.toList());
            

            Long nroCarros = getNroCarros(logsDoDia);
            Long nroMotos = getNroMotos(logsDoDia);

            VeiculosPorDataBean veiculosPorDia = new VeiculosPorDataBean();
            veiculosPorDia.setData(diaAtual);
            veiculosPorDia.setNroCarros(nroCarros);
            veiculosPorDia.setNroMotos(nroMotos);

            resultado.add(veiculosPorDia);
        }

        return resultado;
    }

	private <T> List<T> notNull(List<T> lista) {
		return lista != null ? lista : new ArrayList<T>();
	}
	
	private <T> boolean atLeastOne(List<T> lista) {
		return notNull(lista).size() > 0;
	}
	
}
