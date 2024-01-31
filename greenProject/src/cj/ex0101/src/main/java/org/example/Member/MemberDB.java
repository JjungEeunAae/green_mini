package org.example.member;

import org.example.DBinfo;
import org.example.member.Member;
import org.example.member.MemberCLI;

import java.net.ConnectException;
import java.sql.*;

public class MemberDB {
    private MemberCLI mc = new MemberCLI();
    public void insert() {

        Member member = mc.signupInput();
        boolean result = findByEmail(member.getEmail());

        if (!result) {
            Connection con = null;
                try {
                    con = DriverManager.getConnection(DBinfo.url, DBinfo.user, DBinfo.password);
                    PreparedStatement pstmt
                            = con.prepareStatement("insert into member " +
                            "(email, password, name, sign_date) " +
                            "values " +
                            "(?,?,?,now()) ");

                    pstmt.setString(1, member.getEmail());
                    pstmt.setString(2, member.getPassword());
                    pstmt.setString(3, member.getName());

                    pstmt.executeUpdate();
                    System.out.println("입력되었습니다.");

                } catch (Exception e) {
                    System.out.println("예외발생");
                    e.printStackTrace();
                  } finally {
                        if (con != null);
                            try {
                                con.close();
                            } catch (SQLException e) {
                                 e.printStackTrace();
                              }
                    }

        }
    }
    public boolean findByEmail(String email) {
        MemberCLI mc = new MemberCLI();

        try {
            Connection con = DriverManager.getConnection(DBinfo.url, DBinfo.user, DBinfo.password);
            PreparedStatement pstmt = con.prepareStatement("select * from member where email=?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Member loginInput() {
    Member member = mc.loginInput();
    String str1 = member.getName() + "님 반갑습니다.";

        try{
        Connection con = DriverManager.getConnection(DBinfo.url, DBinfo.user, DBinfo.password);
        PreparedStatement pstmt = con.prepareStatement(
                             "SELECT * FROM member " +
                                 "WHERE email=? AND PASSWORD=?");

        pstmt.setString(1, member.getEmail());
        pstmt.setString(2, member.getPassword());
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            if(rs.getString("email").equals(member.getEmail()) && rs.getString("password").equals(member.getPassword())) {
                System.out.println(member.getName() + "님 반갑습니다.");
            }
        }
        else{
            System.out.println("로그인실패 이메일과 패스워드를 확인하세요...");
          }
        } catch (Exception e){
            e.printStackTrace();
          }
        return null;
}


}
