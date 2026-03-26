package co.edu.uptc.personservice.service;

import co.edu.uptc.personservice.dto.PersonDto;
import co.edu.uptc.personservice.dto.PersonRequest;
import co.edu.uptc.personservice.dto.PersonResponse;
import co.edu.uptc.personservice.dto.ResponseWrapper;
import co.edu.uptc.personservice.model.Person;
import co.edu.uptc.personservice.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResponseWrapper<PersonResponse> save(PersonRequest request) {
        Person person = new Person();
        person.setName(request.getName());
        person.setLastName(request.getLastName());
        person.setAge(request.getAge());

        Person saved = personRepository.save(person);

        PersonResponse response = new PersonResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setLastName(saved.getLastName());
        response.setAge(saved.getAge());
        response.setMessage("Persona creada exitosamente");
        response.setServerMessage("Guardado en PostgreSQL");

        String ip = InetAddress.getLoopbackAddress().getHostAddress();

        return new ResponseWrapper<>(ip, response);
    }

    public List<PersonDto> getAll() {
        return personRepository.findAll().stream().map(p -> {
            PersonDto dto = new PersonDto();
            dto.setName(p.getName());
            dto.setLastName(p.getLastName());
            dto.setAge(p.getAge());
            dto.setIp("localhost");
            dto.setServerMessage("Obtenido de PostgreSQL");
            return dto;
        }).collect(Collectors.toList());
    }
}
