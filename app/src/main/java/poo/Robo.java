package poo;
import java.util.Random;

public class Robo {
    private  int area;
    private  int eixoXAtual;
    private  int eixoYAtual;
    private  int eixoXAnterior;
    private  int eixoYAnterior;
    private  String direcao;
    private  String plano;
    private  int movimentos;
    private  int quantidade;
    private final int MAX_MOV=100;
    private final int MAX_AREA=800;     
    
    /**
     * metodo para para construção inicial do robo
     * @param area tamannho maximo da area
     * @param eixoXAtual coordenada X atual
     * @param eixoYAtual coordenada Y atual
     * @param direcao    direção da frente
     * @param movimentos numero de movimentos que o robo pode executar, até acabar a bateria
     * @param quantidade quantidade de pixels que deslocara
     */
    public Robo(int area,int eixoXAtual,int eixoYAtual,String direcao,int movimentos,int quantidade){
        this.area=area;               
        this.quantidade=quantidade;       

        if(movimentos<=MAX_MOV){
            this.movimentos=movimentos;
        }else{
            this.movimentos=MAX_MOV;
            }
        
        if(eixoXAtual<=MAX_AREA && eixoYAtual<=MAX_AREA){
            this.eixoXAtual=eixoXAtual;
            this.eixoYAtual=eixoYAtual;
            this.eixoYAnterior=eixoYAtual;
            this.eixoXAnterior=eixoXAtual;

            this.direcao=direcao;  
        }else{
            Random r = new Random();
            this.eixoXAtual=r.nextInt(800);
            this.eixoYAtual=r.nextInt(800);
            this.eixoYAnterior=eixoYAtual;
            this.eixoXAnterior=eixoXAtual;
            this.direcao="N";  
        }

    }

    /**
     * metodo para girar o robo no proprio eixo     * 
     * @param sentido sentido que a frente ira se mover
     * @return
     */
    public String girarRobo(String sentido){
        if(movimentos>0){
            if(direcao.equals("N")){
                this.movimentos--;
                if(sentido.equals("esquerda")){
                    return this.direcao="O";                
                }else{
                    return this.direcao="L";                
                }   
            }
            else if(direcao.equals("S")){
                this.movimentos--;
                if(sentido.equals("esquerda")){
                    return this.direcao="O";
                }else{
                    return this.direcao="L";
                }
            }

            else if(direcao.equals("L")){
                this.movimentos--;
                if(sentido.equals("esquerda")){
                    return this.direcao="N";
                }else{
                     return this.direcao="S";
                }
            }
            else if(direcao.equals("O")){
                this.movimentos--;
                if(sentido.equals("esquerda")){
                    return this.direcao="N";
                }else{
                    return this.direcao="S";
                }
            }
        }
        return direcao;       

    }

    /**
     * metodo para deslocar o robo no plano, conforme direção e 
     * quantidade de pixels informados por parametro da instacia 
     * @return
     */
    public boolean deslocamento(){
        if(movimentos>0){
            this.eixoYAnterior=eixoYAtual;
            this.eixoXAnterior=eixoXAtual;
            
            if(direcao.equals("N")){
                if(eixoYAtual+quantidade<=area){                                    
                    this.eixoYAtual=eixoYAtual+quantidade;
                    this.movimentos--;
                    return true;
                }else{
                    return false;
            }
        }

            else if(direcao.equals("S")){
                if(eixoYAtual-quantidade>=0){
                    this.eixoYAtual=eixoYAtual-quantidade;
                    this.movimentos--;
                    return true;
                }else{
                    return false;
            }
        }

            else if(direcao.equals("L")){
                if(eixoXAtual+quantidade<=area){                                       
                    this.eixoXAtual=eixoXAtual+quantidade;
                    this.movimentos--;
                    return true;
                }else{
                    return false;
            }
        }

            else if(direcao.equals("O")){
                if(eixoXAtual-quantidade>=0){
                    
                    this.eixoXAtual=eixoXAtual-quantidade;
                    this.movimentos--;
                    return true;
                }else{
                    return false;        
            }
        }
    }
        return false;
    }

    /**
     * metodo para guardar o plano de exploração
     * @param exploracao String como os comandos da exploração
     * @return
     */
    public String plano(String exploracao){
        
        return this.plano=exploracao;       
    }          

    /**
     * metodo para executar o plano de exploração
     * @return
     */
    
    public boolean executarPlano(){  
        if(movimentos>0){            
            for(int i=0;i<=plano.length();i++){                
                char operacao= plano.charAt(i);                
                this.plano=plano.substring(1);                         
                if(operacao=='D'){
                    girarRobo("direita");                    
                    return true;  
                }
                if(operacao=='E'){
                    girarRobo("esquerda");                    
                    return true; 
                }
                if(operacao=='M'){
                    deslocamento(); 
                    return true;
                }
                
                
            }  
        }      
        return false;        
    }    

     /**
     * retorna a a coordenada X atual
     * @return
     */
    public int getEixoXAtual() {
        return eixoXAtual;
    }
    
    /**
     * retorna a coordenada Y atual
     * @return
     */
    public int getEixoYAtual() {
        return eixoYAtual;
    }    

    /**
     * retorna a coordenada X anterior
     * @return
     */
    public int getEixoXAnterior() {
        return eixoXAnterior;
    }

    /**
     * retorna a coordenada Y anterior
     * @return
     */    
    public int getEixoYAnterior() {
        return eixoYAnterior;
    }
    
    /**
     * retorna para onde a frente esta posicionada
     * @return
     */
    public String getDirecao() {
        return direcao;
    }
    
    /**
     * retorna o plano restante a ser executado
     * @return
     */
    public String getPlano() {
        return plano;
    }
    
    /**
     * retorna quantidade de movimentos disponiveis até a bateria acabar
     * @return
     */    

    public int getMovimentos() {
        return movimentos;
    }

    /**
     * retorna a area 
     * @return
     */    

    public int getArea() {
        return area;
    }   
    
}
