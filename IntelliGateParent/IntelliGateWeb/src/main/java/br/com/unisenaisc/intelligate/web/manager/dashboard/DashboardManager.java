package br.com.unisenaisc.intelligate.web.manager.dashboard;

import java.text.SimpleDateFormat;
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
	
	private Date dataConsulta = new Date();
	
	private LineChartModel acessosMesReferenciaChart;
	private PieChartModel totalAcessosPeriodoChart;
	private BarChartModel tempoMedioPermanenciaChart;
 	
    @PostConstruct
    public void init() {
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
    		String dateString = new SimpleDateFormat("dd/MM").format(vpd.getData());
    		labels.add(dateString);
    		carros.add(vpd.getNroCarros());
    		motos.add(vpd.getNroMotos());
    	}
    	
    	LineChartDataSet dataSetCarros = new LineChartDataSet();
    	dataSetCarros.setData(carros);
    	dataSetCarros.setFill(false);
    	dataSetCarros.setLabel("Carros");
        dataSetCarros.setBorderColor("rgb(0, 102, 255)");
        dataSetCarros.setTension(0.1);
    	
    	LineChartDataSet dataSetMotos = new LineChartDataSet();
    	dataSetMotos.setData(motos);
    	dataSetMotos.setFill(false);
    	dataSetMotos.setLabel("Motos");
    	dataSetMotos.setBorderColor("rgb(255, 153, 0)");
    	dataSetMotos.setTension(0.1);

    	data.addChartDataSet(dataSetCarros);
    	data.addChartDataSet(dataSetMotos);
    	data.setLabels(labels);
    	
        LineChartOptions options = new LineChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setFontSize(18);
        title.setText("Acessos por data");
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
        bgColors.add("rgb(0, 102, 255)");
        bgColors.add("rgb(255, 153, 0)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Carros");
        labels.add("Motos");
        data.setLabels(labels);
        
        PieChartOptions options = new PieChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setFontSize(18);
        title.setText("Total de Acessos");
        options.setTitle(title);
        
        
        totalAcessosPeriodoChart.setOptions(options);
        totalAcessosPeriodoChart.setData(data);
    }
    
	private void createTempoMedioPermanenciaChart() {
		tempoMedioPermanenciaChart = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("");

        List<Number> values = new ArrayList<>();
        values.add(dashboardData.getTempoMedioOcupacaoPeriodoCarros());
        values.add(dashboardData.getTempoMedioOcupacaoPeriodoMotos());
        barDataSet.setData(values);

        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgba(0, 102, 255, 0.8)");
        bgColor.add("rgba(255, 153, 0, 0.8)");
        barDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(0, 102, 255)");
        borderColor.add("rgb(255, 153, 0)");
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
        title.setFontSize(18);
        title.setText("Tempo médio de ocupação (em minutos)");
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
    	
    	filter.setDataConsulta(dataConsulta);
    	
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
