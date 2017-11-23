package InterfazGrafica;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Clase_Persona {
    
    private String nombre;
    private String apellido;
    private int edad;
    private int Dni;
    private String localidad;
    private int telefono;
    private String mail;
    private String Java;

   
    
    public Clase_Persona (){
        
    }

    public Clase_Persona(String nombre, String apellido, int edad, 
                         int Dni, String localidad, 
                         int telefono, String mail, String Java) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setDni (Dni);
        setLocalidad(localidad);
        setTelefono(telefono);
        setMail(mail);
        setJava(Java);
    }
    
    //------------NOMBRE------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(VerificarCaracteres(nombre)){ 
                this.nombre = nombre;
        } else{ 
            
            JOptionPane.showMessageDialog(null, "el ingreso del nombre contiene caracteres no validos");
        } 
    } 

    public static boolean VerificarCaracteres(String palabra){ 
        for(int i = 0; i < palabra.length(); i++){ 
            if(!((palabra.charAt(i) > 64 && palabra.charAt(i) < 91) || 
                (palabra.charAt(i) > 96 && palabra.charAt(
                        i) < 123))) 
                    return false; 
            } 
        return true; 
    } 
     
    //------------APELLIDO------------
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
         if(VerificarCaracteres(apellido)){ 
                this.apellido = apellido;
        } else{ 
            
            JOptionPane.showMessageDialog(null, "el ingreso de apellido contiene caracteres no validos");
        } 
    }

    //------------EDAD------------
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
            if(VerificarEdad(edad)) {
                this.edad = edad;
            }
            else{
                
                JOptionPane.showMessageDialog(null, "Error rango de Edad");
            }
    }
    
    public boolean VerificarEdad(int edad){
        if(edad >=18 && edad <= 99){
         return true;
        } 
        else{
            return false;
        }
    }
    
    //------------NUMERO DOCUMENTO------------
    public int getDni() {
        return Dni;
    }

    public void setDni(int Dni) {
        if(VerificarDni(Dni)< 9 ){
            this.Dni = Dni;
        }else{
           
            JOptionPane.showMessageDialog(null, "Error formato dni");
        }
    }

    public int VerificarDni (int dni) {
        int i = 0;
        dni = Math.abs(dni);
        for ( i = 0; dni > 5; i++) {
            dni = dni /10; 
        }
         
    
        return i;
    }
    
    //------------LOCALIDAD------------
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        if(VerificarCaracteres(localidad)){ 
                this.localidad = localidad;
        } else{ 
            
            JOptionPane.showMessageDialog(null, "el ingreso de la localidad contiene caracteres no validos");
        } 
        
    }

    //------------TELEFONO------------
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        
        if(VerificarTelefono(telefono)<= 10 ){
            this.telefono = telefono;
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Error formato telefono");
        }
    }

    public int VerificarTelefono(int telefono){
        int i = 0;
        telefono = Math.abs(telefono);
        for ( i = 0; telefono > 0; i++) {
            telefono = telefono /10; 
        }
//        if (i > 10 ) {
//            //completar en interfaz
//        }
        return i; 
    }

    //------------MAIL------------
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if(VerificarMail(mail)){
            this.mail = mail;
        }else{
            
            JOptionPane.showMessageDialog(null, "Error formato email");
       
        }
    }
    
    public static boolean VerificarMail (String mail) {
    // Establecer el patron
        Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
    // Asociar el string al patron
        Matcher m = p.matcher(mail);
   // Comprobar si encaja
        return m.matches();
    }
    
   
    

    public void setJava(String Java) {
        if (Java.equals("Si")) {
            this.Java = "Si";
        }else  if (Java.equals("No")) {
            this.Java="No";
        }

    }

    public String getJava() {
        return Java;
    }
    
    
    //------------MUESTRA TODO LOS DATOS DEL REGISTRO------------     
    @Override
    public String toString() {
        return "Persona Ingresada: "  + nombre + " " + apellido + " "+ 
                                        edad+ " " + Dni+ " " + 
                                        localidad+ " " + telefono+ " " + 
                                        mail+ " " + Java;
    }
    
}


