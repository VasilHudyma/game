package Game;


public class Main {
    public static void main(String[] args){

        System.out.println("\nКомп'ютер загадає чотиризначне число, цифри в якому всі різні." +
                " Вам потрібно відгадати число, введіть 4 цифри." +
                "\nПісля кожного введення комп'ютер відповідатиме на два запитання: " +
                "Скільки цифр ви відгадали, і" +
                " скільки цифр стоять на своєму місці.\n");
        Game game =new Game();
        game.create_secret_number();
        game.guess_the_number();


    }
}
