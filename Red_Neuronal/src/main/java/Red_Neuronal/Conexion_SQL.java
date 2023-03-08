package Red_Neuronal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Conexion_SQL{
    public static void main(String[] args) {
        perceptron per=new perceptron();
        SQL sql = new SQL();
        Usuario usu = new Usuario();
        
        
       JFrame ventana=new JFrame("logueo");        
        ventana.setBounds(0, 200, 500, 300);
        ventana.setLayout(null);

        JButton btn1 = new JButton("Iniciar sesion");
        btn1.setBounds(200, 50, 130 , 30);
        
        JButton btn2 = new JButton("Registrar");
        btn2.setBounds(200, 100, 130 , 30);
        
        JButton sal = new JButton("Salir");
        sal.setBounds(400, 230,70, 20);
        
        
        JButton gu = new JButton("Gestion de usuario");
        gu.setBounds(200, 50, 205 , 30);
        
        JButton btn = new JButton("Generar pronostico del bovino");
        btn.setBounds(200, 100, 205 , 30);
        
        JButton btn5 = new JButton("Mostrar registros");
        btn5.setBounds(200, 150, 205 , 30);
        
        JButton mod = new JButton("Modificar parametros");
        mod.setBounds(200, 200, 205 , 30);
        
        
        JButton btn3 = new JButton("Modificar usuario");
        btn3.setBounds(200, 50, 150 , 30);
        
        JButton btn4 = new JButton("Eliminar usuario");
        btn4.setBounds(200,100, 150 , 30);
        
        
        
        JButton res1 = new JButton("Modificar reulstado");
        res1.setBounds(200, 50, 220 , 30);
        
        JButton ids2 = new JButton("Modificar cantidad de registros");
        ids2.setBounds(200, 100, 220 , 30);
        
        JButton non3 = new JButton("Modificar coordinacion");
        non3.setBounds(200, 150, 220 , 30);
        

        
        

        

    
        ventana.add(btn1);
        ventana.add(btn2);
        ventana.add(sal);
        
        
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        
        btn1.addActionListener((ActionEvent e) -> {
            
            JFrame v3 = new JFrame("Inicio de sesion"); //Ventana Inicio de sesion
            v3.setBounds(0, 200, 500, 300);
            v3.setLayout(null);
            
            
            JLabel IN=new JLabel("Inicio de sesion. ");
            IN.setBounds(50,10,130,30);
            
            JLabel nu=new JLabel("Ingrese id de usuario");
            nu.setBounds(100,50, 160, 30);
            
            JTextField id=new JTextField();
            id.setBounds(100,75, 160, 20);
            
            JLabel con=new JLabel("Ingrese contraseña");
            con.setBounds(100,100, 160, 30);
            
            JTextField co=new JTextField();
            co.setBounds(100,125, 160, 20);
            
            JButton reg = new JButton("Iniciar sesion");
            reg.setBounds(200, 200, 130 , 30);
            
            
            v3.add(IN);
            v3.add(nu);
            v3.add(id);
            v3.add(con);
            v3.add(co);
            v3.add(reg);
            
            
            v3.setVisible(true);
            v3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reg.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                    
                    
                    usu.password=co.getText();
                    usu.sid= id.getText();
                    if(usu.Validar_id() == true && usu.validar_usuario() == true){
                        if(usu.Buscar_id_password()== true){
                            JFrame ac = new JFrame("Acceso"); 
                            ac.setBounds(0, 200, 500, 300);
                            ac.setLayout(null);

                            ac.add(gu);
                            ac.add(btn);
                            ac.add(btn5);
                            ac.add(mod);
                            
                            
                            gu.addActionListener( new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {                    
                                    JFrame geu = new JFrame("Gestion Usuario"); 
                                    geu.setBounds(0, 200, 500, 300);
                                    geu.setLayout(null);
                                    
                                    
                                    geu.add(btn3);
                                    geu.add(btn4);
                                    
                                    geu.setVisible(true);
                                    geu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    ac.dispose();
                                };
                            });
                            
                            
                            mod.addActionListener( new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {                    
                                    JFrame geu = new JFrame("Modificar parametros"); 
                                    geu.setBounds(0, 200, 500, 300);
                                    geu.setLayout(null);
                                    
                                    
                                    geu.add(res1);
                                    geu.add(ids2);
                                    geu.add(non3);
                                    
                                    geu.setVisible(true);
                                    geu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    ac.dispose();
                                };
                            });
                            

                            ac.setVisible(true);
                            ac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        }
                    }
                    if(usu.Buscar_id_password() == false){
                        JOptionPane.showMessageDialog(null,"Ingreso los datos incorrectos"); 
                    }
                    v3.dispose();
                };
            });
            
            
        });

            

        btn.addActionListener((ActionEvent e) -> {            //Prediccion de la red y agrega el registro a la bd
            ventana.dispose();
            JFrame v2 = new JFrame("Entradas");
            v2.setBounds(0, 200, 1900, 1800);
            
            v2.setLayout(null);
            
            JLabel lbl0=new JLabel(" INGRESE: ");
            lbl0.setBounds(170,70,130,40);
            
            
            JLabel lbl1=new JLabel(" Temperatura del ambiente:");
            lbl1.setBounds(217,100,180,40);            
            JTextField temp_amb=new JTextField();
            temp_amb.setBounds(400,110,130,20);
            
            
            JLabel lbl3=new JLabel(" Respiraciones por minuto:");            
            lbl3.setBounds(223,110,200,100);                        
            JTextField resp_por_min=new JTextField();
            resp_por_min.setBounds(400,152,130,20);
            
            
            JLabel lbl2=new JLabel("Temperatura corporal: ");
            lbl2.setBounds(248, 150, 160,100);            
            JTextField temp_corp=new JTextField();
            temp_corp.setBounds(400,190,130,20);
            
            
            JLabel lbl4=new JLabel(" Nivel de coordinacion(1 para buena,2 para meiana, 3 para mala):");
            lbl4.setBounds(10,220,500,40);            
            JTextField coor=new JTextField();
            coor.setBounds(400,230,130,20);
            
            
            JLabel lbl6=new JLabel(" Edad del animal:");
            lbl6.setBounds(280,250,150,60);            
            JTextField edad=new JTextField();
            edad.setBounds(400,270,130,20);
            
            
            JLabel lbl5=new JLabel(" Peso del animal:");
            lbl5.setBounds(280,285,300,60);            
            
            JTextField peso=new JTextField();
            peso.setBounds(400,305,100,20);
            
            
            JLabel lbl8=new JLabel("Kgs por dia que bebe el animal:");
            lbl8.setBounds(203,320,300,60);                        
            JTextField kgs=new JTextField();
            kgs.setBounds(400,340,100,20);
            
            
            
            JLabel lbl7=new JLabel("Lts por dia que bebe el animal:");
            lbl7.setBounds(200,365,300,60);            
            JTextField lts=new JTextField();
            lts.setBounds(400,377,100,20);
            
            
            JButton cal = new JButton("Calcular:");
            cal.setBounds(170, 500, 190 , 20);
            
            
            v2.add(lbl0);
            v2.add(lbl1);
            v2.add(temp_amb);            
            v2.add(lbl2);
            v2.add(temp_corp);            
            v2.add(lbl3);
            v2.add(resp_por_min);            
            v2.add(lbl4);
            v2.add(coor);            
            v2.add(lbl5);
            v2.add(peso);            
            v2.add(lbl6);
            v2.add(edad);            
            v2.add(lbl7);
            v2.add(lts);            
            v2.add(lbl8);
            v2.add(kgs);            
            v2.add(cal);
            
            
            v2.setVisible(true);
            v2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
            cal.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    
                    String l =coor.getText();
                    usu.entradas.add(l);
                    String f = temp_amb.getText();
                    usu.entradas.add(f);
                    String h = temp_corp.getText();
                    usu.entradas.add(h); 
                    String g = resp_por_min.getText();
                    usu.entradas.add(g);
                    String m = peso.getText();
                    usu.entradas.add(m);
                    String n = edad.getText();
                    usu.entradas.add(n);
                    String v = lts.getText();
                    usu.entradas.add(v);
                    String c = kgs.getText();
                    usu.entradas.add(c);
                    
                    if(usu.validar_entradas() == true){
                        sql.cordinacion=coor.getText();
                        sql.temp_amb=temp_amb.getText();
                        sql.temperatura=temp_corp.getText();
                        sql.resp_por_min=resp_por_min.getText();
                        sql.kg=peso.getText();
                        sql.edad=edad.getText();
                        sql.lt=lts.getText();
                        sql.kg_por_dia=kgs.getText();

                        per.coor=Double.parseDouble(coor.getText());   
                        per.temp_amb=Double.parseDouble(temp_amb.getText());
                        per.temp_corp=Double.parseDouble(temp_corp.getText());
                        per.resp_por_min=Double.parseDouble(resp_por_min.getText());
                        per.peso=Double.parseDouble(peso.getText());
                        per.edad=Double.parseDouble(edad.getText());
                        per.lts_por_dia=Double.parseDouble(lts.getText());
                        per.kgs_por_dia=Double.parseDouble(kgs.getText());
                        per.entradas.clear();
                        per.entradas_nor.clear();
                        //per.salida.clear();
                        JOptionPane.showMessageDialog(null,"Su resultado es: " + per.ingresar_entradas());                    
                        sql.agregar_registro();//---------------------------------------------------------------------------------DESCOMENTAR-----------------------------------------------------------
                    }
                    if(usu.validar_entradas() == false){
                        JOptionPane.showMessageDialog(null,"Ingrese datos reales");
                    }
                    
                    v2.dispose();
                };
            });                                                        
        });
        
        
        
        
        btn2.addActionListener((ActionEvent e) -> {
            JFrame v2 = new JFrame("Registro");
            v2.setBounds(0, 200, 500, 500);
            
            v2.setLayout(null);
            JLabel lbl0=new JLabel(" INGRESE: ");
            lbl0.setBounds(170,70,130,40);
            
            JLabel lbl1=new JLabel(" Contraseña:");
            lbl1.setBounds(237,100,180,40);
            
            JTextField contra=new JTextField();
            contra.setBounds(320,110,130,20);
            
            JLabel lbl2=new JLabel("Direccion: ");
            lbl2.setBounds(248,110,200,100);
            
            JTextField dir=new JTextField();
            dir.setBounds(320,152,130,20);
            
            JLabel lbl3=new JLabel(" Telefono:");
            lbl3.setBounds(253, 150, 160,100);
            
            JTextField tel=new JTextField();
            tel.setBounds(320,190,130,20);
            
            JLabel lbl4=new JLabel(" Empresa:");
            lbl4.setBounds(250,220,500,40);
            
            JTextField empresa=new JTextField();
            empresa.setBounds(320,230,130,20);
            
            
            JButton reg = new JButton("Registrar:");
            reg.setBounds(250, 300, 190 , 20);
            
            v2.add(lbl0);
            v2.add(lbl1);
            v2.add(contra);
            
            v2.add(lbl2);
            v2.add(dir);
            
            v2.add(lbl3);
            v2.add(tel);
            
            v2.add(lbl4);
            v2.add(empresa);
            
            v2.add(reg);
            
            
            v2.setVisible(true);
            v2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reg.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                    
                    
                    sql.pass=contra.getText();   
                    sql.dir=dir.getText();
                    sql.tel=tel.getText();
                    sql.nom=empresa.getText();
                    String texto;
                    if (sql.entrada_empresa()==true)
                            texto="se guardo el usuario";
                    else
                        texto="error";
                    JOptionPane.showMessageDialog(null,texto);                    
                    sql.agregar_registro();
                    
                    v2.dispose();
                };
            });
            
            
        });
        
        
        
        btn3.addActionListener((ActionEvent e) -> {
            JFrame v3 = new JFrame("Registro");
            v3.setBounds(0, 200, 500, 500);
            
            
            JLabel modi=new JLabel(" Seleccione lo que quiere modificar: ");
            modi.setBounds(200,190,300,40);
            JButton tel = new JButton("Telefono");
            tel.setBounds(170, 230, 100 , 40);
            
            tel.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    sql.val = 1;
                }
            
            });
            


            JButton dir = new JButton("Direccion");
            dir.setBounds(340, 230, 100 , 40);
            
            dir.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    sql.val = 2;
                }
            
            });

            
            v3.setLayout(null);
            JLabel lbl0=new JLabel(" INGRESE: ");
            
            JLabel lbl1=new JLabel("Id de usuario a modificar:");
            lbl1.setBounds(175,100,180,40);
            lbl0.setBounds(170,70,130,40);
             JTextField id=new JTextField();
            id.setBounds(320,110,130,20);
            
            JLabel lbl2=new JLabel("Dato nuevo: ");
            lbl2.setBounds(248,110,200,100);
            
            JTextField nuevo=new JTextField();
            nuevo.setBounds(320,152,130,20);
            
            JButton reg = new JButton("cambiar:");
            reg.setBounds(250, 300, 190 , 20);
            
            v3.add(modi);
            v3.add(dir);
            v3.add(tel);
            v3.add(lbl0);
            v3.add(lbl1);
            v3.add(id);
            v3.add(lbl2);
            v3.add(nuevo);
            v3.add(reg);
            
            
            v3.setVisible(true);
            v3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reg.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                    
                    
                    sql.id=id.getText();   
                    sql.nuevo=nuevo.getText(); 
                    String texto;
                    if (sql.modificar_usuario()==true)
                            texto="se guardaron los cambios";
                    else
                        texto="error";
                    JOptionPane.showMessageDialog(null,texto);                    
                    sql.agregar_registro();
                    
                    v3.dispose();
                };
            });
            
            
        });
        
        
        
        btn4.addActionListener((ActionEvent e) -> {
            
            JFrame v3 = new JFrame("Registro");
            v3.setBounds(0, 200, 500, 500);
            
            v3.setLayout(null);
            JLabel lbl0=new JLabel(" INGRESE: ");
            
            JLabel lbl1=new JLabel("id de usuario a eliminar:");
            lbl1.setBounds(237,100,180,40);
            lbl0.setBounds(170,70,130,40);
             JTextField id=new JTextField();
            id.setBounds(320,110,130,20);
            
            JButton reg = new JButton("cambiar:");
            reg.setBounds(250, 300, 190 , 20);
            
            
            v3.add(lbl0);
            v3.add(lbl1);
            v3.add(id);
            v3.add(reg);
            
            
            v3.setVisible(true);
            v3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reg.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                    
                    
                    sql.id=id.getText();   
                    String texto;
                    if (sql.eliminar_usuario()==true)
                            texto="se elimino el usuario";
                    else
                        texto="error";
                    JOptionPane.showMessageDialog(null,texto);                    
                    sql.agregar_registro();
                    
                    v3.dispose();
                };
            });
            
            
        });
        
        
        
        btn5.addActionListener((ActionEvent e) -> {
            JFrame v3 = new JFrame("Registro");
            v3.setBounds(0, 200, 1900, 1800);
                    sql.leer();
                  
                    
                    v3.dispose();
      
            
        });
        
        sal.addActionListener((ActionEvent e) -> {
            ventana.dispose();
      
            
        });
        
        ids2.addActionListener((ActionEvent e) -> {
            JFrame mid = new JFrame("Modificar resultado");
            mid.setBounds(0, 200, 500, 500);
            sql.vales = 2;
            

            
            mid.setLayout(null);
            JLabel lbl0=new JLabel(" INGRESE: ");
            lbl0.setBounds(170,70,130,40);
            
            JLabel lbl1=new JLabel("Ingrese que resultado quiere ");
            lbl1.setBounds(175,100,180,40);
            
            JLabel lbl3=new JLabel("que muetre");
            lbl3.setBounds(175,110,180,40);
            
            JLabel lbl2=new JLabel("Dato nuevo: ");
            lbl2.setBounds(248,110,200,100);
            
            JTextField nuevo=new JTextField();
            nuevo.setBounds(320,152,130,20);
            
            JButton reg = new JButton("cambiar");
            reg.setBounds(250, 300, 190 , 20);
            
            
            mid.add(lbl0);
            mid.add(lbl3);
            mid.add(lbl1);
            mid.add(lbl2);
            mid.add(nuevo);
            mid.add(reg);
            
            
            mid.setVisible(true);
            mid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reg.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                    
                    
                   
                    sql.dato = Integer.parseInt(nuevo.getText()); 
                    String texto;
                    if (sql.modificar_parametros()==true)
                            texto="se guardaron los cambios";
                    else
                        texto="error";
                    JOptionPane.showMessageDialog(null,texto);                    
                    sql.modificar_parametros();
                    
                    mid.dispose();
                };
            });
            
            
        });
        
        res1.addActionListener((ActionEvent e) -> {
            JFrame mid = new JFrame("Modificar ids");
            mid.setBounds(0, 200, 500, 500);
            sql.vales = 1;
            

            
            mid.setLayout(null);
            JLabel lbl0=new JLabel(" INGRESE: ");
            lbl0.setBounds(170,70,130,40);
            
            JLabel lbl1=new JLabel("Ingrese la cantidad de registros");
            lbl1.setBounds(175,100,180,40);
            
            JLabel lbl3=new JLabel("que quiere que se muetre");
            lbl3.setBounds(175,110,180,40);
            
            JLabel lbl2=new JLabel("Dato nuevo: ");
            lbl2.setBounds(248,110,200,100);
            
            JTextField nuevo=new JTextField();
            nuevo.setBounds(320,152,130,20);
            
            JButton reg = new JButton("cambiar");
            reg.setBounds(250, 300, 190 , 20);
            
            
            mid.add(lbl0);
            mid.add(lbl3);
            mid.add(lbl1);
            mid.add(lbl2);
            mid.add(nuevo);
            mid.add(reg);
            
            
            mid.setVisible(true);
            mid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reg.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    
                    
                    sql.dato = Integer.parseInt(nuevo.getText()); 
                    String texto;
                    if (sql.modificar_parametros()==true)
                            texto="se guardaron los cambios";
                    else
                        texto="error";
                    JOptionPane.showMessageDialog(null,texto);                    
                    sql.modificar_parametros();
                    
                    mid.dispose();
                };
            });
            
            
        });
        
        non3.addActionListener((ActionEvent e) -> {
            JFrame mid = new JFrame("Modificar la coordinacion");
            mid.setBounds(0, 200, 500, 500);
            sql.vales = 3;
            

            
            mid.setLayout(null);
            JLabel lbl0=new JLabel(" INGRESE: ");
            lbl0.setBounds(170,70,130,40);
            
            JLabel lbl1=new JLabel("Ingrese que resultados quiere que muestre");
            lbl1.setBounds(175,100,180,40);
            
            JLabel lbl3=new JLabel("quiere que muestre");
            lbl3.setBounds(175,110,180,40);
            
            
            JLabel lbl2=new JLabel("Dato nuevo: ");
            lbl2.setBounds(248,110,200,100);
            
            JTextField nuevo=new JTextField();
            nuevo.setBounds(320,152,130,20);
            
            JButton reg = new JButton("cambiar");
            reg.setBounds(250, 300, 190 , 20);
            
            
            mid.add(lbl0);
            mid.add(lbl3);
            mid.add(lbl1);
            mid.add(lbl2);
            mid.add(nuevo);
            mid.add(reg);
            
            
            mid.setVisible(true);
            mid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reg.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                    
                    
                    

                    sql.dato = Integer.parseInt(nuevo.getText()); 
                    String texto;
                    if (sql.modificar_parametros()==true)
                            texto="se guardaron los cambios";
                    else
                        texto="error";
                    JOptionPane.showMessageDialog(null,texto);                    
                    sql.modificar_parametros();
                    
                    mid.dispose();
                };
            });
            
            
        });
    }
}




