
// perfil no liken
import java.util.Scanner;
// link Linkedin https://www.linkedin.com/in/gabriel-rodrigues-b45b5723a/
/**
 *
 * @author Gabriel
 */
public class Arvore {
    
    class No {
        No esquerda;
        No Direita;
        int valor;
    }
    
    public No Raiz = null;
    
    
    public void InserirArvore(No raiz,int valor) {
        
  
        No NovoNo = new No();
        NovoNo.valor = valor;
        NovoNo.esquerda = null;
        NovoNo.Direita = null;
        
        if(raiz == null)
            Raiz = NovoNo;
        else {
                
            if(valor < raiz.valor)
                if(raiz.esquerda == null)
                    raiz.esquerda = NovoNo;
                else
                    InserirArvore(raiz.esquerda, valor);
            else {
                
                if(raiz.Direita == null)
                    raiz.Direita = NovoNo;
                else
                    InserirArvore(raiz.Direita, valor);
            }
                
         }
    }
    
    
  
    public void MostrarArvoreRED(No Raiz) {
        
        if(Raiz == null)
            return;
        else {
            System.out.print(" -> " + Raiz.valor);
            MostrarArvoreRED(Raiz.esquerda);
            MostrarArvoreRED(Raiz.Direita);
        }
    }
    
    public void MostrandoERD(No Raiz) {

           
            
            if(Raiz.esquerda != null) {
                MostrandoERD(Raiz.esquerda);
    
            }
              System.out.print("-> " + Raiz.valor);
               
            if(Raiz.Direita != null) {
                 MostrandoERD(Raiz.Direita);       
            }
    }
    
  
    
    public void MostrarEDR(No Raiz) {

      
            if(Raiz.esquerda != null) {
                MostrarArvoreRED(Raiz.esquerda);
  
            }
            
            if(Raiz.Direita != null) {
                MostrarArvoreRED(Raiz.Direita);
            }
            
             System.out.print(" -> " + Raiz.valor);
    
    }
           
    
    
    
    public void AcharPosicao(No Raiz,int valor_Achar) {
        
        
       if(Raiz == null) {
           return;
       }
       else {
           if(valor_Achar == Raiz.valor ) {
               System.out.println("Valor: " + valor_Achar + " Encontrado");
               return;
           }
           else {
                   if(Raiz.esquerda != null) {
                        AcharPosicao(Raiz.esquerda, valor_Achar);
                   }
                   else if(Raiz.Direita != null) {
                      AcharPosicao(Raiz.Direita, valor_Achar);
                   }
                   else {
                        if(Raiz.esquerda == null || Raiz.Direita == null)
                            System.out.println("Erro ao Pesquisar o Valor: " + valor_Achar + " Valor Inexistente");
                   }
           }
          
          
        }
      
    }
    
     public void EliminarNoArvore(No Raiz,int valorEliminar) {
         
         if(Raiz == null)
             return;
            else {
             
             if(this.Raiz.esquerda == null && this.Raiz.Direita == null)
                  System.out.println("Erro ao Eliminar Lado Esquerdo ou Lado Direito Não Tem No");
             else {
               
                 if(valorEliminar >= Raiz.valor) {
                   if(Raiz.valor ==  valorEliminar ) {
                        No aux  = Raiz.Direita;
                        Raiz.valor = aux.valor;
                        Raiz.Direita = aux.Direita;
                        System.out.println("Valor: " + valorEliminar + " Removido");
                       return;
                   }
                   else {
                         EliminarNoArvore(Raiz.Direita, valorEliminar);
                   }
                }//esta na direita
                else {
                       if(valorEliminar <= Raiz.valor ) {
                            if(Raiz.valor == valorEliminar) {
                               No aux  = Raiz.esquerda;
                               Raiz.valor = aux.valor;
                               Raiz.esquerda = aux.esquerda;
                               System.out.println("Valor: " + valorEliminar + " Removido");
                               return; // eliminou e parou a funcao
                           }
                       }
                        else {
                           EliminarNoArvore(Raiz.esquerda, valorEliminar);
                       }
                        System.out.println("Erro ao Remover Valor: " + valorEliminar + " Valor Inexistente");
                }// esta na esquerda
                
            }
        }  
     }
                  
    public int Menu() {
		
          int resposta = 0;
          Scanner resp = new Scanner(System.in);
            System.out.println("");
            System.out.println("[1] Inserir Na Arvore");
            System.out.println("[2] Exibiar a Arvore");
            System.out.println("[3] Remover valor da Arvore");
            System.out.println("[4] Pesquisa");
            System.out.println("[5] Sair");
            System.out.print("OP: ");
            resposta = resp.nextInt();
            System.out.println("");
            return resposta;
    
    }
    
    public final static void clearConsole()
    {
    
        for(int i = 0; i < 6; i++)
            System.out.println("");

    } // OBS: nao tinha comando de limpar console foi improvizado
    
    public static void main(String[] args) {
       
        Arvore arv = new Arvore();
        int resp = 0;
        Scanner userMain = new Scanner(System.in);
        
 
        do{
                   
            resp = arv.Menu();
            
            if(resp == 1) {
                System.out.print("Insira o Valor Para Inserir Na Arvore:-> ");
                int Value = userMain.nextInt();
                arv.InserirArvore(arv.Raiz, Value);    
            }
            else if(resp == 2) {
                
                if(arv.Raiz == null) {
                      System.out.println("Erro Arvore Vazia");
                        arv.Menu();
                }
                else {
                    System.out.print("Mosrando RED:");
                    arv.MostrarArvoreRED(arv.Raiz);
                    System.out.println("");
                    System.out.println("");
                    System.out.print("Mostrando ERD:");
                    arv.MostrandoERD(arv.Raiz);
                    System.out.println("");
                    System.out.println("");
                    System.out.print("Mostrando EDR:");
                    arv.MostrarEDR(arv.Raiz);
                }
            }
            else if(resp == 3) {
                
                if(arv.Raiz == null) {
                    System.out.println("Erro Arvore Vazia");
                    arv.Menu();
                }
                else {
                    System.out.print("Digite o Valor Para Eliminar:-> ");
                    int valueEliminar = userMain.nextInt();
                    arv.EliminarNoArvore(arv.Raiz,valueEliminar);
                }
            }
            else {
                if(arv.Raiz == null) {
                    System.out.println("Erro Arvore Vazia");
                     resp = arv.Menu();
                }
                else {
                    System.out.print("Digite um Valor para Pesquisar:-> ");
                    int valor_pesquisa = userMain.nextInt();
                    arv.AcharPosicao(arv.Raiz, valor_pesquisa);
                }
            }
                    

        }while(resp != 5);   
    }
}

   


