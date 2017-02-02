package functionExample;

import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Created by mpean on 02/02/17.
 */
public class TestFunction {

    public static void main(String[] args) {
        // fonction qui ajoute 1 à un integer
        Function<Integer, Integer> add1 = i -> i + 1;

        // fonction qui concatene une chaine avec "1"
        Function<String, String> concat1 = s -> s + 1;

        // on fait 1+1 avec la fonction add1
        Integer two = add1.apply(1);
        System.out.println(two);

        // on concatene une String avec "1" avec la fonction concat1
        String additionTwo = concat1.apply("0 + 1 = ");
        System.out.println(additionTwo);

        // on cree une fonction qui crée une fonction qui additionne deux Integer
        Function<Integer, Function<Integer, Integer>> makeAdder = integer -> integer1 -> integer + integer1;

        // fonction qui ajoute 1 à un Integer
        Function<Integer, Integer> adder1 = makeAdder.apply(1);

        // 1+1 avec la fonction
        Integer inc1 = adder1.apply(1);
        System.out.println(inc1);

        // 2+1 avec la fonction
        Integer twoInc = adder1.apply(2);
        System.out.println(twoInc);

        // fonction qui ajoute 2 à un Integer
        Function<Integer, Integer> adder2 = makeAdder.apply(2);

        // 2+2 avec la fonction
        Integer twoPlusTwo = adder2.apply(2);
        System.out.println(twoPlusTwo);

        //fonction qui multiplie par 3 un Integer
        Function<Integer, Integer> mult3 = integer -> integer * 3;

        // fonction qui prend 2 fonctions en entree et qui compose leur execution (façon manuelle de faire un Fonction.compose(Fonction), cf.ci-dessous)
        BinaryOperator<Function<Integer, Integer>> compose = (f, g) -> integer -> g.apply(f.apply(integer));
        Function<Integer,Integer> addmultCompose = compose.apply(add1,mult3);

        // on fait (10+1)*3 avec la fcontion
        Integer res = addmultCompose.apply(10);
        System.out.println(res);

        // on compose add1 et mult3 avec la compostion native de la classe Fonction
        Function<Integer,Integer> addmult = mult3.compose(add1);

        // on fait (10+1)*3 de façon plus simple
        Integer res2 = addmult.apply(10);
        System.out.println(res2);

    }
}
