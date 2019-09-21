package controle;

import java.time.LocalDate;

/**
 * @author Augusto
 */

public abstract class Formatacao {
    
    public static String numerosCPF (String cpf) {
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("-", "");
        cpf = cpf.replaceAll(" ", "");
        return cpf;
    }
    
    public static String numerosTelefone (String telefone) {
        telefone = telefone.replaceAll("\\(", "");
        telefone = telefone.replaceAll("\\)", "");
        telefone = telefone.replaceAll("-", "");
        telefone = telefone.replaceAll(" ", "");
        return telefone;
    }
    
    public static String textoPlaca (String placa) {
        placa = placa.replaceAll("-", "");
        placa = placa.replaceAll(" ", "");
        return placa;
    }
    
    public static String formatarData (String data) {
        try {
            return data.split("/")[2] + "/" + data.split("/")[1] + "/" + data.split("/")[0];
        } catch (Exception e) {
            return "Inválido";
        }
    }
    
    public static String formatarData (LocalDate data) {
        return data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
    }
    
    public static String formatarRG (String rg) {
        rg = rg.replaceAll("\\.", "");
        rg = rg.replaceAll("-", "");
        rg = rg.replaceAll(" ", "");
        return rg;
    }
}
