/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package poo;


import java.util.Random;
import java.util.Scanner;

import edu.princeton.cs.algs4.Draw;

public class App {
     
     Draw areaDeDesenho;    
     
    /**
     * metodo para executar o plano de desenho robo
     * 
     * @param robo parametro robo, vem da classe main, ja instanciado la
     */
    public App(Robo robo){
        
        Random rand=new Random();      
        //cores que serão utilizadas no random
        java.awt.Color[] cor= {Draw.BLUE,Draw.GRAY,Draw.ORANGE,Draw.PINK,Draw.RED,Draw.BLACK};

        //definição da escala do desenho
        this.areaDeDesenho = new Draw();                
        this.areaDeDesenho.setCanvasSize(robo.getArea(),robo.getArea());    
        this.areaDeDesenho.setXscale(0, robo.getArea());
        this.areaDeDesenho.setYscale(0, robo.getArea());         
        
        //loop para rodar toda a string do plano de execução com as instruções
        //se acavar a bateria, o loop é encerrado com o break
        int x=(robo.getPlano().length());
        for(int i=0;i<x;i++){
            if(robo.getMovimentos()>0){
            robo.executarPlano();
            this.areaDeDesenho.setPenColor(cor[rand.nextInt(6)]);
            this.areaDeDesenho.line(robo.getEixoXAnterior(), robo.getEixoYAnterior(), robo.getEixoXAtual(), robo.getEixoYAtual());
            this.areaDeDesenho.pause(1000);
            }else break;            
        } 

        //print se acabou a bateria
        if(robo.getMovimentos()==0){
            System.out.print("Acabou a bateria do robô na coordenada ("+robo.getEixoXAtual()+","+robo.getEixoYAtual()+") e com a frente para Z. ");
            System.out.print("No plano restam "+robo.getPlano().length()+" comandos que não foram processados;");
        }else {
            //print se não acabou a bateria
            System.out.println("A coordenada final é ("+robo.getEixoXAtual()+","+robo.getEixoYAtual()+");");
            System.out.println("A sua frente esta virada na direção: "+robo.getDirecao()+";");        
            System.out.println("Ainda lhe restam a quantidade de "+robo.getMovimentos()+ " movimentos até acabar a bateria;");
        }
        
        
                 
    } 
        
    

    public static void main(String[] args) {

        /**
         * instancimaneto manual do robo e do plano
         */

        Robo robo = new Robo(650,200,80,"N",150 ,30);
        String plano="MMMMDMMMMMMMEMMMMMEMMMMMMMMMEMMMMMMMDMMMMMMEMDMMM";
                                        
        robo.plano(plano);                
        App desenhar = new App(robo);        

        /**
         * leitura do arquivo passado como parametro via linha de comando,
         * porem, no meu VsCode não consigo abrir arquivo, somente a msg de linha vazia,
         * então, intanciei o robo e o plano, manualmente conforme acima abaixo
         */
       
        /* Scanner dados= new Scanner(System.in);
        String linha=dados.nextLine();
        String[] parametros=linha.split(",");

        String planoRobo=new String();
        while(dados.hasNextLine()){                            
                linha=dados.nextLine();
                planoRobo=planoRobo+linha;

        }         

        int area=Integer.parseInt(parametros[0]);
        int xAtual=Integer.parseInt(parametros[1]);
        int yAtual=Integer.parseInt(parametros[2]);
        int movimentos=Integer.parseInt(parametros[4]);
        int quantidade=Integer.parseInt(parametros[5]);         

        Robo robo = new Robo(area,xAtual,yAtual,parametros[3],movimentos,quantidade);
        robo.plano(planoRobo);          
        App desenhar= new App(robo);  */  
    }
}
