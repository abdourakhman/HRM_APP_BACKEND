package ma.suptech.MShuman.services;

import jakarta.transaction.Transactional;
import ma.suptech.MShuman.enumerations.Gender;
import ma.suptech.MShuman.enumerations.Status;
import ma.suptech.MShuman.models.Employee;
import ma.suptech.MShuman.models.HumanResourceManager;
import ma.suptech.MShuman.models.Manager;
import ma.suptech.MShuman.repositories.EmployeeRepository;
import ma.suptech.MShuman.repositories.HumanResourceManagerRepository;
import ma.suptech.MShuman.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class ActorsServiceImpl implements ActorsService {
    private final HumanResourceManagerRepository humanResourceManagerRepository;
    private final ManagerRepository managerRepository;
    private final EmployeeRepository employeeRepository;
    List<String> lastNames = Stream.of(
            "Jackson", "Ndiaye", "Dubois", "Sarr","Aziza","Alaoui",
            "Garcia", "Smith", "Lopez", "Diagne",
            "Müller", "González", "Zerktouni",
            "Kassidh","Fayette","Lawson","Job"
    ).toList();
    List<String> firstNames = Stream.of(
            "Emmanuel", "Liam", "Olivier", "Noah", "Sandrine","Shaîma","Samira","Soukeyna",
            "Isabella", "Sophia", "Mia", "Charle", "Sylvie","Sophie",
            "Harper", "Will alexander", "El hadji", "Imêne", "Salma",
            "James", "Benjamin", "Lucas", "Henry", "Alexander",
            "Abdourahmane","Khadija","Fayçal","Hamza","Eric"
    ).toList();

    List<LocalDate> birthdays = Stream.generate(() -> LocalDate.now().minusYears((long) (Math.random() * 50 + 20)))
            .limit(20)
            .collect(Collectors.toList());

    List<String> addresses = Stream.generate(() -> generateRandomAddress())
            .limit(20)
            .collect(Collectors.toList());
    List<Integer> telephoneNumbers = new ArrayList<>();
    List<Status> statusList = Stream.of(Status.ACTIVE,Status.ACTIVE,Status.ACTIVE,Status.INACTIVE).toList();
    String photoUrl = "https://static.vecteezy.com/system/resources/previews/008/442/086/original/illustration-of-human-icon-user-symbol-icon-modern-design-on-blank-background-free-vector.jpg";
    List<Long>departmentID = Stream.of(1L,2L,3L,4L,5L,6L,8L,9L,10L,11L,12L,13L).toList();
    List<Long>jobID = Stream.of(1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L,12L,13L,14L,15L,16L,17L,18L,19L,20L).toList();


    public ActorsServiceImpl(HumanResourceManagerRepository humanResourceManagerRepository, ManagerRepository managerRepository, EmployeeRepository employeeRepository) {
        this.humanResourceManagerRepository = humanResourceManagerRepository;
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void initHumanResourceManager() {
        while (telephoneNumbers.size() < 20) {
            int number = generatePhoneNumber();
            telephoneNumbers.add(number);
        }
        for (int i=0; i<20;i++){
            String registrationNumber = UUID.randomUUID().toString();
            HumanResourceManager rh = new HumanResourceManager();
            Employee employee = new Employee();
            //affecting the same  registrationNumber to employee and rh
            rh.setRegistrationNumber(registrationNumber);
            employee.setRegistrationNumber(registrationNumber);
            employee.setName(lastNames.get(new Random().nextInt(lastNames.size())));
            employee.setFirstName(firstNames.get(new Random().nextInt(firstNames.size())));
            if(employee.getFirstName().startsWith("S") || employee.getFirstName().startsWith("Mi")|| employee.getFirstName().startsWith("I")|| employee.getFirstName().startsWith("Kh"))
                employee.setGender(Gender.FEMALE);
            else
                employee.setGender(Gender.MALE);
            employee.setBirthday(birthdays.get(new Random().nextInt(birthdays.size())));
            employee.setAddress(addresses.get(new Random().nextInt(addresses.size())));
            employee.setTelephone(telephoneNumbers.get(new Random().nextInt(telephoneNumbers.size())));
            employee.setEmail(employee.getFirstName()+new Random().nextInt(10,2000)+"@gmail.com");
            employee.setHiringDate(employee.getBirthday().plusYears(new Random().nextInt(20,25)));
            employee.setStatus(statusList.get(new Random().nextInt(statusList.size())));
            employee.setPhotoUrl(photoUrl);
            employee.setDepartmentID(10L); //departmentRH
            employee.setJobID(15L);//rh job
            humanResourceManagerRepository.save(rh);
            employeeRepository.save(employee);
        }

    }

    @Override
    public void initManager() {
        telephoneNumbers.clear();
        while (telephoneNumbers.size() < 15) {
            int number = generatePhoneNumber();
            telephoneNumbers.add(number);
        }
        for (int i=0; i<15;i++){
            String registrationNumber = UUID.randomUUID().toString();
            Manager manager = new Manager();
            Employee employee = new Employee();
            manager.setRegistrationNumber(registrationNumber);
            employee.setRegistrationNumber(registrationNumber);
            employee.setName(lastNames.get(new Random().nextInt(lastNames.size())));
            employee.setFirstName(firstNames.get(new Random().nextInt(firstNames.size())));
            if(employee.getFirstName().startsWith("S") || employee.getFirstName().startsWith("Mi")|| employee.getFirstName().startsWith("I")|| employee.getFirstName().startsWith("Kh"))
                employee.setGender(Gender.FEMALE);
            else
                employee.setGender(Gender.MALE);
            employee.setBirthday(birthdays.get(new Random().nextInt(birthdays.size())));
            employee.setAddress(addresses.get(new Random().nextInt(addresses.size())));
            employee.setTelephone(telephoneNumbers.get(new Random().nextInt(telephoneNumbers.size())));
            employee.setEmail(employee.getFirstName()+new Random().nextInt(10,2000)+"@gmail.com");
            employee.setHiringDate(employee.getBirthday().plusYears(new Random().nextInt(20,25)));
            employee.setStatus(statusList.get(new Random().nextInt(statusList.size())));
            employee.setPhotoUrl(photoUrl);
            employee.setDepartmentID(departmentID.stream().filter(elt-> elt != 10L).toList().get(new Random().nextInt(departmentID.size()-1)));
            employee.setJobID(jobID.stream().filter(elt-> elt != 15L).toList().get(new Random().nextInt(jobID.size()-1))); //exclusion rh
            employeeRepository.save(employee);
            managerRepository.save(manager);
        }
    }

    @Override
    public void initEmployee() {
        telephoneNumbers.clear();
        while (telephoneNumbers.size() < 125) {
            int number = generatePhoneNumber();
            telephoneNumbers.add(number);
        }
        for (int i=0; i<125;i++){
            String registrationNumber = UUID.randomUUID().toString();
            Employee employee = new Employee();
            employee.setRegistrationNumber(registrationNumber);
            employee.setName(lastNames.get(new Random().nextInt(lastNames.size())));
            employee.setFirstName(firstNames.get(new Random().nextInt(firstNames.size())));
            if(employee.getFirstName().startsWith("S") || employee.getFirstName().startsWith("Mi")|| employee.getFirstName().startsWith("I")|| employee.getFirstName().startsWith("Kh"))
                employee.setGender(Gender.FEMALE);
            else
                employee.setGender(Gender.MALE);
            employee.setBirthday(birthdays.get(new Random().nextInt(birthdays.size())));
            employee.setAddress(addresses.get(new Random().nextInt(addresses.size())));
            employee.setTelephone(telephoneNumbers.get(new Random().nextInt(telephoneNumbers.size())));
            employee.setEmail(employee.getFirstName()+new Random().nextInt(10,2000)+"@gmail.com");
            employee.setHiringDate(employee.getBirthday().plusYears(new Random().nextInt(20,25)));
            employee.setStatus(statusList.get(new Random().nextInt(statusList.size())));
            employee.setPhotoUrl(photoUrl);
            employee.setDepartmentID(departmentID.stream().filter(elt-> elt != 10L).toList().get(new Random().nextInt(departmentID.size()-1)));
            employee.setJobID(jobID.stream().filter(elt-> elt != 15L).toList().get(new Random().nextInt(jobID.size()-1))); //exclusion rh
            while (employee.getJobID().equals(15L))//rh
                employee.setJobID(jobID.get(new Random().nextInt(jobID.size())));
            List<Manager> managers = new ArrayList<>();

            managerRepository.findAll()
            .forEach(manager -> {
                employeeRepository.findAll()
                        .forEach(employee1 -> {
                            if (employee1.getDepartmentID().equals(employee.getDepartmentID()))
                                if(employee1.getRegistrationNumber().equals(manager.getRegistrationNumber()))
                                    managers.add(manager);
                        });
                    });

            Manager manager =null;
            if(managers.size() > 0)
                manager = managers.get(new Random().nextInt(managers.size()));
            employee.setManager(manager);
            employeeRepository.save(employee);
        }
    }
    private static String generateRandomAddress() {
        String[] streetNames = { "Maarouf", "Avenue du Soleil", "Boulevard des Étoiles", "Chemin de la Rivière", "Place de la Mairie","Les Hôpitaux","Maarif","Beau séjour","Derb Omar","Mers sultan" };
        String[] cities = {"Casablanca","Rabat", "Mohamedia", "Meknès", "Rabat", "Agadir","Tanger" };
        String country = "Maroc";

        String streetName = streetNames[(int) (Math.random() * streetNames.length)];
        int streetNumber = (int) (Math.random() * 100) + 1;
        String city = cities[(int) (Math.random() * cities.length)];

        return streetNumber + " " + streetName + ", " + city + ", " + country;
    }

    private static int generatePhoneNumber() {
        String prefix = "67"; // Les numéros de téléphone commencent par 6 ou 7
        String number = prefix + generateRandomDigits(7); // Génère 7 chiffres aléatoires

        return Integer.parseInt(number);
    }
    private static int generateRandomDigits(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = (int) (Math.random() * 10);
            sb.append(digit);
        }

        return Integer.parseInt(sb.toString());
    }
}
