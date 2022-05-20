import java.util.Scanner;
public class ListaExer{
    public static void main(String [] args){
        System.out.println("Informe o exercicio da lista a ser executado: ");
        Scanner in = new Scanner(System.in);
        int escolha = in.nextInt();
        
        switch(escolha){
            case 1:
                System.out.println("Resolvendo exercico 1 - volume da esfera");
                System.out.print("   Informe o valor do Raio: ");
                double raioInformado;
                raioInformado = in.nextInt();
                double resultado;
                resultado = volumeEsfera(raioInformado);
                System.out.printf("    O volume da esfera de raio %.2f é %.2f\n", raioInformado, resultado);
                break;
                
            case 2:
                System.out.println("Resolvendo exercico 2 - notas");
                System.out.print(" Informe a primeira nota: ");
                double nota1 = in.nextDouble();
                System.out.print(" Informe a segunda nota: ");
                double nota2 = in.nextDouble();
                System.out.print(" Informe a terceira nota: ");
                double nota3 = in.nextDouble();
                
                System.out.println(" Opções de calculo de média: ");
                System.out.println("   A -> média aritimétrica ");
                System.out.println("   P -> média ponderada (pesos: 5, 3 e 2) ");
                System.out.println("   H -> média harmônica ");
                System.out.print("   Escolha a média: ");
                char opcaoMedia;
                opcaoMedia = in.next().toUpperCase().charAt(0);
                double mediaNotas = media(nota1, nota2, nota3, opcaoMedia);
                
                if(mediaNotas<0){
                    System.out.println("A media solicitada foi invalida");
                }
                else{
                    System.out.printf(" A média das notas é %.2f\n", mediaNotas);
                }
                break;
            case 3:
                System.out.println("Resolvendo exercicio 3 - Primo");
                System.out.print("   Informe o valor a ser analisado: ");
                int Numer = in.nextInt();
                System.out.println("O valor: " +Numer);
                        if(ehprimo(Numer)){
                            System.out.println(" eh Primo");
                        }
                        else{
                            System.out.println(" NÃO eh primo");
                        }
                 break;
            case 4:
                System.out.println("Resolvendo exercicio 4 - Bhaskara");
                System.out.println("   Insira os Valores a serem analisados ");
                
                int a, b, c;
                
                System.out.print(" Informe A: ");
                    a = in.nextInt();
                System.out.print(" Informe B: ");
                    b = in.nextInt();
                System.out.print(" Informe C: ");
                    c = in.nextInt();
                
                double x1, x2;
                
                x1=bhaskaraMais(a,b,c);
                x2=bhaskaraMenos(a,b,c);
                
                double Delta;
                Delta = ((b*b)-4*a*c);
                if(Delta>0){
                    if (x1 == x2){
                    System.out.printf("A raiz da equação é: %.2f\n", x1); 
                    }
                    else{
                    System.out.printf("As raizes da equação são: %.2f e %.2f\n", x1,x2);
                    }
                }
                if (Delta<0){
                    System.out.print("Essa equação não possue raizes reais");
                }
            
                 break;
            default:
                System.out.println("Exercicio não foi implementado ainda");
        }
    }
    
    public static double volumeEsfera(double raio){
        double volume;
        
        volume = (4 * Math.PI * Math.pow(raio, 3)) /3 ;
        
        return volume;
    }
    
    public static double media(double n1, double n2, double n3, char tipoMedia){
        double resultado;
        
        switch(tipoMedia){
            case 'A':
                  resultado=mediaArit(n1, n2, n3); 
             break;
            case 'P':
                resultado=mediaPond(n1, n2, n3); 
              break;
            case 'H':
                    resultado=mediaHarm(n1, n2, n3); 
              break;
            default:
              resultado=-1;
                  System.out.println("A opção de média é invalida");
            }
                
        return resultado;
    }
    
    public static double mediaArit(double n1, double n2, double n3){
        double resultado;
        resultado = (n1+n2+n3) / 3;
        return resultado;
    }
    public static double mediaPond(double n1, double n2, double n3){
        double resultado;
        resultado = (n1*5 + n2*3 + n3*2) / 10;
        return resultado;
    }
    public static double mediaHarm(double n1, double n2, double n3){
        double resultado;
        resultado = 3.0 / ( ((1.0/n1) + (1.0/n2) + (1.0/n3)) );
        return resultado;
    }
    
    public static boolean ehprimo(int Numer){
        int divisor = 1;
        int nDivisores = 0;
        while (divisor <= Numer) {
            if ((Numer % divisor) == 0) {
                nDivisores++;
            }

            divisor++;

        }

        return (nDivisores == 2);
    }
    
    public static double bhaskaraMais(int a, int b, int c){
        double resultado = b*b;
        resultado = resultado - (4*a*c);
        resultado = Math.sqrt(resultado);
        resultado = -b + resultado;
        resultado = resultado /(2*a);
        return resultado;
    }
    
    public static double bhaskaraMenos(int a, int b, int c){
        double resultado = b*b;
        resultado = resultado - (4*a*c);
        resultado = Math.sqrt(resultado);
        resultado = -b - resultado;
        resultado = resultado /(2*a);
        return resultado;
    }
}