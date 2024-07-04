package br.com.unisenaisc.intelligate.web.manager.dashboard;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.pie.PieChartModel;

import br.com.unisenaisc.intelligate.common.api.bean.DashboardDataBean;
import br.com.unisenaisc.intelligate.common.api.bean.DashboardFilterBean;
import br.com.unisenaisc.intelligate.common.api.resource.DashboardResource;
import br.com.unisenaisc.intelligate.common.exception.BusinessCheckedException;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@RequestScoped
public class DashboardManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private DashboardDataBean dashboardData = new DashboardDataBean();
	
	private Date dataInicio = new Date();
	private Date dataFim = new Date();
	private Date mesReferencia = new Date();
	
    @PostConstruct
    public void init() {
        findDashboardData();
    }

    private void findDashboardData() {
    	try {
    		dashboardData = getResource().getDataWithFilter(getFilter());
		} catch (Exception e) {
			addFacesMessage(e);
		}
	}
    
    private DashboardFilterBean getFilter() {
    	DashboardFilterBean filter = new DashboardFilterBean();
    	
    	filter.setDataInicio(dataInicio);
    	filter.setDataFim(dataFim);
    	filter.setMesReferencia(mesReferencia);
    	
    	return filter;
    }
    
    private DashboardResource getResource() {
    	return getResource(DashboardResource.class);
    }

	public DashboardDataBean getDashboardData() {
		return dashboardData;
	}

	public void setDashboardData(DashboardDataBean dashboardData) {
		this.dashboardData = dashboardData;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(Date mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	private int totalVeiculos = 5;
    private int totalCarros = 3;
    private int totalMotos = 2;
    private int taxaOcupacao = 12;
    private List<Object> historicoAcessos = new ArrayList<Object>();
    private String tempoMedioCarros = "12,5";
    private String tempoMedioMotos = "12,5";
    private List<Object> veiculosLongaPermanencia = new ArrayList<Object>();

    private String selectedPeriod = "hoje"; // Valor padrão
    private Date startDate;
    private Date endDate;


    public void carregarDados() {
        // Lógica para carregar os dados com base no período selecionado
        if ("hoje".equals(selectedPeriod)) {
            // Carregar dados para hoje
        } else if ("semana".equals(selectedPeriod)) {
            // Carregar dados para esta semana
        } else if ("mes".equals(selectedPeriod)) {
            // Carregar dados para este mês
        } else if ("ano".equals(selectedPeriod)) {
            // Carregar dados para este ano
        } else if ("personalizado".equals(selectedPeriod)) {
            // Carregar dados para o período personalizado
        }
    }

    public void onPeriodChange() {
        if (!"personalizado".equals(selectedPeriod)) {
            startDate = null;
            endDate = null;
        }
        carregarDados();
    }

    // Getters e Setters para todas as propriedades

    public int getTotalVeiculos() {
        return totalVeiculos;
    }

    public void setTotalVeiculos(int totalVeiculos) {
        this.totalVeiculos = totalVeiculos;
    }

    public int getTotalCarros() {
        return totalCarros;
    }

    public void setTotalCarros(int totalCarros) {
        this.totalCarros = totalCarros;
    }

    public int getTotalMotos() {
        return totalMotos;
    }

    public void setTotalMotos(int totalMotos) {
        this.totalMotos = totalMotos;
    }

    public int getTaxaOcupacao() {
        return taxaOcupacao;
    }

    public void setTaxaOcupacao(int taxaOcupacao) {
        this.taxaOcupacao = taxaOcupacao;
    }

    public List<Object> getHistoricoAcessos() {
        return historicoAcessos;
    }

    public void setHistoricoAcessos(List<Object> historicoAcessos) {
        this.historicoAcessos = historicoAcessos;
    }

    public String getTempoMedioCarros() {
        return tempoMedioCarros;
    }

    public void setTempoMedioCarros(String tempoMedioCarros) {
        this.tempoMedioCarros = tempoMedioCarros;
    }

    public String getTempoMedioMotos() {
        return tempoMedioMotos;
    }

    public void setTempoMedioMotos(String tempoMedioMotos) {
        this.tempoMedioMotos = tempoMedioMotos;
    }

    public List<Object> getVeiculosLongaPermanencia() {
        return veiculosLongaPermanencia;
    }

    public void setVeiculosLongaPermanencia(List<Object> veiculosLongaPermanencia) {
        this.veiculosLongaPermanencia = veiculosLongaPermanencia;
    }

    public String getSelectedPeriod() {
        return selectedPeriod;
    }

    public void setSelectedPeriod(String selectedPeriod) {
        this.selectedPeriod = selectedPeriod;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }

}
