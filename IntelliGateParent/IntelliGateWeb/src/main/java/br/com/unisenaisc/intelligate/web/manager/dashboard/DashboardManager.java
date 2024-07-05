package br.com.unisenaisc.intelligate.web.manager.dashboard;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.model.charts.pie.PieChartOptions;

import br.com.unisenaisc.intelligate.common.api.bean.DashboardDataBean;
import br.com.unisenaisc.intelligate.common.api.bean.DashboardFilterBean;
import br.com.unisenaisc.intelligate.common.api.bean.VeiculosPorDataBean;
import br.com.unisenaisc.intelligate.common.api.resource.DashboardResource;
import br.com.unisenaisc.intelligate.web.manager.AbstractFormManager;

@Named
@RequestScoped
public class DashboardManager extends AbstractFormManager {

	private static final long serialVersionUID = 1L;

	private DashboardDataBean dashboardData = new DashboardDataBean();
	
	private Date dataInicio = new Date();
	private Date dataFim = new Date();
	private Date mesReferencia = new Date();
	
	private LineChartModel acessosMesReferenciaChart;
	private PieChartModel totalAcessosPeriodoChart;
	private BarChartModel tempoMedioPermanenciaChart;
 	
    @PostConstruct
    public void init() {
        YearMonth yearMonth = YearMonth.now();

    	LocalDateTime startOfMonth = yearMonth.atDay(1).atStartOfDay();
        
        // Fim do mês
        LocalDateTime endOfMonth = yearMonth.atEndOfMonth().atTime(23, 59, 59);
        
        // Convertendo para java.util.Date
        dataInicio = Date.from(startOfMonth.atZone(ZoneId.systemDefault()).toInstant());
        dataFim = Date.from(endOfMonth.atZone(ZoneId.systemDefault()).toInstant());

    	
    	
    	findDashboardData();
        
        createAcessosMesReferenciaChart();
        createTotalAcessosPeriodoChart();
        createTempoMedioPermanenciaChart();
    }

	private void findDashboardData() {
    	try {
    		dashboardData = getResource().getDataWithFilter(getFilter());
		} catch (Exception e) {
			addFacesMessage(e);
		}
	}
	
    private void createAcessosMesReferenciaChart() {
    	acessosMesReferenciaChart = new LineChartModel();
        ChartData data = new ChartData();

    	List<Object> carros = new ArrayList<>();
    	List<Object> motos = new ArrayList<>();
    	List<String> labels = new ArrayList<>();
    	
    	for (VeiculosPorDataBean vpd : dashboardData.getVeiculosPorDataList()) {
    		String dateString = new SimpleDateFormat("yyyy-MM-dd").format(vpd.getData());
    		labels.add(dateString);
    		carros.add(vpd.getNroCarros());
    		motos.add(vpd.getNroMotos());
    	}
    	
    	LineChartDataSet dataSetCarros = new LineChartDataSet();
    	dataSetCarros.setData(carros);
    	dataSetCarros.setFill(false);
    	dataSetCarros.setLabel("Carros");
        dataSetCarros.setBorderColor("rgb(75, 192, 192)");
        dataSetCarros.setTension(0.1);
    	
    	LineChartDataSet dataSetMotos = new LineChartDataSet();
    	dataSetMotos.setData(motos);
    	dataSetMotos.setFill(false);
    	dataSetMotos.setLabel("Motos");
    	dataSetMotos.setBorderColor("rgb(75, 192, 192)");
    	dataSetMotos.setTension(0.1);

    	data.addChartDataSet(dataSetCarros);
    	data.addChartDataSet(dataSetMotos);
    	data.setLabels(labels);
    	
        LineChartOptions options = new LineChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Acessos mês de Julho");
        options.setTitle(title);

        acessosMesReferenciaChart.setOptions(options);
        acessosMesReferenciaChart.setData(data);
    }
    
    private void createTotalAcessosPeriodoChart() {
    	totalAcessosPeriodoChart = new PieChartModel();
        ChartData data = new ChartData();
        
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(dashboardData.getTotalCarrosPeriodo());
        values.add(dashboardData.getTotalMotosPeriodo());
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Carros");
        labels.add("Motos");
        data.setLabels(labels);
        
        PieChartOptions options = new PieChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Total ocupação periodo");
        options.setTitle(title);
        
        
        totalAcessosPeriodoChart.setOptions(options);
        totalAcessosPeriodoChart.setData(data);
    }
    
	private void createTempoMedioPermanenciaChart() {
		tempoMedioPermanenciaChart = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Tempo médio de ocupação");

        List<Number> values = new ArrayList<>();
        values.add(dashboardData.getTempoMedioOcupacaoPeriodoCarros());
        values.add(dashboardData.getTempoMedioOcupacaoPeriodoMotos());
        barDataSet.setData(values);

        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 159, 64, 0.2)");
        barDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 159, 64)");
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);

        data.addChartDataSet(barDataSet);

        List<String> labels = new ArrayList<>();
        labels.add("Carros");
        labels.add("Motos");
        data.setLabels(labels);
        tempoMedioPermanenciaChart.setData(data);

        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Tempo médio de ocupação");
        options.setTitle(title);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("italic");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        tempoMedioPermanenciaChart.setOptions(options);
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

	public LineChartModel getAcessosMesReferenciaChart() {
		return acessosMesReferenciaChart;
	}

	public void setAcessosMesReferenciaChart(LineChartModel acessosMesReferenciaChart) {
		this.acessosMesReferenciaChart = acessosMesReferenciaChart;
	}

	public PieChartModel getTotalAcessosPeriodoChart() {
		return totalAcessosPeriodoChart;
	}

	public void setTotalAcessosPeriodoChart(PieChartModel totalAcessosPeriodoChart) {
		this.totalAcessosPeriodoChart = totalAcessosPeriodoChart;
	}

	public BarChartModel getTempoMedioPermanenciaChart() {
		return tempoMedioPermanenciaChart;
	}

	public void setTempoMedioPermanenciaChart(BarChartModel tempoMedioPermanenciaChart) {
		this.tempoMedioPermanenciaChart = tempoMedioPermanenciaChart;
	}
	
}
