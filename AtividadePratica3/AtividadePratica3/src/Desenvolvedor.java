class Desenvolvedor extends Funcionario {
    private ArrayList<String> tecnologias;

    public Desenvolvedor(String nome, int matricula, ArrayList<String> tecnologias) {
        super(nome, matricula);
        this.tecnologias = tecnologias;
    }

    @Override
    public double calcularSalario() {

        double salarioBase = 3000;

        double salarioTecnologias = tecnologias.size() * 500;

        return salarioBase
    }


    @Override
    public void trabalhar() {

    }

    @Override
    public void relatarProgresso() {

    }
}