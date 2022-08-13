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
public class CalculateStudentGpu implements result{
            
    
    int sub1 = Integer.parseInt(GpuForm.txtSubject1.getText());
    int sub2 = Integer.parseInt(GpuForm.txtSubject2.getText());
    int sub3 = Integer.parseInt(GpuForm.txtSubject3.getText());
    int sub4 = Integer.parseInt(GpuForm.txtSubject4.getText());
    int sub5 = Integer.parseInt(GpuForm.txtSubject5.getText());
    
        
    private String username = GpuForm.txtUsername.getText();
    
    public String getUsername(){
        return username;
    }
       
    
    int gpu1;
    int gpu2;
    int gpu3;
    int gpu4;
    int gpu5;
    
    int totalGpu;
    
    
    public CalculateStudentGpu(){
        if(sub1 <= 20){
            gpu1 = 10;
        }else if(sub1 <= 40){
            gpu1 = 20;
        }else if(sub1 <= 60){
            gpu1 = 30;
        }else if(sub1 <= 80){
            gpu1 = 40;
        }else{
            gpu1 = 50;
        }
        if(sub2 <= 20){
            gpu2 = 10;
        }else if(sub2 <= 40){
            gpu2 = 20;
        }else if(sub2 <= 60){
            gpu2 = 30;
        }else if(sub2 <= 80){
            gpu2 = 40;
        }else{
            gpu2 = 50;
        }

        if(sub3 <= 20){
            gpu3 = 10;
        }else if(sub3 <= 40){
            gpu3 = 20;
        }else if(sub3 <= 60){
            gpu3 = 30;
        }else if(sub3 <= 80){
            gpu3 = 40;
        }else{
            gpu3 = 50;
        }

        if(sub4 <= 20){
            gpu4 = 10;
        }else if(sub4 <= 40){
            gpu4 = 20;
        }else if(sub4 <= 60){
            gpu4 = 30;
        }else if(sub4 <= 80){
            gpu4 = 40;
        }else{
            gpu4 = 50;
        }

        if(sub5 <= 20){
            gpu5 = 10;
        }else if(sub5 <= 40){
            gpu5 = 20;
        }else if(sub5 <= 60){
            gpu5 = 30;
        }else if(sub5 <= 80){
            gpu5 = 40;
        }else{
            gpu5 = 50;
        }               

        
    }

    @Override
    public void result() {
         totalGpu = gpu1 + gpu2 + gpu3 + gpu4 + gpu5;
         CalculateFormStudent.lblGpu.setText("Gpu is " + Integer.toString(totalGpu));
    }
    
    
    
    // We call this overloading......
    public void getInfo(){
        CalculateFormStudent.lblUsername.setText("Username is " + getUsername());
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject2", "root", "");
            
            String queryStr = "SELECT * FROM student WHERE username = '"+getUsername()+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryStr);
            
            while(rs.next()){               
                String degree = rs.getString(5);    
                
                CalculateFormStudent.lblDegree.setText("Degree : " + degree);
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
