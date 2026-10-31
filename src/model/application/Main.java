package model.application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number : ");
        int number = ler.nextInt();
        ler.nextLine();
        System.out.println("CheckIn date (dd/MM/yyyy)");
        LocalDate checkIn = LocalDate.parse(ler.nextLine(),fmt);
        System.out.println("CheckOut date (dd/MM/yyyy)");
        LocalDate checkOut = LocalDate.parse(ler.nextLine(),fmt);

        if(!checkOut.isAfter(checkIn)){
            System.out.println("Error in reservation : CheckOut must be after checkIn date");
        }
        else{
            Reservation reservation = new Reservation(number,checkIn,checkOut);
            System.out.println("Reservation: "+reservation);

            System.out.println("\nEnter data to update the reservation");
            System.out.println("CheckIn date (dd/MM/yyyy)");
            checkIn = LocalDate.parse(ler.nextLine(),fmt);
            System.out.println("CheckOut date (dd/MM/yyyy)");
            checkOut = LocalDate.parse(ler.nextLine(),fmt);

                String error = reservation.updateDates(checkIn,checkOut);
                if(error != null){
                    System.out.println("Error in reservation : "+error);
                }
                else{
                    System.out.println("Reservation: "+reservation);
                }



//Versao muito ruim exceptions tudo na classe main
        }






        }
    }
