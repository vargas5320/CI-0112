import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class JuegoBatalla{

    //Atributos de la clase

    public static Robot[] robots;
    Random random = new Random();

    //constructor
    public JuegoBatalla(Robot[] robots) {
        this.robots = robots;
    }

    // Variables necesarias

    //int iOtroRobot = random.nextInt(robots.length);
    static int count = 0; 

    //Metodos de la clase




    //método para iniciar la batalla

    public void iniciarBatalla(){
        while(count < (robots.length - 1)){
            for(int i= 0; i < robots.length; i++){
                int iOtroRobot = random.nextInt(robots.length);

                if (robots[i] !=null){
                    iOtroRobot = random.nextInt(robots.length);

                    while(i == iOtroRobot || robots[iOtroRobot]== null){
                        iOtroRobot = random.nextInt(robots.length);
                    } 
                

                robots[i].atacar(robots[iOtroRobot]);

                if (!robots[iOtroRobot].estaVivo(robots[iOtroRobot].getPuntosVida())){
                    robots[iOtroRobot]=null;
                    count ++;
                }
                
            }
            if (count==(robots.length - 1)){
                break;
            }
            }
        }
                    
    }


    //método para anunciar el ganador

    public  void mostrarGanador(){
        for(int i= 0; i < robots.length; i++){
            if(robots[i] != null ){  
                System.out.println("El"+" "+"robot"+" "+"ganador"+" "+"es:"+" "+ robots[i].getNombre());
                break;
            }
        }
    }

                


     
    // inicio del main

    public static void main(String[] args){ 

        // implementación de scanner
        Scanner scanner = new Scanner(System.in);

        //intanciar el arreglo con los robots 
        Robot[] robots = null;
        int cantidad = 0;

        while(true){ 
            try{
                System.out.println("Elija" +" "+ "la"+ " "+ "cantidad"+" " + "(entre"+" "+ "2"+" "+ "y" +" "+ "10)"+" "+ "de"+" "+ "robots" +" "+ "que" +" "+ "desea");
                cantidad = scanner.nextInt();
                scanner.nextLine();
            
                if (cantidad >= 2 && cantidad <= 10){

                    //instanciado del arreglo
                    robots = new Robot[cantidad];
                    for(int i= 0; i < robots.length; i++){

                        System.out.println("indique" +" "+ "el"+ " "+ "nombre"+" "+ "del " +" "+ "robot"+" "+ (i+1) + ":");
                        String nombret = scanner.nextLine();

                        //variables necesarias para suministrar los datos al metodo constructor

                        int puntosVidat = 1;
                        int ataquet = 1;

                        while(true){
                            try{
                                System.out.println("indique" +" "+ "los"+ " "+ "puntos" + " " + "de" + " "+ "vida"+" " + "(entre" + " " + "50" + " "+ " y"+ " "+"100)"+" "+"del"+" " + "robot"+" "+ (i+1) + ":");
                                puntosVidat = scanner.nextInt();

                                if(puntosVidat >=50 && puntosVidat <=100){           
                        break;     
                                }
                                else{
                                    System.out.println("eleccion" +" "+ "invalida");
                                }
                            }
                            catch (InputMismatchException e){
                                System.out.println("eleccion" +" "+ "invalida");
                                scanner.nextLine();
                            }
                        }
                        
                        while(true){
                            try{
                                System.out.println("indique" +" "+ "los"+ " "+ "puntos"+" "+"de"+ " "+ "ataque"+ " "+ "(entre" +" "+ "10 "+ " "+ " y"+ " "+"20)"+" "+"del"+" " + "robot"+" "+ (i+1) + ":");
                                ataquet = scanner.nextInt();
                                scanner.nextLine();

                                if(ataquet>=10 && ataquet <=20 ){
                                    //"(entre" + " "+ ""+ " "+ "y"+" "+")"
                        break;                                  
                                }
                                else{
                                    System.out.println("eleccion" +" "+ "invalida");
                                }
                            }
                            catch (InputMismatchException e){
                                System.out.println("eleccion" +" "+ "invalida");
                                scanner.nextLine();
                            }
                            
                        }

                        robots[i] =new Robot(nombret, puntosVidat, ataquet);

                    }
                    System.out.println("Los robots creados son:");
                    for (int i = 0; i < robots.length; i++) {
                        System.out.println(robots[i]);
                    }
                    break;
                }
                else { 
                    System.out.println("eleccion" +" "+ "invalida");
                }
            }
            catch (InputMismatchException e){
                System.out.println("eleccion" +" "+ "invalida");
                scanner.nextLine();
            }
        }// final de indexcion del array

        

        // a partir de aquí inicia la bartalla
        JuegoBatalla juego = new JuegoBatalla(robots);
       
        
        juego.iniciarBatalla();
        juego.mostrarGanador();
        

    } //final del main
}// final de la clase