package controle;

public abstract class Validadores {
    
    public static boolean validarCPF (String cpf) {

        //Análise do tamanho
        if (cpf.length() != 11) {
            return false;
        }

        //Conversão para vetor
        char [] digito = cpf.toCharArray();

        //Análise de CPFs inválidos que possuem todos os dígitos iguais
        if ((digito[0]==digito[1])&&(digito[1]==digito[2])&&(digito[2]==digito[3])&&(digito[3]==digito[4])&&
(digito[4]==digito[5])&&(digito[5]==digito[6])&&(digito[6]==digito[7])&&(digito[7]==digito[8])&&(digito[8]==digito[9])
&&(digito[9]==digito[10])){
            return false;
        }

        //Análise do penúltimo dígito
        int soma = 0; int ind = 10;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(digito[i]) * ind;
            ind--;
        }
        if (soma % 11 < 2) {
            if (Character.getNumericValue(digito[9]) != 0){
                return false;
            }
        } else if (Character.getNumericValue(digito[9]) != 11 - soma % 11) {
            return false;
        }

        //Análise do último dígito
        soma = 0; ind = 11;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(digito[i]) * ind;
            ind--;
        }
        if (soma % 11 < 2) {
            if (Character.getNumericValue(digito[10]) != 0) {
                return false;
            }
        } else if (Character.getNumericValue(digito[10]) != 11 - soma % 11) {
            return false;
        }
        return true;
    }
    
    
    public static boolean validarCNPJ (String cnpj) {
        //Exemplo de CNPJ:  11.444.777/0001-XX => nº de inscrição / código único / dígitos verificadores
        
        //Análise do tamanho e dos caracteres
        if (cnpj.length() != 18)  {
            return false;
        } else if (cnpj.charAt(2) != '.' || cnpj.charAt(6) != '.' || cnpj.charAt(10) != '/' || cnpj.charAt(15) != '-') {
            return false;
        }
        
        //Conversão para vetores
        int [] peso = {5,4,3,2,9,8,7,6,5,4,3,2};
        int [] digit = {Character.getNumericValue(cnpj.charAt(0)),Character.getNumericValue(cnpj.charAt(1)), Character.getNumericValue(cnpj.charAt(3)),Character.getNumericValue(cnpj.charAt(4)),Character.getNumericValue(cnpj.charAt(5)), Character.getNumericValue(cnpj.charAt(7)),Character.getNumericValue(cnpj.charAt(8)),Character.getNumericValue(cnpj.charAt(9)), Character.getNumericValue(cnpj.charAt(11)),Character.getNumericValue(cnpj.charAt(12)),Character.getNumericValue(cnpj.charAt(13)),Character.getNumericValue(cnpj.charAt(14))};  
        
        //Verificação do primeiro dígito
        int soma = 0;
        for (int i = 0; i < peso.length; i++) {
            soma += peso[i] * digit[i];
        }
        if (soma % 11 < 2) {
            if (Character.getNumericValue(cnpj.charAt(16)) != 0) {
                return false;
            }
        } else if (Character.getNumericValue(cnpj.charAt(16)) != 11 - soma % 11) {
            return false;
        }
        
        //Verificação do segundo dígito
        soma = Character.getNumericValue(cnpj.charAt(16)) * 2;
        int [] newPeso = {6,5,4,3,2,9,8,7,6,5,4,3};
        for (int i = 0; i < newPeso.length; i++) {
            soma += newPeso[i] * digit[i];
        }
        if (soma % 11 < 2) {
            if (Character.getNumericValue(cnpj.charAt(17)) != 0) {
                return false;
            }
        } else if (Character.getNumericValue(cnpj.charAt(17)) != 11 - soma % 11) {
            return false;
        }
        
        return true;
    }
}