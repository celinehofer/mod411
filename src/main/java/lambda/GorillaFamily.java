package lambda;

public class GorillaFamily {

    private String walk = "walk";

    public static void main(String[] args) {
        GorillaFamily family = new GorillaFamily();
        family.everyonePlay(true);
    }


    @SuppressWarnings("SameParameterValue")
    private void everyonePlay(boolean baby) {
        String approach = "run";

        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    private void play(Gorilla gorilla) {
        System.out.println(gorilla.move());
    }

    @FunctionalInterface
    private interface Gorilla {
        String move();
    }
}
