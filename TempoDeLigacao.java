package exerciciosApostila;

import java.util.Scanner;

public class TempoDeLigacao {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        String horarioInicial;
        String horarioFinal;
        int hInicial, mInicial, hFinal, mFinal;

        String continuar  = "s";

        System.out.println("Bem vindo a central!");

        System.out.print("+----------------------------------------------+\n" +
                         "|               CUSTO POR MINUTO               |\n" +
                         "+----------------------------------------------+\n" +
                         "|    00:00 ás 05:59     -       R$ 0,10        |\n" +
                         "|    06:00 às 07:59     -       R$ 0,15        |\n" +
                         "|    08:00 às 17:59     -       R$ 0,20        |\n" +
                         "|    18:00 às 23:59     -       R$ 0,15        |\n" +
                         "+----------------------------------------------+\n\n");

        do {

            do{


                do{
                    System.out.println("Digite o horário INICIAL da ligação(EX: 10:30): ");
                    horarioInicial = leia.next();

                    hInicial = convertHoraToInt(horarioInicial);
                    mInicial = convertMinToInt(horarioInicial);


                    if(!(hInicial >= 0 && hInicial <= 23)){
                        System.out.println("ERRO : O valor das horas tem que ser entre 00 e 23\n...\n");
                    }else if(!(mInicial >= 0 && mInicial <= 59)){
                        System.out.println("ERRO : O valor dos minutos tem que ser entre 00 e 59\n...\n");
                    }
                }while(!(hInicial >= 0 && hInicial <= 23) || !(mInicial >= 0 && mInicial <= 59));


                do {
                    System.out.println("Digite o horário FINAL da ligação: ");
                    horarioFinal = leia.next();

                    hFinal = convertHoraToInt(horarioFinal);
                    mFinal = convertMinToInt(horarioFinal);
                    if(!(hFinal >= 0 && hFinal <= 23)){
                        System.out.println("ERRO : O valor das horas tem que ser entre 00 e 23\n...\n");
                    }else if(!(mFinal >= 0 && mFinal <= 59)){
                        System.out.println("ERRO : O valor dos minutos tem que ser entre 00 e 59\n...\n");
                    }

                }while(!(hFinal >= 0 && hFinal <= 23) || !(mFinal >= 0 && mFinal <= 59));

                if ((hInicial > hFinal) || ((hInicial == hFinal) && (mInicial > mFinal)) || ((hInicial == hFinal) && (mInicial == mFinal))){
                    System.out.println("O horário inicial deve ser maior que o final...\n\n");
                }

            }while  ((hInicial > hFinal) ||
                    ((hInicial == hFinal) && (mInicial > mFinal)) ||
                    ((hInicial == hFinal) && (mInicial == mFinal))
            );

            calcularValorHorario(horarioInicial, horarioFinal);
            do {
                System.out.print("Deseja continuar? (Sim | Nao)\n\n");
                continuar = leia.next();
                if (!(continuar.equalsIgnoreCase("sim") || continuar.equalsIgnoreCase("nao"))) {
                    System.out.println("Digite Sim ou Nao...");
                }else if (continuar.equalsIgnoreCase("nao")){
                    System.out.println("\n\nTenha um bom dia :)");
                    break;
                }
            }while(!(continuar.equalsIgnoreCase("sim") || continuar.equalsIgnoreCase("nao")));


        }while (continuar.equalsIgnoreCase("sim"));


    }

    public static boolean horaEhValida(String strHoraInicial, String strHoraFinal){

        int horaA = convertHoraToInt(strHoraInicial);
        int minA = convertMinToInt(strHoraInicial);

        int horaB = convertHoraToInt(strHoraFinal);
        int minB = convertMinToInt(strHoraFinal);

        if (((horaA >= 0 && horaA <= 23) && (horaB >= 0 && horaB <= 23)) &&
                ((minA >= 0 && minA <= 59) && (minB >= 0 && minB <= 59))){

            return true;
        }else{

            return false;
        }

    }

    public static void calcularValorHorario(String strHoraInicial, String strHoraFinal){

        int horaA = convertHoraToInt(strHoraInicial);
        int minA = convertMinToInt(strHoraInicial);

        int horaB = convertHoraToInt(strHoraFinal);
        int minB = convertMinToInt(strHoraFinal);

        double custoPorMin = 0;
        int  minutosGastados = 0;
        float valorDaConta;

        //00:00 ás 05:59
        if((horaA >= 0 && minA >= 0) && (horaB <= 5 && minB <= 59)){

            custoPorMin = 0.10;
            minutosGastados = ((horaB - horaA) * 60)  + (minB - minA);

            System.out.println("Você gastou : " + minutosGastados + " minutos na ligação.");
            System.out.printf("Custo por minuto: %.2f¢\n", custoPorMin);

            valorDaConta = (float)minutosGastados * (float)custoPorMin;

            System.out.printf("Valor da conta: %.2fR$\n", valorDaConta);

        }

        //06:00 ás 07:59
        if((horaA >= 6 && minA >= 0) && (horaB <= 7 && minB <= 59)) {

            custoPorMin = 0.15;
            minutosGastados = ((horaB - horaA) * 60) + (minB - minA);

            System.out.println("Você gastou : " + minutosGastados + " minutos.");
            System.out.printf("Custo por minuto: %.2f¢\n", custoPorMin);


            valorDaConta = (float) minutosGastados * (float) custoPorMin;

            System.out.printf("Valor da conta: %.2fR$\n", valorDaConta);

        }

        //08:00 às 17:59
        if((horaA >= 8 && minA >= 0) && (horaB <= 17 && minB <= 59)) {

            custoPorMin = 0.20;
            minutosGastados = ((horaB - horaA) * 60) + (minB - minA);

            System.out.println("Você gastou : " + minutosGastados + " minutos.");
            System.out.printf("Custo por minuto: %.2f¢\n", custoPorMin);


            valorDaConta = (float) minutosGastados * (float) custoPorMin;

            System.out.printf("Valor da conta: %.2fR$\n", valorDaConta);

        }

        //18:00 às 23:59
        if((horaA >= 18 && minA >= 0) && (horaB <= 23 && minB <= 59)) {

            custoPorMin = 0.15;
            minutosGastados = ((horaB - horaA) * 60) + (minB - minA);

            System.out.println("Você gastou : " + minutosGastados + " minutos.");
            System.out.printf("Custo por minuto: %.2f¢\n", custoPorMin);


            valorDaConta = (float) minutosGastados * (float) custoPorMin;

            System.out.printf("Valor da conta: %.2fR$\n", valorDaConta);

        }
    }






    public static int convertHoraToInt(String hora){

        return Integer.parseInt(hora.substring(0,2));

    }

    public static int convertMinToInt(String min){

        return Integer.parseInt(min.substring(3,5));

    }

}
