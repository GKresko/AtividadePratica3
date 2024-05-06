class Gerente extends Funcionario {
    private double bonusAnual;
    private int equipe;

    public Gerente(String nome, int matricula, double bonusAnual, int equipe) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
        this.equipe = equipe;
    }

    @Override
    public double calcularSalario() {
        double salarioBase = 5000;
        return salarioBase + (bonusAnual / 12);
    }

    @Override
    public void trabalhar() {

    }

    @Override
    public void relatarProgresso() {
      
    }
}