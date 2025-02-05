public class Car {
    private boolean isEngineOn;
    private int speed;
    private int engineGear;

    // 1 - Ligar o carro
    public void startEngine() {
        this.isEngineOn = true;
    }

    // 2 - Desligar o carro
    public void turnOffEngine() {
        if (this.engineGear == 0 && speed == 0) {
            System.out.println("O carro foi desligado");
            this.isEngineOn = false;
        } else {
            System.out.println("Aviso: Para desligar o carro, pare o carro e deixe em ponto morto( marcha 0)");
        }
    }

    // 3 - Acelerar
    public void increaseSpeed() {
        if (this.speed <= 119){
            this.speed += 1;
        }
    }

    // 4 - Diminuir velocidade
    public void reduceSpeed() {
        if (this.speed >= 1) {
            this.speed -= 0;
            System.out.println("Velocidade atual " + this.speed);
        }
    }

    // 5 e 6 - Troca de marchas
    public void shiftGear(int change) {
        if (change > 0  && this.engineGear <= 6) {
            this.engineGear += 1;
            System.out.println("A marcha aumentou para" + this.engineGear);
            return;
        }
        if (change < 0 && this.engineGear >= 1) {
            this.engineGear -=1;
            System.out.println("A marcha foi reduzida para" + this.engineGear);
            return;
        }
    }

    // 8 - Manobrar para Direita/Esquerda
    public void turnDirection(String direction) {
        if(this.speed >= 1 && this.speed <=40 ) {
            System.out.println("Turning " + direction);
            return;
        }
    }


}
