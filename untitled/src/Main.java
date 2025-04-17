public class Main {

    // Интерфейс автомобиля
    interface Car {
        void drive();
    }

    // Класс седана
    static class Sedan implements Car {
        @Override
        public void drive() {
            System.out.println("Вы управляете седаном 🚘");
        }
    }

    // Класс внедорожника
    static class SUV implements Car {
        @Override
        public void drive() {
            System.out.println("Вы управляете внедорожником 🚙");
        }
    }

    // Фабричный интерфейс
    interface CarFactory {
        Car createCar();
    }

    // Завод по производству седанов
    static class SedanFactory implements CarFactory {
        @Override
        public Car createCar() {
            return new Sedan();
        }
    }

    // Завод по производству внедорожников
    static class SUVFactory implements CarFactory {
        @Override
        public Car createCar() {
            return new SUV();
        }
    }

    // Клиент, который заказывает автомобили
    static class Client {
        private final CarFactory factory;

        public Client(CarFactory factory) {
            this.factory = factory;
        }

        public void orderCar() {
            Car car = factory.createCar();
            car.drive();
        }
    }

    // Главный метод (точка входа)
    public static void main(String[] args) {
        // Клиент заказывает седан
        Client client1 = new Client(new SedanFactory());
        client1.orderCar(); // Вывод: "Вы управляете седаном 🚘"

        // Клиент заказывает внедорожник
        Client client2 = new Client(new SUVFactory());
        client2.orderCar(); // Вывод: "Вы управляете внедорожником 🚙"
    }
}
