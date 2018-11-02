package Game;

import java.util.*;

class Game {

    private Map<Integer, Integer> numbers;
    private int attempt;

    Game(){
        numbers = new HashMap<>();
    }

    //створення загаданого числа, яке поміщується у структури даних Мар
    //ключем(Key) буде рандомно згенерована унікальна цифра
    // а значенням(Value) будуть цифри від 1 до 4, що позначатимуть місце цифри у числі
    void create_secret_number(){
        attempt =0;
        Random random = new Random();
        System.out.println("Комп'ютер загадав число.");
        while (numbers.size()<4){
            numbers.putIfAbsent(random.nextInt(10),numbers.size()+1);
        }

//        Set<Integer> set = numbers.keySet();
//        for (int d: set) {
//            System.out.print(d);
//        }
//        System.out.println();

    }

    void guess_the_number(){
        attempt++;
        int[] ints = enter_number();
        int num_of_numbers=0;
        int num_of_right=0;

        //перевірка чи введено число складається із цифр і чи це число чотирицифрове
        if (ints==null||ints.length!=4){
            System.out.println("Ви ввели число неправильного формату! Спробуйте ще раз");
            guess_the_number();
        }

        int count =0; //лічильник який призначений для того, щоб рахувати к-сть вгаданих позицій цифр в загаданому числі

        //перевірка на те чи хоча б одна введена цифра є в загаданому числі
        if ((!numbers.containsKey(ints[0]))&&(!numbers.containsKey(ints[1]))&&(!numbers.containsKey(ints[2]))&&(!numbers.containsKey(ints[3]))){
            System.out.println("Число не містить жодної вказаної цифри! Спробуйте ще раз.");
            guess_the_number();
        }
        else {
                System.out.print("1. Число містить цифр: ");
            for (int anInt : ints) {
                if (numbers.containsKey(anInt)) {         //тут виводяться ті цифри, які присутні в загаданому числі
                    num_of_numbers++;
                }
            }
            System.out.println(num_of_numbers);
            num_of_numbers =0;
                System.out.print("2. Чисел на своїх позиціях: ");

                //якщо позиція вгаданої цифри в масиві збігається з значенням(Value), яке записане в Мар, то це число виводиться, інакше виводиться "*"
                for (int i = 0; i < ints.length; i++) {
                    if (numbers.get(ints[i]) != null && numbers.get(ints[i]) == i + 1) {

                        count++;                                       //якщо позиція вгадана то лічильник збільшується на 1
                    }
                }
                System.out.println(count);
                System.out.println();
                if (count!=4) guess_the_number(); //метод викликається доти, поки ви не вгадаєте позиції всіх 4 чисел
            else System.out.println("\nВітаємо, ви відгадали число!\nК-сть спроб: "+attempt);
        }
    }

    //зчитування числа з клавіатури
    // метод повертає масив цифр, введеного користувачем, числа
    private int[] enter_number(){
        Scanner scanner = new Scanner(System.in);
        String value;
        System.out.print("Введіть число: ");
        value = scanner.nextLine();    //считуєтья String який перетворюється в масив символів

        char[] chars = value.toCharArray();
        if (chars.length!=4) return null;

        int[] ints = new int[chars.length];

        //масив символів конвертуєься в масив цифр
        for (int i=0;i<chars.length;i++){
            if (Character.isDigit(chars[i])) {
                ints[i] = Character.getNumericValue(chars[i]);
            } else {
                return null; //якщо хоча б один введений символ не є цифрою метод повертає значення null
            }
        }

        if (ints[0]==ints[1]||ints[0]==ints[2]||ints[0]==ints[3]||ints[1]==ints[2]||ints[1]==ints[3]||ints[2]==ints[3])
            return null;

        return ints;
    }
}
