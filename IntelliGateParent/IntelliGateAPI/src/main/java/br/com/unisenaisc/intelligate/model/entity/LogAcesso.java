package br.com.unisenaisc.intelligate.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.unisenaisc.intelligate.architecture.entity.AbstractEntity;

@Entity
public class LogAcesso extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "LOGACESSO_GENERATOR", sequenceName = "IDLOGACESSO", allocationSize = 1)
	@GeneratedValue(generator = "LOGACESSO_GENERATOR", strategy = GenerationType.SEQUENCE)
	private Long idLogAcesso;
	
	@NotNull
    @ManyToOne
    @JoinColumn(name = "IDVEICULO")
	private Veiculo veiculo;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraEntrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraSaida;
	
	public Long getIdLogAcesso() {
		return idLogAcesso;
	}

	public void setIdLogAcesso(Long idLogAcesso) {
		this.idLogAcesso = idLogAcesso;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Date dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Date getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(Date dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}

	@Override
	public Long getId() {
		return getIdLogAcesso();
	}

}
