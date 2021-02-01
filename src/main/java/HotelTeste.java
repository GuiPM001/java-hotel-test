import java.util.Scanner;

public class HotelTeste {

    public static void main(String[] args) {
        
        String reserva;
        String[] datas;
        int qtdDiaSemana = 0;
        int qtdFinalSemana = 0;
        
        Cliente cliente = new Cliente();
        
        // Atribuindo valores do hotel Lakewood
        Hotel lakewood = new Hotel();
        lakewood.setTaxaDiaSemana(110);
        lakewood.setTaxaFinalSemana(90);
        lakewood.setTaxaDiaSemanaReward(80);
        lakewood.setTaxaFinalSemanaReward(80);
        lakewood.setClassificação(3);
        int totalLakewood = 0;
        
        // Atribuindo valores do hotel Bridgewood
        Hotel bridgewood = new Hotel();
        bridgewood.setTaxaDiaSemana(160);
        bridgewood.setTaxaFinalSemana(60);
        bridgewood.setTaxaDiaSemanaReward(110);
        bridgewood.setTaxaFinalSemanaReward(50);
        bridgewood.setClassificação(4);
        int totalBridgewood = 0;
        
        // Atribuindo valores do hotel Ridgewood
        Hotel ridgewood = new Hotel();
        ridgewood.setTaxaDiaSemana(220);
        ridgewood.setTaxaFinalSemana(100);
        ridgewood.setTaxaDiaSemanaReward(150);
        ridgewood.setTaxaFinalSemanaReward(40);    
        bridgewood.setClassificação(5);
        int totalRidgewood = 0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Insira o tipo de cliente e as datas para reserva: ");
        reserva = input.nextLine();
        input.close();
        
        // Verifica se o cliente é Regular ou Reward
        if (reserva.contains("Regular")) 
            cliente.setTipoCliente("Regular");
        
        else if (reserva.contains("Rewards"))
            cliente.setTipoCliente("Rewards");
        
        else
            System.out.println("Tipo de cliente inválido.");
        
        // Conta o número de dias de semana e finais de semana
        datas = reserva.split(",");
        
        for (int i = 0; i < datas.length; i++) {           
            if (datas[i].contains("sat") || datas[i].contains("sun"))
                qtdFinalSemana++;
            else
                qtdDiaSemana++;
        }
        
        // Calcula o valor total de cada hotel para cliente Regular
        if (cliente.getTipoCliente().equals("Regular")) {           
            totalLakewood = (qtdDiaSemana * lakewood.getTaxaDiaSemana()) 
                    + (qtdFinalSemana * lakewood.getTaxaFinalSemana());
            
            totalBridgewood = (qtdDiaSemana * bridgewood.getTaxaDiaSemana()) 
                    + (qtdFinalSemana * bridgewood.getTaxaFinalSemana());
            
            totalRidgewood = (qtdDiaSemana * ridgewood.getTaxaDiaSemana()) 
                    + (qtdFinalSemana * ridgewood.getTaxaFinalSemana());          
        }
        
        // Calcula o valor total de cada hotel para cliente Reward
        else if (cliente.getTipoCliente().equals("Rewards")) {            
            totalLakewood = (qtdDiaSemana * lakewood.getTaxaDiaSemanaReward()) 
                    + (qtdFinalSemana * lakewood.getTaxaFinalSemanaReward());
            
            totalBridgewood = (qtdDiaSemana * bridgewood.getTaxaDiaSemanaReward()) 
                    + (qtdFinalSemana * bridgewood.getTaxaFinalSemanaReward());
            
            totalRidgewood = (qtdDiaSemana * ridgewood.getTaxaDiaSemanaReward()) 
                    + (qtdFinalSemana * ridgewood.getTaxaFinalSemanaReward());                       
        }
        
        // Definindo o hotel mais barato
        if (totalLakewood < totalBridgewood && totalLakewood < totalRidgewood)
            System.out.println("Hotel mais barato: Lakewood");

        else if (totalBridgewood < totalLakewood && totalBridgewood < totalRidgewood)
            System.out.println("Hotel mais barato: Bridgewood");
            
        else  if (totalRidgewood < totalLakewood && totalRidgewood < totalBridgewood)
            System.out.println("Hotel mais barato: Ridgewood");
        
        
        // Desempate entre os hotéis
        else if (totalLakewood == totalBridgewood) {
            if (lakewood.getClassificação() < bridgewood.getClassificação()) 
                System.out.println("Hotel mais barato: Bridgewood");
            else
                System.out.println("Hotel mais barato: Lakewood");
            
        } else if (totalLakewood == totalRidgewood) {
            if (lakewood.getClassificação() < ridgewood.getClassificação()) 
                System.out.println("Hotel mais barato: Ridgewood");
            else
                System.out.println("Hotel mais barato: Lakewood");
            
        } else if (totalBridgewood == totalRidgewood) {
            if (bridgewood.getClassificação() < ridgewood.getClassificação()) 
                System.out.println("Hotel mais barato: Ridgewood");
            else
                System.out.println("Hotel mais barato: Bridgewood");
        }
    }
}
