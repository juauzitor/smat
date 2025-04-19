package br.juauzitor.smat.infrastructure.config;

import br.juauzitor.smat.application.usecase.CompanyUseCase;
import br.juauzitor.smat.application.usecase.TaskCategoryUseCase;
import br.juauzitor.smat.application.usecase.TaskPerformedUseCase;
import br.juauzitor.smat.application.usecase.WorkFrequencyUseCase;
import br.juauzitor.smat.domain.port.out.CompanyRepository;
import br.juauzitor.smat.domain.port.out.TaskCategoryRepository;
import br.juauzitor.smat.domain.port.out.TaskPerformedRepository;
import br.juauzitor.smat.domain.port.out.WorkFrequencyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CompanyUseCase companyUseCase(CompanyRepository repository){
        return new CompanyUseCase(repository);
    }

    @Bean
    public WorkFrequencyUseCase workFrequencyUseCase(WorkFrequencyRepository repository){
        return new WorkFrequencyUseCase(repository);
    }

    @Bean
    public TaskCategoryUseCase taskCategoryUseCase(TaskCategoryRepository repository){
        return new TaskCategoryUseCase(repository);
    }

    @Bean
    public TaskPerformedUseCase taskPerformedUseCase(TaskPerformedRepository repository){
        return new TaskPerformedUseCase(repository);
    }
}
