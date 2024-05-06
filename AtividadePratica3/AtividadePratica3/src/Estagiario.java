class Estagiario extends Funcionario {
    private int horasDeTrabalho;
    private String supervisor;

    public Estagiario(String nome, int matricula, int horasDeTrabalho, String supervisor) {
        super(nome, matricula);
        this.horasDeTrabalho = horasDeTrabalho;
        this.supervisor = supervisor;
    }

    @Override
    public double calcularSalario() {

        return horasDeTrabalho * 10;
    }


    @Override
    public void trabalhar() {

    }

    @Override
    public void relatarProgresso() {

    }
}