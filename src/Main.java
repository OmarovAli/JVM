// При запуске программы загрузчики классов(Classloader'ы) загрузят классы JvmComprehension, Object, Integer, System.out
class JvmComprehension {

    public static void main(String[] args) { // в Stack Memory выделяется отдельная область(кадр), в котором хранятся все значения переменных, связанных с main
        int i = 1;                      /* 1 в кадр main в Stack Memory добавляется примитивный тип int со значением 1 */
        Object o = new Object();        /* 2 в куче выделяется память для объекта Object, вызывается конструктор Object()
                                             Stack Memory создается ссылка на Object, которая хранится в "о" */
        Integer ii = 2;                 /* 3 в куче выделяется память для объекта Integer
                                                 в Stack Memory в "ii" создается ссылка, в которой хранится значение 2 */
        printAll(o, i, ii);             /* 4 в Stack Memory выделяется отдельная область(кадр), в котором хранятся все значения переменных, связанных с printAll */
        System.out.println("finished"); /* 7 в Stack Memory выделяется отдельная область(кадр), в котором хранятся все значения переменных, связанных с println
                                             в куче выделяется память для объекта String, а в фрейме println создается ссылка со значением "finished" */
        }
    private static void printAll(Object o,int i, Integer ii) {
        Integer uselessVar = 700; /* 5 в куче выделяется память для объекта Integer
         в Stack Memory в "uselessVar" создается ссылка, в которой хранится значение 700 */
        System.out.println(o.toString() + i + ii);  /* 6 в Stack Memory выделяется отдельная область(кадр),
                                                         в котором хранятся все значения переменных, связанных с println
                                                         в эту область будет переданы ссылки, хранящиеся в переменных "i", "ii", а также конструктор класса Object */

        }
}