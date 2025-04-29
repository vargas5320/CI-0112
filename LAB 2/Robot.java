public class Robot {

    //Atributos de la clase
    private  String nombre;
    private  int puntosVida;
    private  int ataque;

    //set y get

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }  
    public void setPuntosVida (int puntosVida) {
        this.puntosVida = puntosVida;
    } 
     public void setataque (int ataque) {
        this.ataque = ataque;
    } 
    
    public String getNombre () {
        return this.nombre;
    }
    public int getPuntosVida () {
        return this.puntosVida;
    }
    public int getataque () {
        return this.ataque;
    }

    //Constructor
    public Robot (String nombre, int puntosVida, int ataque){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;

    }

    //Metodo para atacar 
    public void atacar (Robot otroRobot){
        System.out.println(this.nombre +" "+ "ataca"+ " "+"a"+" "+ otroRobot.getNombre());
        otroRobot.setPuntosVida(otroRobot.getPuntosVida()-this.ataque);
        
         //pedirle al programa que si queda menor que cero, entonces lo deje en 0
    }
    
    //Metodo para determinar estado del robot.
    public boolean estaVivo(int puntosVida) {
        if (this.puntosVida <= 0){  
            System.out.println("El" +" "+ "robot"+" "+ this.nombre +" "+ "ha" +" "+ "sido" +" "+ "derrotado");
            return false; 
        }
        else {
            System.out.println("El"+" "+ "robot"+" "+ this.nombre +" "+ "sigue" +" "+ "en" +" "+ "pie");
            return true;
        }
    }
}