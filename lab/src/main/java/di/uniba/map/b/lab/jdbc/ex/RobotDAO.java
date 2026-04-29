/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.jdbc.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pierpaolo
 */
public class RobotDAO {

    private final Connection connection;

    /**
     *
     * @param connection
     */
    public RobotDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param nome
     * @param potenza
     * @param difesa
     * @throws SQLException
     */
    public void aggiungiRobot(String nome, int potenza, int difesa) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO robot(nome, potenza, difesa) VALUES (?, ?, ?)");
        stm.setString(1, nome);
        stm.setInt(2, potenza);
        stm.setInt(3, difesa);
        stm.executeUpdate();
        stm.close();
    }

    /**
     *
     * @return @throws SQLException
     */
    public List<Robot> getTuttiIRobot() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM robot");
        List<Robot> list = new ArrayList<>();
        while (rs.next()) {
            list.add(Robot.createFromResultSet(rs));
        }
        rs.close();
        stm.close();
        return list;
    }

    /**
     *
     * @return @throws SQLException
     */
    public Robot getRobotPiuForte() throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT id, nome, potenza, difesa FROM robot ORDER BY (difesa+potenza) DESC");
        Robot robot = null;
        if (rs.next()) {
            robot = Robot.createFromResultSet(rs);
        }
        rs.close();
        stm.close();
        return robot;
    }

    /**
     *
     * @param robot1
     * @param robot2
     * @param winner
     * @throws SQLException
     */
    public void inserisciBattaglia(int robot1, int robot2, int winner) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO battle(robot1, robot2, winner) VALUES (?, ?, ?)");
        stm.setInt(1, robot1);
        stm.setInt(2, robot2);
        stm.setInt(3, winner);
        stm.executeUpdate();
        stm.close();
    }

    /**
     *
     * @param best
     * @return
     * @throws SQLException
     */
    public int classifica(boolean best) throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs;
        if (best) {
            rs = stm.executeQuery("SELECT winner, COUNT(*) AS m FROM battle GROUP BY winner ORDER BY m DESC");
        } else {
            rs = stm.executeQuery("SELECT winner, COUNT(*) AS m FROM battle GROUP BY winner ORDER BY m ASC");
        }
        int winner = -1;
        if (rs.next()) {
            winner = rs.getInt("winner");
            System.out.println(rs.getInt("m"));
        }
        rs.close();
        stm.close();
        return winner;
    }
    
    public void cleanTable() throws SQLException {
        Statement stm = connection.createStatement();
        stm.executeUpdate("TRUNCATE TABLE robot");
        stm.executeUpdate("TRUNCATE TABLE battle");
        stm.close();
    }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        return connection;
    }

}
