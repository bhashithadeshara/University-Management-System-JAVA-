/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ProfessoR
 */
public class CalculateLectureSalaryClass implements result{
    
    private String username = GpuForm1.txtUsername.getText();
    int hours = Integer.parseInt(GpuForm1.txtHours.getText());
    
    public String getUsername(){
        return username;
    }
    
    double salary;
    
    public CalculateLectureSalaryClass(){
        if(hours <= 50){
            salary = 80000;
        }else if(hours <= 100){
            salary = 1000000;
        }else{
            salary = 2000000;
        }
    }
    
    public double finalSalary(){
        return salary * 12 / 75;
    }

    @Override
    public void result() {
        CalculateLectureSalary.lblSalary.setText("Salary is " + finalSalary());
    }
    
    public void getInfo(){
        CalculateLectureSalary.lblUsername.setText("Username is " + getUsername());
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject2", "root", "");
            
            String queryStr = "SELECT * from lecture WHERE username = '"+username+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryStr);
            
            while(rs.next()){
                String faculty = rs.getString(5);
                CalculateLectureSalary.lblFaculty.setText("Faculty is " + faculty);
            }
            
             
            con.close();
            rs.close();
            stmt.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Sql Error Occured! " +e, "Alert", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error Occured! " +ex, "Alert", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    
}
