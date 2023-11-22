package Entities;

public class PessoaJuridica extends Pessoa{
    private Integer employees;
    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String name, Double anualIncome, Integer employees) {
        super(name, anualIncome);
        this.employees = employees;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    @Override
    public double tax() {
        double anualIncome = getAnualIncome();
        if(employees > 10) {
            return anualIncome * 0.14;
        }
        else {
            return anualIncome * 0.16;
        }
    }
}
