package application;

import Entities.Pessoa;
import Entities.PessoaFisica;
import Entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pessoa> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for(int i=0;i<n;i++) {
            System.out.println("Tax payer #" + (i+1) + " data:");
            System.out.print("Individual or company (i/c)? ");
            char a = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if(a == 'i') {
                System.out.println("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new PessoaFisica(name, anualIncome, healthExpenditures));
            }
            else {
                System.out.println("Number of employees: ");
                int employees = sc.nextInt();
                list.add(new PessoaJuridica(name, anualIncome, employees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID: ");
        double sum = 0.0;
        for(Pessoa pessoa : list) {
            System.out.println(String.format("Nome: %s, Imposto: $ %.2f", pessoa.getName(), pessoa.tax()));
            sum += pessoa.tax();
        }
        System.out.println(String.format("TOTAL TAXES: $ %.2f", sum));



        sc.close();
    }
}