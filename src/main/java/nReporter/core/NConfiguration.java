package nReporter.core;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

import static nReporter.NLogger.nLogger;

public class NConfiguration {

    private static NConfiguration nConfiguration = null;
    private Template reportTemplate;
    private Configuration cfg;

    private NConfiguration(String templatePath) throws IOException {
        nLogger.debug ("Initialising report configuration...");
        cfg = new Configuration (Configuration.VERSION_2_3_29);
        cfg.setDefaultEncoding ("UTF-8");
        cfg.setTemplateExceptionHandler (TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        cfg.setLogTemplateExceptions (false);
        cfg.setWrapUncheckedExceptions (true);
        cfg.setFallbackOnNullLoopVariable (false);
        this.setReportTemplate (templatePath);
        nLogger.info ("Initialised report configuration.");
    }

    /**
     * Get report template
     *
     * @return report template.
     */
    public Template getReportTemplate() {
        return reportTemplate;
    }

    /**
     * SetReport Template
     * @param reportTemplatePath Report Template path
     * @throws IOException if template path not foumd.
     */
    public void setReportTemplate(String reportTemplatePath) throws IOException {
        if (reportTemplatePath == null) {
            this.cfg.setClassLoaderForTemplateLoading (this.getClass ( ).getClassLoader ( ), "./templates");
            this.reportTemplate = this.cfg.getTemplate ("report.ftlh");
            nLogger.info ("Loaded default report template.");
        } else {
            File templateFile = new File (reportTemplatePath);
            this.cfg.setDirectoryForTemplateLoading (new File (templateFile.getParent ( )));
            this.reportTemplate = this.cfg.getTemplate (templateFile.getName ( ));
            nLogger.info ("Loaded report template from: " + templateFile);
        }
    }

    /**
     * Get configuration instance
     *
     * @param templatePath Template path
     * @return Configuration instance
     * @throws IOException if template file is not found
     */
    public static NConfiguration getInstance(String templatePath) throws IOException {
        if (nConfiguration == null)
            nConfiguration = new NConfiguration (templatePath);
        return nConfiguration;
    }

    public static NConfiguration getInstance() throws IOException {
        return getInstance (null);
    }

    public static NConfiguration close(){
        nConfiguration = null;
        return nConfiguration;
    }
}
