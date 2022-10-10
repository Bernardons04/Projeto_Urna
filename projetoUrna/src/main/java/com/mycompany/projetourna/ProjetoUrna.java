/* Esse projeto se trata de uma urna, como as que são usadas nas eleições.
Cada voto conta um ponto para o candidato votado, caso o voto seja nulo, ninguem
recebe ponto, e caso o voto seja em branco, o candidato que estiver ganhando no 
momento fica com o ponto. Ao final das eleições, é mostrado a quantidade de 
pontos que cada candidato recebeu e também, a quantidade de votos nulos.
*/

package com.mycompany.projetourna;
import javax.swing.JOptionPane;

public class ProjetoUrna {
    public static void main(String[] args) {
        int opcao; 
        int pdt = 0; 
        int pl = 0; 
        int pt = 0;
        int nulo = 0;
        
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para preparar o sistema, ou, 2 para finalizar a votação: "));
            if (opcao == 1) {
                int voto = Integer.parseInt(JOptionPane.showInputDialog("Eleições 2022: Lista de Candidatos\n"
                    + "\nCódigo: 22 \nNome: Jair Bolsonaro \nPartido: PL"
                    + "\n------------------------"
                    + "\nCódigo: 13 \nNome: Lula \nPartido: PT"
                    + "\n-------------------------"
                    + "\nCódigo: 15 \nNome: Ciro Gomes \nPartido: PDT"
                    + "\n-------------------------"
                    + "\nCódigo: 0 \nVoto Nulo"
                    + "\n-------------------------"
                    + "\nCódigo: 4 \nVoto em Branco"
                    + "\nEm quem você deseja votar?"));
                if (voto == 22) {
                    pl += 1;
                } else if (voto == 13) {
                    pt += 1;            
                } else if (voto == 15) {
                    pdt += 1;            
                } else if (voto == 0) {
                    nulo += 1;            
                } else if (voto == 4) { // Condicional que vai definir pra quem vai o voto em branco
                    if (pl > pt && pl > pdt){
                        pl += 1;
                    } else if (pt > pl && pt > pdt) {
                        pt += 1;
                    } else if (pdt > pl && pdt > pt) {
                        pdt += 1;
                    }          
                } else {
                    do { // loop  que vai garantir que a pessoa que estiver votando não vai inserir um número inválido
                        JOptionPane.showMessageDialog(null, "Você não inseriu um número válido, tente noamente!");
                        voto = Integer.parseInt(JOptionPane.showInputDialog("Em quem você deseja votar? "));
                        if (voto == 22) {
                            pl += 1;
                        } else if (voto == 13) {
                            pt += 1;            
                        } else if (voto == 15) {
                            pdt += 1;            
                        } else if (voto == 0) {
                            nulo += 1;            
                        } else if (voto == 4) {
                            if (pl > pt && pl > pdt){
                                pl += 1;
                            } else if (pt > pl && pt > pdt) {
                                pt += 1;
                            } else if (pdt > pl && pdt > pt) {
                                pdt += 1;
                            }   
                        }
                    } while (voto != 22 && voto != 13 && voto != 15 && voto != 0 && voto != 4);
                }
            } else if (opcao == 2) {
              JOptionPane.showMessageDialog(null, "\nEleições encerradas!");
            } else {
              JOptionPane.showMessageDialog(null, "Opção inválida");
            }    
        } while (opcao != 2);
        
        JOptionPane.showMessageDialog(null, "\nResultado das eleições: \n"
            + ""
            + "\nCandidato: Jair Bolsonaro \nNúmero de votos: " + pl
            + "\nCandidato: Lula \nNúmero de votos: " + pt
            + "\nCandidato: Ciro Gomes \nNúmero de votos: " + pdt
            + "\nVoto nulo \nNúmero de votos: " + nulo
        );
    }
}
