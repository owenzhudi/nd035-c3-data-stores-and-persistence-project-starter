package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleService {
    private ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> findSchedulesByPet(Pet pet) {
        return scheduleRepository.findByPets(pet);
    }

    public List<Schedule> findSchedulesByEmployee(Employee employee) {
        return scheduleRepository.findByEmployees(employee);
    }

    public List<Schedule> findSchedulesByCustomer(Customer customer) {
        return scheduleRepository.findByCustomers(customer);
    }
}
