package br.com.unisenaisc.intelligate.common.api.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class DashboardDataBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long totalCarros;
	
	private Long totalMotos;
	
	private Long nroCarrosAcessados;
	
	private Long nroMotosAcessados;
	
	private BigDecimal taxaOcupacaoCarros;
	
	private BigDecimal taxaOcupacaoMotos;
	
	private List<VeiculosPorDataBean> veiculosPorDataList;

	private Long totalCarrosPeriodo;
	
	private Long totalMotosPeriodo;
	
	//Em minutos
	private Long tempoMedioOcupacaoPeriodoCarros;
	
	//Em minutos
	private Long tempoMedioOcupacaoPeriodoMotos;
	
	private List<VeiculoLogAcessoBean> veiculosAcessados;

	public Long getTotalCarros() {
		return totalCarros;
	}

	public void setTotalCarros(Long totalCarros) {
		this.totalCarros = totalCarros;
	}

	public Long getTotalMotos() {
		return totalMotos;
	}

	public void setTotalMotos(Long totalMotos) {
		this.totalMotos = totalMotos;
	}

	public Long getNroCarrosAcessados() {
		return nroCarrosAcessados;
	}

	public void setNroCarrosAcessados(Long nroCarrosAcessados) {
		this.nroCarrosAcessados = nroCarrosAcessados;
	}

	public Long getNroMotosAcessados() {
		return nroMotosAcessados;
	}

	public void setNroMotosAcessados(Long nroMotosAcessados) {
		this.nroMotosAcessados = nroMotosAcessados;
	}

	public BigDecimal getTaxaOcupacaoCarros() {
		return taxaOcupacaoCarros;
	}

	public void setTaxaOcupacaoCarros(BigDecimal taxaOcupacaoCarros) {
		this.taxaOcupacaoCarros = taxaOcupacaoCarros;
	}

	public BigDecimal getTaxaOcupacaoMotos() {
		return taxaOcupacaoMotos;
	}

	public void setTaxaOcupacaoMotos(BigDecimal taxaOcupacaoMotos) {
		this.taxaOcupacaoMotos = taxaOcupacaoMotos;
	}
	
	public List<VeiculosPorDataBean> getVeiculosPorDataList() {
		return veiculosPorDataList;
	}

	public void setVeiculosPorDataList(List<VeiculosPorDataBean> veiculosPorDataList) {
		this.veiculosPorDataList = veiculosPorDataList;
	}

	public Long getTotalCarrosPeriodo() {
		return totalCarrosPeriodo;
	}

	public void setTotalCarrosPeriodo(Long totalCarrosPeriodo) {
		this.totalCarrosPeriodo = totalCarrosPeriodo;
	}

	public Long getTotalMotosPeriodo() {
		return totalMotosPeriodo;
	}

	public void setTotalMotosPeriodo(Long totalMotosPeriodo) {
		this.totalMotosPeriodo = totalMotosPeriodo;
	}

	public Long getTempoMedioOcupacaoPeriodoCarros() {
		return tempoMedioOcupacaoPeriodoCarros;
	}

	public void setTempoMedioOcupacaoPeriodoCarros(Long tempoMedioOcupacaoPeriodoCarros) {
		this.tempoMedioOcupacaoPeriodoCarros = tempoMedioOcupacaoPeriodoCarros;
	}

	public Long getTempoMedioOcupacaoPeriodoMotos() {
		return tempoMedioOcupacaoPeriodoMotos;
	}

	public void setTempoMedioOcupacaoPeriodoMotos(Long tempoMedioOcupacaoPeriodoMotos) {
		this.tempoMedioOcupacaoPeriodoMotos = tempoMedioOcupacaoPeriodoMotos;
	}

	public List<VeiculoLogAcessoBean> getVeiculosAcessados() {
		return veiculosAcessados;
	}

	public void setVeiculosAcessados(List<VeiculoLogAcessoBean> veiculosAcessados) {
		this.veiculosAcessados = veiculosAcessados;
	}

}
