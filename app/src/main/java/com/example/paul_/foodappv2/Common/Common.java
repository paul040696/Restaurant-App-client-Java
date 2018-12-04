package com.example.paul_.foodappv2.Common;

import com.example.paul_.foodappv2.Model.User;

public class Common {

    public static User currentUser;

    public static String converteCodeToStatus(String status) {
        if(status.equals("0"))
            return "Comanda plasata";
        else if(status.equals("1"))
            return "Comanda in curs de lvirare";
        else
            return "Comanda livrata";
    }
}
