package org.alinuswe.service;


import io.netty.handler.codec.http.HttpResponseStatus;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import org.alinuswe.exceptions.ApplicationException;
import org.alinuswe.model.Person;
import org.alinuswe.repository.PersonRepository;
import org.alinuswe.request.PersonDetailsRequest;
import org.alinuswe.response.Response;
import org.apache.commons.lang3.StringUtils;

import java.util.List;


@ApplicationScoped
@Slf4j
public class PersonService {

    @Inject
    PersonRepository personRepository;

    public Response<Person> create(PersonDetailsRequest personDetailsRequest) {

        Person person = new Person();
        person.setFirstName(personDetailsRequest.getFirstName());
        person.setLastName(personDetailsRequest.getLastName());
        person.setAddress(personDetailsRequest.getAddress());
        person.setAge(personDetailsRequest.getAge());
        person.setGender(personDetailsRequest.getGender());

        personRepository.persist(person);

        if (personRepository.isPersistent(person)) {

            return Response.successfulResponse("Data Saved Successfully", person);
        }

        return Response.failedResponse("Error occurred while saving data");
    }

    public Response<List<Person>> getAll() {

        return Response.successfulResponse("Users", personRepository.listAll());
    }

    public Response<Person> getAll(Long userId) {

        var userDetails = personRepository.findByIdOptional(userId)
                .orElseThrow(() -> new ApplicationException(HttpResponseStatus.BAD_REQUEST, "User not with" + userId + "not found"));

        return Response.successfulResponse("User Details", userDetails);
    }

    public Response<Person> update(Long userId, PersonDetailsRequest personDetailsRequest) {
        log.info("Id {}, person details {}", userId, personDetailsRequest);
        var userDetails = personRepository.findByIdOptional(userId)
                .orElseThrow(() -> new ApplicationException(HttpResponseStatus.BAD_REQUEST, "User not with" + userId + "not found"));

        if (StringUtils.isNotEmpty(personDetailsRequest.getFirstName())) {
            userDetails.setFirstName(personDetailsRequest.getFirstName());
        }

        if (StringUtils.isNotEmpty(personDetailsRequest.getLastName())) {
            userDetails.setLastName(personDetailsRequest.getLastName());
        }

        if (StringUtils.isNotEmpty(personDetailsRequest.getGender().name())) {
            userDetails.setGender(personDetailsRequest.getGender());
        }

        if (StringUtils.isNotEmpty(personDetailsRequest.getAddress())) {
            userDetails.setAddress(personDetailsRequest.getAddress());
        }

        personRepository.persist(userDetails);
        if (personRepository.isPersistent(userDetails)) {

            return Response.successfulResponse("Data Updated Successfully", userDetails);
        }

        return Response.failedResponse("Error occurred while saving data");
    }


    public Response<Person> delete(Long userId) {
        log.info("Id {}, person details {}", userId);

        if (personRepository.deleteById(userId)) {

            return Response.successfulResponse("Data Deleted Successfully");
        }

        return Response.failedResponse("Error occurred while deleting data");
    }

}
