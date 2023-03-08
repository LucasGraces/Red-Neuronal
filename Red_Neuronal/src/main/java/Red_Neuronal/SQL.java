package Red_Neuronal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class SQL {
    
    ArrayList<String> ids = new ArrayList<>();
    ArrayList<String> pas = new ArrayList<>();
    
    
    //String parametro;
    String temp_amb;
    String edad;
    String kg;
    String lt;
    String resp_por_min;
    String cordinacion;
    String res;
    String kg_por_dia;
    String temperatura;

    String pass = null;
    String tel = null;
    String dir = null;
    String nom = null;
    String id = null;
    
    String nuevo = null;
    
    int val;
    
    int vales;
    int dato;
    
    static String user = "root";
    static String pwd = "lenovo";
    static Connection cn = null;
    public static boolean status = false;
    


    public static Connection conexion(){
        status = false;
        String bd = "vacas";
        String servidor = "localhost:3306";
        String url = "jdbc:mysql://" +servidor +"/" +bd;
        try{
            cn = DriverManager.getConnection(url,user,pwd);
            status = true;
        }catch (SQLException e){
             JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return cn;
    }

    public boolean entrada_empresa(){
        try{
            CallableStatement cst = conexion().prepareCall("{call registrar_usuario(?,?,?,?) }");

            cst.setString(1,nom);
            cst.setString(2,pass);
            cst.setString(3,dir);
            cst.setString(4,tel);
            cst.executeUpdate();
            return true;

        }
        catch(java.sql.SQLException exep){
            System.out.println(exep.getErrorCode());
            return false;
        }

    }
    public boolean eliminar_usuario(){
        try{
            CallableStatement cst = conexion().prepareCall("{call eliminar_usuario(?)}");

            cst.setString(1,id);
            cst.executeUpdate();
            return true;
        }
        catch(java.sql.SQLException exep){
            System.out.println(exep.getErrorCode());
            return false;
        }


    }
    
    public void agregar_registro(){
        try{
            CallableStatement cst = conexion().prepareCall("{call agregar_registro(?,?,?,?,?,?,?,?,?) }");
            
            cst.setString(1,temp_amb);
            cst.setString(2,cordinacion);
            cst.setString(3,resp_por_min);
            cst.setString(4,edad);
            cst.setString(5,kg);
            cst.setString(6,kg_por_dia);
            cst.setString(7,lt);
            cst.setString(8,temperatura);
            cst.setString(9,res);
            cst.executeUpdate();
        }
        catch(java.sql.SQLException exep){
            System.out.println(exep.getErrorCode());
        }
    }
    
    
    public boolean modificar_usuario(){
        try{
            CallableStatement cst = conexion().prepareCall("{call modificar_usuario(?,?,?)}");
            
            cst.setInt(1,val);
            cst.setString(2,id);
            cst.setString(3,nuevo);
            cst.executeUpdate();
            return true;
        }
        catch(java.sql.SQLException exep){
            System.out.println(exep.getErrorCode());
            return false;
        }

    }

    
    public  void leer(){
        try{
            String sql = "{call muestra_registros()}";
            
            CallableStatement cst = conexion().prepareCall(sql);
            
            ResultSet consulta = cst.executeQuery(sql);
            
            while(consulta.next()){
                int em10 = consulta.getInt("id_registro");
                int em9 = consulta.getInt("temperatura_ambiente");
                int em8 = consulta.getInt("coordinacion");
                int em7 = consulta.getInt("respiraciones_por_minuto");
                int em6 = consulta.getInt("edad");
                int em5 = consulta.getInt("peso");
                int em4 = consulta.getInt("kg_por_dia");
                int em3 = consulta.getInt("lt_por_dia");
                int em2 = consulta.getInt("temp_corporal");
                int em1= consulta.getInt("resutlado");
                System.out.println("id:"+em10+" -Temperatura del ambiente: "+em9+" -Coordinacion: "+em8+" -Respiraciones por min: "+em7+" -Edad: "+em6+" -Peso: "+em5+" -Kg x dia: "+em4+" -Lt x dia: "+em3+" -Temperatura: "+em2+" -Resultado: "+em1);
            }
                     
        }
        catch(java.sql.SQLException exep){
            System.out.println(exep.getErrorCode());
        }

    }
    
    public  void muestra_x_ids(){
        try{
            String sql = "{call muestra_ids()}";
            
            CallableStatement cst = conexion().prepareCall(sql);
            
            ResultSet consulta = cst.executeQuery(sql);
            
            while(consulta.next()){
                int em10 = consulta.getInt("id_registro");
                int em9 = consulta.getInt("temperatura_ambiente");
                int em8 = consulta.getInt("coordinacion");
                int em7 = consulta.getInt("respiraciones_por_minuto");
                int em6 = consulta.getInt("edad");
                int em5 = consulta.getInt("peso");
                int em4 = consulta.getInt("kg_por_dia");
                int em3 = consulta.getInt("lt_por_dia");
                int em2 = consulta.getInt("temp_corporal");
                int em1= consulta.getInt("resutlado");
                System.out.println("id:"+em10+" -Temperatura del ambiente: "+em9+" -Coordinacion: "+em8+" -Respiraciones por min: "+em7+" -Edad: "+em6+" -Peso: "+em5+" -Kg x dia: "+em4+" -Lt x dia: "+em3+" -Temperatura: "+em2+" -Resultado: "+em1);
            }
                     
        }
        catch(java.sql.SQLException exep){
            System.out.println(exep.getErrorCode());
        }

    }
    public  void muestra_x_resultado(){
        try{
            String sql = "{call muestra_resultados()}";
            
            CallableStatement cst = conexion().prepareCall(sql);
            
            ResultSet consulta = cst.executeQuery(sql);
            
            while(consulta.next()){
                int em10 = consulta.getInt("id_registro");
                int em9 = consulta.getInt("temperatura_ambiente");
                int em8 = consulta.getInt("coordinacion");
                int em7 = consulta.getInt("respiraciones_por_minuto");
                int em6 = consulta.getInt("edad");
                int em5 = consulta.getInt("peso");
                int em4 = consulta.getInt("kg_por_dia");
                int em3 = consulta.getInt("lt_por_dia");
                int em2 = consulta.getInt("temp_corporal");
                int em1= consulta.getInt("resutlado");
                System.out.println("id:"+em10+" -Temperatura del ambiente: "+em9+" -Coordinacion: "+em8+" -Respiraciones por min: "+em7+" -Edad: "+em6+" -Peso: "+em5+" -Kg x dia: "+em4+" -Lt x dia: "+em3+" -Temperatura: "+em2+" -Resultado: "+em1);
            }
                     
        }
        catch(java.sql.SQLException exep){
            System.out.println(exep.getErrorCode());
        }

    }
    
    
    public  void id_password(){
        try{
            String sql = "{call id_password()}";
            
            CallableStatement cst = conexion().prepareCall(sql);
            
            ResultSet consulta = cst.executeQuery(sql);
            
            while(consulta.next()){
                String idd = consulta.getString("id_usuario");
                String par = consulta.getString("contraseña");
                ids.add(idd);
                pas.add(par);
            }
                     
        }
        catch(java.sql.SQLException exep){
            System.out.println(exep.getErrorCode());
        }

    }
    
    
    public boolean modificar_parametros(){
        try{
            CallableStatement cst = conexion().prepareCall("{call modificar_parametros(?,?)}");
            
            cst.setInt(1,vales);
            cst.setInt(2,dato);
            cst.executeUpdate();
            return true;
        }
        catch(java.sql.SQLException exep){
            System.out.println(exep.getErrorCode());
            return false;
        }

    }
    
    

}




