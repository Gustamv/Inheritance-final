package Entities;

public class PessoaFisica  extends Pessoa{
    private Double healthExpenditures;
    public PessoaFisica() {

        super();
    }

    public PessoaFisica(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }
    public Double getHealthExpenditures() {
        return healthExpenditures;
    }
    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        double anualIncome = getAnualIncome();
        if (anualIncome == 0) {
            if (healthExpenditures > 0) {
                return (anualIncome * 0.15) - (healthExpenditures * 0.5);
            }
            else {
                return anualIncome * 0.15;
            }
        }
        else {
            if (healthExpenditures > 0) {
                return (anualIncome * 0.25) - (healthExpenditures * 0.5);
            }
            else {
                return anualIncome * 0.25;
            }

        }
    }

}
