public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount() + "\n");

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.


        char a = 'Ё';
        int b = a;
        char c = 'ё';
        int d = c;

        for (int i = 1040; i <= 1103; i++) {
            char A = (char) i;
            if (i == 1046) {
                System.out.println(b + " - " + a);
            } else if (i == 1078) {
                System.out.println(d + " - " + c);
            }
            System.out.println(i + " - " + A);
        }
    }


}
