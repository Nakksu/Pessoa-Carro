import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Pessoa");
        System.out.println("Digite o ID da pessoa:");
        int idPessoa = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("Digite o nome da pessoa:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email da pessoa:");
        String email = scanner.nextLine();

        System.out.println("Digite o peso da pessoa:");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(idPessoa);
        pessoa.setNome(nome);
        pessoa.setEmail(email);
        pessoa.setPeso(peso);

        DatabaseHelper.inserirPessoa(pessoa);

        System.out.println("Cadastro de Carro");
        System.out.println("Digite o combustível do carro:");
        String combustivel = scanner.nextLine();

        System.out.println("Digite o peso do carro:");
        double pesoCarro = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite a marca do carro:");
        String marca = scanner.nextLine();

        System.out.println("Digite o ano de fabricação do carro:");
        int anoFabricacao = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o tipo do carro:");
        String tipo = scanner.nextLine();

        System.out.println("Digite a cor do carro:");
        String cor = scanner.nextLine();

        System.out.println("Digite a placa do carro:");
        String placa = scanner.nextLine();

        System.out.println("Digite o número de portas do carro:");
        int numPortas = scanner.nextInt();
        scanner.nextLine();

        Carro carro = new Carro();
        carro.setCombustivel(combustivel);
        carro.setPeso(pesoCarro);
        carro.setMarca(marca);
        carro.setAnoFabricacao(anoFabricacao);
        carro.setTipo(tipo);
        carro.setCor(cor);
        carro.setPlaca(placa);
        carro.setNumPortas(numPortas);

        DatabaseHelper.inserirCarro(carro);

        System.out.println("Dados cadastrados com sucesso!");
    }
}