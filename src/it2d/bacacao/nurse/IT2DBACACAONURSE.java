package it2d.bacacao.nurse;

import java.util.Scanner;


public class IT2DBACACAONURSE {


     public static void main(String[] args) {
        
        
           Scanner sc = new Scanner(System.in);
           String response;
           do{
        
         System.out.println("\nNurse");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
       
     System.out.print("Enter action: ");
            int action = sc.nextInt();
            IT2DBACACAONURSE nurse = new IT2DBACACAONURSE ();
            switch(action){
                case 1:
                    nurse.addnurse();
                break;
                
                case 2:
                    nurse. viewnurse();
                    break;
                    
                case 3:
                    nurse. viewnurse();
                    nurse. updatenurse();
                    nurse. viewnurse();
                    break;
                
                case 4:
                    nurse. viewnurse();
                    nurse. deletenurse();
                    nurse. viewnurse();
                    break;
                    
                case 5:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("Invalid actiopn. Please try again.");
                   
           
            }
             System.out.println("Do you want to continue? (yes/no): ");
             response = sc.next();
                    
           }while(response.equalsIgnoreCase("yes"));
           System.out.println("Thank You! ");
    }
               public void addnurse(){
        Scanner sc = new Scanner(System.in);
   
        System.out.print("firse Name: ");
        String fname = sc.next();
        System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("department: ");
        String department = sc.next();
        System.out.print("Contact Number: ");
        String cnum = sc.next();
        System.out.print("Shift: ");
        String shift = sc.next();

        String sql = "INSERT INTO tbl_nurse (f_name, l_name, department, contact_number, shift) VALUES (?, ?, ?, ?,?)";
        config conf = new config();
        conf.addRecord(sql, fname, lname, department, cnum, shift);
              
     }
          
      private void viewnurse() {
       
        String qry = "SELECT * FROM tbl_nurse";
        String[] hrds = {"ID" ,"first name", "last name", "department", "contact_number", "shift"};
        String[] clm = {"nurse_id", "f_name", "l_name", "department", "contact_number", "shift"};
        
        config conf = new config();
        
        conf.viewRecords(qry, hrds, clm);
    }
   
    
    private void updatenurse(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the id to update: ");
        int id = sc.nextInt();
       
        System.out.print("firse Name: ");
        String fname = sc.next();
        System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("department: ");
        String department = sc.next();
        System.out.print("Contact Number: ");
        String cnum = sc.next();
        System.out.print("Shift: ");
        String shift = sc.next();

        String qry = "UPDATE tbl_nurse SET f_name = ?, l_name = ?, department = ?, contact_number = ?, shift = ? = ? WHERE p_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, fname, lname, department, cnum, shift, id);
        
    }
    
      private void deletenurse() {
          Scanner sc = new Scanner(System.in);
          
          System.out.println("Enter the id to delete");
          int id = sc.nextInt();
          
          String qry = "DELETE FROM tbl_nurse WHERE p_id = ?";
          
          config conf = new config();
          conf.deleteRecord(qry,id);
          
    }


      }