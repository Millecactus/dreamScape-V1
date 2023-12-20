//package com.example.User;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//
//public class RegisterServlet extends HttpServlet {
//    private static final String INSERT_QUERY ="INSERT INTO user_dto(firstname,lastname,email) VALUES(?,?,?,?)";
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        //get prinwriter
//        PrintWriter pw = resp.getWriter();
//
//        //setPrintWriter
//        resp.setContentType("text/html");
//
//        //read Form Values CELA DOIT CORRESPONDRE AU CHAMP NAME DE ATTRIBUT HTML !!!
//        String firstname = req.getParameter("firstname");
//        String lastname = req.getParameter("lastname");
//        String email = req.getParameter("email");
//
//        //load the jdbc driver
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        //create the connection
//        try(Connection con = DriverManager.getConnection("jdbc:mysql:///firstdb","root","root");
//            PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
//            //set the values
//            ps.setString(1, firstname);
//            ps.setString(2, lastname);
//            ps.setString(3, email);
//            //execute the query
//            int count = ps.executeUpdate();
//
//            if(count==0) {
//                pw.println("Record not stored into database");
//            }else {
//                pw.println("Record Stored into Database");
//            }
//        }catch(SQLException se) {
//            pw.println(se.getMessage());
//            se.printStackTrace();
//        }catch(Exception e) {
//            pw.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//
//        System.out.print(firstname + " " + lastname + " " + email);
//
//        //close the stream
//        pw.close();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//}
