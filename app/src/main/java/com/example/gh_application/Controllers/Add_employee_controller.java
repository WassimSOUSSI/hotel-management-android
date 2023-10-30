package com.example.gh_application.Controllers;

import com.example.gh_application.Models.Employee_Model;

public class Add_employee_controller {
    public void add_Employee(Employee_Model model){
        Employee_Model.add_Item(model);
    }
}
