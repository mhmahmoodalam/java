package com.ex.utility.metrics;


import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import com.codahale.metrics.ConsoleReporter;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ScheduledReporter;

import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

@Configuration
@Component
@EnableMetrics(proxyTargetClass = true)
public class ApplicationServiceMetricsConfig extends MetricsConfigurerAdapter {

    /**
     * GENERAL_LOG logger
     */
    private static final Logger GENERAL_LOG = LogManager
            .getLogger(ApplicationServiceMetricsConfig.class);

    /**
     * consoleReporterEnabled
     */
    private boolean consoleReporterEnabled = false;
    /**
     * consoleIntervalSeconds
     */
    private long consoleIntervalSeconds = 60L;
    
    private boolean m_enableDataLensReporter = false;
    
    private MeasurementFactory m_metricFactory;
    private IMetricsTransport  m_metricsTransport;
    
    public MeasurementFactory getMetricFactory()
    {
        return m_metricFactory;
    }

    @Autowired
    public ApplicationServiceMetricsConfig setMetricFactory(final MeasurementFactory metricFactory)
    {
        m_metricFactory = metricFactory;
        return this;
    }

    public IMetricsTransport getMetricsTransport()
    {
        return m_metricsTransport;
    }

    @Autowired
    public ApplicationServiceMetricsConfig setMetricsTransport(final IMetricsTransport metricsTransport)
    {
        m_metricsTransport = metricsTransport;
        return this;
    }


    /**
     * @param enableConRep
     *            Boolean
     */
    @Value("${appmetrics.report.console.enabled}")
    public void setEnableConsoleReporter(final Boolean enableConRep) {
        consoleReporterEnabled = enableConRep;
    }
    
    /**
     * @param enableConRep
     *            Boolean
     */
    @Value("${appmetrics.report.datalens.enabled}")
    public void setEnableDataLensReporter(final Boolean _enableDataLensRep) { m_enableDataLensReporter =_enableDataLensRep; }

    /**
     * @param intervalSec
     *            Long
     */
    @Value("${appmetrics.report.console.intervalSeconds}")
    public void setConsoleReportingIntervalSeconds(final Long intervalSec) {
        consoleIntervalSeconds = intervalSec;
    }
    
    @Override
    public void configureReporters( MetricRegistry metricRegistry )
    {
        configureConsoleReporter(metricRegistry);
        configureDataLensReporter(metricRegistry);
    }
   
  
    /**
     * @param metricRegistry
     *            MetricRegistry
     */
    void configureConsoleReporter(final MetricRegistry metricRegistry) {
        if (consoleReporterEnabled) {
            GENERAL_LOG.info(
                    "Application Metrics Console Reporting:  ENABLED  (Reporting Interval: {} sec)",
                    consoleIntervalSeconds);
            registerReporter(
                    ConsoleReporter.forRegistry(metricRegistry).build())
                            .start(consoleIntervalSeconds, TimeUnit.SECONDS);
        } else {
            GENERAL_LOG
                    .info("Application Metrics Console Reporting:  DISABLED");
        }
    }
    
    /**
     * @param metricRegistry
     *            MetricRegistry
     *  using customer datalense reporter          
     */
    void configureDataLensReporter( MetricRegistry rgy )
    {
        if (!m_enableDataLensReporter) return;

        GENERAL_LOG.info("Application Metrics DataLens/Telegraf_to_InfluxDB Reporting:  ENABLED  (Reporting Interval: {} sec)",
        		consoleIntervalSeconds);

        DataLensMetricReporter.Builder repBld = DataLensMetricReporter.forRegistry(rgy);

        repBld.convertDurationsTo(TimeUnit.MILLISECONDS)
              .convertRatesTo(TimeUnit.SECONDS)
              .usingMetricBuilder(m_metricFactory)
              .transportingMetricsVia(m_metricsTransport);

        ScheduledReporter agent = repBld.build();

        agent.start(consoleIntervalSeconds, TimeUnit.SECONDS);
    }

  
   
}
