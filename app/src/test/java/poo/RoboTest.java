package poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoboTest{
   // @Test
    public void incrementarVelocidadeTest(){
        Robo robo = new Robo(700,600,500,"Leste",2,601);    
  
        
            String plano="EMD";
            robo.plano(plano);  

            
            assertEquals(true, robo.executarPlano());
            assertEquals(true,robo.executarPlano());
            assertEquals(true,robo.executarPlano());
            assertEquals(true,robo.executarPlano());



            


                   
           /*  robo.executarPlano();
            assertEquals("M", robo.getPlano());

       
            robo.executarPlano();
            assertEquals("", robo.getPlano());
 */
            


        
    
        //Origem Sul
        assertEquals("Oeste",robo.girarRobo("esquerda")); 
        assertEquals("Norte",robo.girarRobo("direita"));
        assertEquals("Leste",robo.girarRobo("direita"));
        assertEquals("Sul",robo.girarRobo("direita")); 

        ///Origem Norte
        assertEquals("Oeste",robo.girarRobo("esquerda")); 
        assertEquals("Sul",robo.girarRobo("esquerda"));
        assertEquals("Leste",robo.girarRobo("direita"));
        assertEquals("Norte",robo.girarRobo("esquerda")); 
        
        //Origem Oeste
        assertEquals("Norte",robo.girarRobo("esquerda")); 
        assertEquals("Leste",robo.girarRobo("direita"));
        assertEquals("Sul",robo.girarRobo("direita"));
        assertEquals("Oeste",robo.girarRobo("esquerda")); 
        
        //Origem Leste
        assertEquals("Norte",robo.girarRobo("esquerda")); 
        assertEquals("Oeste",robo.girarRobo("esquerda"));
        assertEquals("Sul",robo.girarRobo("direita"));
        assertEquals("Leste",robo.girarRobo("direita"));        
 
        
        /**
         * coordenadas x ou y, acima do limite
         */
        assertEquals("Norte", robo.getDirecao());
        
        /**
        * teste de girar com movimentos=0, podição não pode alterar
        posição em Oeste inicial
        */         
         assertEquals("Oeste",robo.girarRobo("direita")); 
        assertEquals("Oeste",robo.girarRobo("esquerda"));  

        /**
         * testes mudando direção no plano
         */
        robo.plano("E");
        robo.executarPlano();        
        assertEquals("Norte",robo.getDirecao()); 
        robo.plano("D");
        robo.executarPlano();        
        assertEquals("Sul",robo.getDirecao());
 
        //sem bateria
        robo.plano("D");
        robo.executarPlano();        
        assertEquals("Leste",robo.getDirecao());

        /**
         * movimentando o robo, pegando coordenadas anterior e atual
         */
        robo.plano("M");
        robo.executarPlano();    
        assertEquals(500, robo.getEixoXAtual());
        assertEquals(500, robo.getEixoXAnterior()); 

        /**
         * quantidade de movimentos disponiveis
         */
        assertEquals(9, robo.getMovimentos());

         
        /**
         * sem movimentos, testando o metodo de deslocar
         */
        robo.plano("M");
        robo.executarPlano();        
        assertEquals(false, robo.executarPlano());  

        
        /**
         * teste eixo Y até o limite maximo da area
         */
        robo.plano("M");
        robo.executarPlano();
        assertEquals(700, robo.getEixoYAtual());
        assertEquals(500, robo.getEixoYAnterior());
        assertEquals(true, robo.deslocamento());  

        /**
         * teste eixo Y, ultrapassando o  maximo limite
         */
        robo.plano("M");
        robo.executarPlano();
        assertEquals(500, robo.getEixoYAtual());
        assertEquals(500, robo.getEixoYAnterior());
        assertEquals(false, robo.deslocamento()); 

        /**
         * teste eixo X, até o limite maximo da area
         */
        robo.plano("M");
        robo.executarPlano();
        assertEquals(700, robo.getEixoXAtual());
        assertEquals(600, robo.getEixoXAnterior());
        assertEquals(true, robo.deslocamento());   
        
        /**
         * teste eixo X, ultrapassando o  maximo limite
         */
        robo.plano("M");
        robo.executarPlano();
        assertEquals(600, robo.getEixoXAtual());
        assertEquals(600, robo.getEixoXAnterior());
        assertEquals(false, robo.deslocamento());   


         /**
         * teste eixo X, até o limite minimo
         */
        robo.plano("M");
        robo.executarPlano();
        assertEquals(1, robo.getEixoXAtual());
        assertEquals(600, robo.getEixoXAnterior());
        assertEquals(true, robo.deslocamento());  

        /**
         * teste eixo X, até o ultrapassando o limite minimo
         */
        robo.plano("M");
        robo.executarPlano();
        assertEquals(600, robo.getEixoXAtual());
        assertEquals(600, robo.getEixoXAnterior());
        assertEquals(false, robo.deslocamento());  
         

         /**
         * teste deslocamento sem bateria
         */
        robo.plano("M");
        robo.executarPlano();
        assertEquals(600, robo.getEixoXAtual());
        assertEquals(0, robo.getEixoXAnterior());
        assertEquals(false, robo.deslocamento());  
          

       
    }
  

}