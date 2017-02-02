package optionalExample;

/**
 * Created by mpean on 02/02/17.
 */
public class TestOptional {

    public static void main(String[] args) {
        // afficher des conférences par id
        System.out.println(Conference.findById(100));
        System.out.println(Conference.findById(200));
        // cette conf n'existe pas
        System.out.println(Conference.findById(4444));

        //rechercher des speakers
        System.out.println(Speaker.findById(888));
        System.out.println(Speaker.findById(444));
        // ce speaker n'existe pas
        System.out.println(Speaker.findById(123));

        // afficher les références d'un co-speaker
        Conference.findById(200)
                .flatMap(Conference::getSecondarySpeaker)
                .flatMap(Speaker::getReferences)
                .ifPresent(System.out::println);
    }
}
