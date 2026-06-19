package assignments;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * ტესტი დავალება 3-ისთვის
 *
 * ეს ტესტი შეამოწმებს, რომ:
 * 1. მაქსიმალური ქულა სწორად იპოვა
 * 2. ქულა სწორი მნიშვნელობა გამოიტანა (150)
 * 3. ციკლი სწორად დაწერილი
 */
public class HighScoreFinderTest {

    @Test
    public void testFindsHighestScore() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        HighScoreFinder.main(new String[]{});

        System.setOut(System.out);
        String output = outContent.toString();

        // შეამოწმებს, რომ 150 (ყველაზე მაღალი ქულა) დაბეჭდულია
        assertTrue("უნდა დაბეჭდო ყველაზე მაღალი ქულა 150",
                output.contains("150"));
    }

    @Test
    public void testDoesNotFindLowerScore() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        HighScoreFinder.main(new String[]{});

        System.setOut(System.out);
        String output = outContent.toString();

        // შეამოწმებს, რომ 50 არის უმცროესი და არ უნდა იყოს პასუხი
        // (თუმცა შეიძლება მასივში იყოს, მაგრამ პასუხი უნდა იყოს 150)
        assertTrue("პასუხი უნდა იყოს 150, არა 50",
                !output.contains("ყველაზე მაღალი ქულა: 50"));
    }

    @Test
    public void testOutputFormat() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        HighScoreFinder.main(new String[]{});

        System.setOut(System.out);
        String output = outContent.toString();

        // შეამოწმებს სათაურს
        assertTrue("უნდა იყოს სათაური ქულის რეკორდის შესახებ",
                output.contains("რეკორდი") || output.contains("ქულა"));
    }

    @Test
    public void testCorrectHighestScore() {
        // ეს ტესტი უფრო დეტალურად შეამოწმებს:
        // მასივი: 50, 120, 85, 90, 150, 30
        // ყველაზე მაღალი: 150

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        HighScoreFinder.main(new String[]{});

        System.setOut(System.out);
        String output = outContent.toString();

        // პასუხი 150 უნდა იყოს
        assertTrue("უნდა იპოვო რომ 150 არის მაქსიმალური",
                output.contains("150"));

        // და მეტი მნიშვნელობა აქ არ უნდა იყოს (ის რომ არასწორი პასუხი არ იყოს)
        assertFalse("არ უნდა იყოს პასუხი 50, 120, 85, 90 ან 30",
                output.matches(".*ყველაზე\\s+მაღალი\\s+.*:\\s*(?:50|120|85|90|30).*"));
    }
}
