package com.example.gh_application.Controllers;

import com.example.gh_application.Models.Reservation_Model;

public class CRUD_dialog_controller {

    public void deleteReservation(int itemId) {
        Reservation_Model.delete_Item(itemId);
    }

    public void modifyReservation(int itemId, Reservation_Model newValue) {
        Reservation_Model.modify_Item(itemId,newValue);
    }
}
