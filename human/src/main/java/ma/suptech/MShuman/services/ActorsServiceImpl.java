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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class ActorsServiceImpl implements ActorsService {
    private final HumanResourceManagerRepository humanResourceManagerRepository;
    private final ManagerRepository managerRepository;
    private final EmployeeRepository employeeRepository;
    List<String> lastNames = Stream.of(
            "Jackson", "Ndiaye", "Dubois", "Sarr",
            "Garcia", "Smith", "Lopez", "Chen",
            "Müller", "González", "Zerktouni",
            "Kassidh","Fayette","Lawson"
    ).toList();
    List<String> firstNames = Stream.of(
            "Emmanuel", "Liam", "Olivier", "Noah", "Sandrine",
            "Isabella", "Sophia", "Mia", "Charlotte", "Sylvie",
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
    List<Status> statusList = Stream.of(Status.ACTIVE,Status.INACTIVE).toList();
    String photoUrl = "https://static.vecteezy.com/system/resources/previews/008/442/086/original/illustration-of-human-icon-user-symbol-icon-modern-design-on-blank-background-free-vector.jpg";
    List<Long>departmentID = Stream.of(1L,2L,3L,4L,5L,6L,8L,9L,10L).toList();
    List<Long>jobID = Stream.of(1L,2L,3L,4L,5L,6L,8L,9L,10L,11L,12L,13L,14L,15L,16L,18L,19L,20L).toList();


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
            HumanResourceManager rh = new HumanResourceManager();
            rh.setName(lastNames.get(new Random().nextInt(lastNames.size())));
            rh.setFirstName(firstNames.get(new Random().nextInt(firstNames.size())));
            if(rh.getFirstName().startsWith("S") || rh.getFirstName().startsWith("Mi")|| rh.getFirstName().startsWith("i")|| rh.getFirstName().startsWith("kh"))
                rh.setGender(Gender.FEMALE);
            else
                rh.setGender(Gender.MALE);
            rh.setBirthday(birthdays.get(new Random().nextInt(birthdays.size())));
            rh.setAddress(addresses.get(new Random().nextInt(addresses.size())));
            rh.setTelephone(telephoneNumbers.get(new Random().nextInt(telephoneNumbers.size())));
            rh.setEmail(rh.getFirstName()+new Random().nextInt(10,2000)+"@gmail.com");
            rh.setHiringDate(rh.getBirthday().plusYears(new Random().nextInt(20,25)));
            rh.setStatus(statusList.get(new Random().nextInt(statusList.size())));
            rh.setPhotoUrl(photoUrl);
            rh.setDepartmentID(15L);
            rh.setJobID(15L);

            humanResourceManagerRepository.save(rh);
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
            Manager manager = new Manager();
            manager.setName(lastNames.get(new Random().nextInt(lastNames.size())));
            manager.setFirstName(firstNames.get(new Random().nextInt(firstNames.size())));
            if(manager.getFirstName().startsWith("S") || manager.getFirstName().startsWith("Mi")|| manager.getFirstName().startsWith("I")|| manager.getFirstName().startsWith("Kh"))
                manager.setGender(Gender.FEMALE);
            else
                manager.setGender(Gender.MALE);
            manager.setBirthday(birthdays.get(new Random().nextInt(birthdays.size())));
            manager.setAddress(addresses.get(new Random().nextInt(addresses.size())));
            manager.setTelephone(telephoneNumbers.get(new Random().nextInt(telephoneNumbers.size())));
            manager.setEmail(manager.getFirstName()+new Random().nextInt(10,2000)+"@gmail.com");
            manager.setHiringDate(manager.getBirthday().plusYears(new Random().nextInt(20,25)));
            manager.setStatus(statusList.get(new Random().nextInt(statusList.size())));
            manager.setPhotoUrl(photoUrl);
            manager.setDepartmentID(departmentID.get(new Random().nextInt(departmentID.size())));
            manager.setJobID(jobID.get(new Random().nextInt(jobID.size())));

            managerRepository.save(manager);
        }
    }

    @Override
    public void initEmployee() {
        telephoneNumbers.clear();
        while (telephoneNumbers.size() < 50) {
            int number = generatePhoneNumber();
            telephoneNumbers.add(number);
        }
        for (int i=0; i<50;i++){
            Employee employee = new Employee();
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
            employee.setDepartmentID(departmentID.get(new Random().nextInt(departmentID.size())));
            employee.setJobID(jobID.get(new Random().nextInt(jobID.size())));
            while (employee.getJobID().equals(15L))//rh
                employee.setJobID(jobID.get(new Random().nextInt(jobID.size())));
            List<Manager> managers  = managerRepository.findAll()
                    .stream().filter(manager -> manager.getDepartmentID().equals(employee.getDepartmentID()))
                    .collect(Collectors.toList());
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
