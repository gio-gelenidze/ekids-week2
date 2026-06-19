package assignments;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * ტესტი დავალება 2-ისთვის
 *
 * ეს ტესტი შეამოწმებს, რომ:
 * 1. თითოეული მოთამაშის სახელი ყველა დაბეჭდულია
 * 2. თითოეულისთვის პერსონალური მისალმება დაბეჭდულია
 * 3. სწორი ფორმატი გამოყენებულია
 */
public class NameTagMakerTest {

    @Test
    public void testAllNamesAreGreeted() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        NameTagMaker.main(new String[]{});

        System.setOut(System.out);
        String output = outContent.toString();

        // შეამოწმებს, რომ ყველა სახელი დაბეჭდულია
        assertTrue("უნდა დაბეჭდო Alex-ის მისალმება", output.contains("Alex"));
        assertTrue("უნდა დაბეჭდო Sam-ის მისალმება", output.contains("Sam"));
        assertTrue("უნდა დაბეჭდო Jordan-ის მისალმება", output.contains("Jordan"));
        assertTrue("უნდა დაბეჭდო Luka-ის მისალმება", output.contains("Luka"));

        // შეამოწმებს, რომ მისალმება სწორი ფორმატით დაბეჭდულია
        assertTrue("უნდა იყოს 'მოგესალმებით' სიტყვა",
                output.contains("მოგესალმებით"));
        assertTrue("უნდა იყოს 'სერვერზე' სიტყვა",
                output.contains("სერვერზე"));
    }

    @Test
    public void testGreetingCount() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        NameTagMaker.main(new String[]{});

        System.setOut(System.out);
        String output = outContent.toString();

        // დაიტრიალა თუ რამდენჯერ მუხლდება "მოგესალმებით"
        int greetingCount = countOccurrences(output, "მოგესალმებით");

        // უნდა იყოს 4 მოთამაშე, 4 მისალმება
        assertTrue("უნდა იყოს მინიმუმ 4 მოთამაშე მისალმება",
                greetingCount >= 4);
    }

    private int countOccurrences(String text, String word) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
