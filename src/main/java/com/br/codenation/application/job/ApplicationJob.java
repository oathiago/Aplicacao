package com.br.codenation.application.job;

import com.br.codenation.application.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ApplicationJob {

    Logger LOG = LoggerFactory.getLogger(ApplicationJob.class);

    @Autowired
    CompanyService companyService;

    @Scheduled(fixedRate = 10000)
    public void verifyCompaniesNumber() {
        LOG.info("#### START VERIFY COUNT COMPANIES");
        Long result = companyService.countCompanies();
        LOG.info("#### FOUND {} COMPANY IN BASE", result);
        LOG.info("#### END VERIFY COUNT COMPANIES");
    }
}
