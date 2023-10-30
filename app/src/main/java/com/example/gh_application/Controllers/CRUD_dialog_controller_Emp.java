package com.example.gh_application.Controllers;

import com.example.gh_application.Models.Employee_Model;

public class CRUD_dialog_controller_Emp {
    public void deleteEmployee(int itemId) {
        Employee_Model.delete_Item(itemId);
    }

    public void modifyEmployee(int itemId, Employee_Model newValue) {
        Employee_Model.modify_Item(itemId,newValue);
    }
}
