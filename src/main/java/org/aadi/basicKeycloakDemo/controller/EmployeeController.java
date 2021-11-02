package org.aadi.basicKeycloakDemo.controller;

import org.aadi.basicKeycloakDemo.model.Employee;
import org.aadi.basicKeycloakDemo.org.aadi.basicKeycloakDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    /* This method can be accessed by 'aadiuser', whose role is user inside Keycloak server.
     * Also 'manager' can access this method, as manager hasbeen assigned both role - user & admin inside Keycloak. */

    @GetMapping("/{employeeId}")
    @RolesAllowed("user")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        return ResponseEntity.ok(service.getEmployee(employeeId));
    }

    /* This method can be accessed by 'myadmin', whose role is admin inside Keycloak server.
     * Also 'manager' can access this method, as manager hasbeen assigned both role - user & admin inside Keycloak. */

    @GetMapping
    @RolesAllowed("admin")
    public ResponseEntity<List<Employee>> findALlEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }
}
