package ma.suptech.MSresource.config;

import ma.suptech.MSresource.enumerations.Contract.Status;
import ma.suptech.MSresource.enumerations.Contract.Type;
import ma.suptech.MSresource.enumerations.timesheet.Absence;
import ma.suptech.MSresource.models.Contract;
import ma.suptech.MSresource.models.TimeOffRequest;
import ma.suptech.MSresource.models.TimeSheet;
import ma.suptech.MSresource.services.ContractService;
import ma.suptech.MSresource.services.TimeOffRequestService;
import ma.suptech.MSresource.services.TimeSheetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.LocalDate;

@Configuration
public class ResourceConfig {
    private final ContractService contractService;
    private final TimeSheetService timeSheetService;
    private final TimeOffRequestService timeOffRequestService;

    public ResourceConfig(ContractService contractService, TimeSheetService timeSheetService, TimeOffRequestService timeOffRequestService) {
        this.contractService = contractService;
        this.timeSheetService = timeSheetService;
        this.timeOffRequestService = timeOffRequestService;
    }

    @Bean
    CommandLineRunner initResource(){
        return args -> {
            timeSheetService.create(new TimeSheet(null, LocalDate.now(), Duration.ofHours(8),null,null,1L,null));
            timeSheetService.create(new TimeSheet(null, LocalDate.now(), Duration.ofHours(7),null,null,2L,null));
            timeSheetService.create(new TimeSheet(null, LocalDate.now(), Duration.ofHours(2),Absence.DISEASE,"maux de ventre",1L,null));
            timeSheetService.create(new TimeSheet(null, LocalDate.now(), Duration.ofHours(8),null,null,4L,null));
            timeSheetService.create(new TimeSheet(null, LocalDate.now(), Duration.ofHours(0), Absence.HOLIDAYS,"congés",1L,null));
            
            contractService.create(new Contract(null, LocalDate.of(2000,10,22),null, Type.CDI,12000, Status.ACTIVE,1L,null));
            contractService.create(new Contract(null,LocalDate.of(1980,12,1),LocalDate.of(2040,10,1),Type.CDD,10000,Status.ACTIVE,2L,null));
            contractService.create(new Contract(null,LocalDate.of(2004,1,22),LocalDate.of(2030,10,22),Type.CDD,15000,Status.ACTIVE,3L,null));
            contractService.create(new Contract(null,LocalDate.of(2008,5,22),LocalDate.of(2050,10,22),Type.CDD,7500,Status.ACTIVE,4L,null));
            contractService.create(new Contract(null,LocalDate.of(1998,5,22),LocalDate.of(2000,10,22),Type.ALTERNATION,7500,Status.EXPIRED,1L,null));

            ma.suptech.MSresource.enumerations.timeOffRequest.Type  types[] = {ma.suptech.MSresource.enumerations.timeOffRequest.Type.MATERNITY, ma.suptech.MSresource.enumerations.timeOffRequest.Type.DISEASE, ma.suptech.MSresource.enumerations.timeOffRequest.Type.ANNUAL, ma.suptech.MSresource.enumerations.timeOffRequest.Type.FORMATION};


            String[] reasons ={
                    "j'ai une grippe", "je dois passer une formation", "Je suis bientôt à terme de ma grossesse","je veux prendre des vacances"
            };
            LocalDate[] requestDates ={
                    LocalDate.of(2022,5,25),
                    LocalDate.of(2023,5,26),
                    LocalDate.of(2023,5,27),
                    LocalDate.of(2023,5,29)
            };
            ma.suptech.MSresource.enumerations.timeOffRequest.Status[] status = {
                    ma.suptech.MSresource.enumerations.timeOffRequest.Status.ACCEPTED,
                    ma.suptech.MSresource.enumerations.timeOffRequest.Status.PENDING,
                    ma.suptech.MSresource.enumerations.timeOffRequest.Status.ACCEPTED,
                    ma.suptech.MSresource.enumerations.timeOffRequest.Status.REJECTED
            };

            LocalDate[] desiredStartDate = {
                    LocalDate.of(2022,5,26),
                    LocalDate.of(2023,5,27),
                    LocalDate.of(2023,5,29),
                    LocalDate.of(2023,5,30)
            };
            LocalDate[] desiredEndDate = {
                    LocalDate.of(2022,6,26),
                    LocalDate.of(2023,6,27),
                    LocalDate.of(2023,6,29),
                    LocalDate.of(2023,6,30)
            };
            Long[] employeeID = {1L,1L,3L,4L};
            for (int i = 0; i < requestDates.length; i++) {
                TimeOffRequest timeOffRequest = new TimeOffRequest();
                timeOffRequest.setReason(reasons[i]);
                timeOffRequest.setRequestDate(requestDates[i]);
                timeOffRequest.setRequestStatus(status[i]);
                timeOffRequest.setDesiredStartDate(desiredStartDate[i]);
                timeOffRequest.setDesiredEndDate(desiredEndDate[i]);
                timeOffRequest.setEmployeeID(employeeID[i]);
                timeOffRequest.setType(types[i]);
                timeOffRequestService.create(timeOffRequest);
            }
        };
    }
}
