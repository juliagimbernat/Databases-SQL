import java.sql.*;

public class test {
    public static void main(String args[]) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Connection conn=DriverManager.getConnection(dbUrl, "postgres", "1999mandarina");

        try {
            Statement s=conn.createStatement();
            String sqlStr = "INSERT INTO patientofdoctor (patientid,doctorid) values (1,2);";
            s.execute (sqlStr);
            sqlStr = "INSERT INTO patientofdoctor (patientid,doctorid) values (2,2);";
            s.execute (sqlStr);
            s.close();
        }
        catch (Exception e){
        }

        try {
            Statement s=conn.createStatement();
            String sqlStr = "SELECT * FROM patients WHERE id>1;";
            ResultSet rset=s.executeQuery(sqlStr);
            while(rset.next()){
                System.out.println(rset.getInt("id")+" "+ rset.getString("familyname"));
            }
            rset.close();
            s.close();
        }
        catch (Exception e){
            System.out.println( e.getMessage() );
        }

        try {
            Statement s=conn.createStatement();
            String sqlStrr = "SELECT * FROM doctors WHERE id>1;";
            ResultSet rsett=s.executeQuery(sqlStrr);
            while(rsett.next()){
                System.out.println(rsett.getInt("id")+" "+ rsett.getString("familyname"));
            }

        }catch (Exception e){
        }
    }
}
