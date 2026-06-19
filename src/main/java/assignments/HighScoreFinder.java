package assignments;

/**
 * დავალება 3: რეკორდების დამამხობელი
 *
 * ამ დავალებაში შენ უნდა:
 * 1. შექმნა int მასივი მეგობრების ქულებით
 * 2. შექმნა ცვლადი highestScore = 0 (აქ შევინახავთ მაქსიმალურ ქულას)
 * 3. for ციკლით შეამოწმა თითოეული ქულა
 * 4. თუ ქულა მეტია highestScore-ზე, განაახლა highestScore
 * 5. ციკლის შემდეგ დაბეჭდა ყველაზე მაღალი ქულა
 */
public class HighScoreFinder {
    public static void main(String[] args) {
        // TODO: შექმენი int მასივი მეგობრების ქულებით
        // მაგალითად: 50, 120, 85, 90, 150, 30
        int[] scores = new int[6];
        scores[0] = 50;
        scores[1] = 120;
        scores[2] = 85;
        scores[3] = 90;
        scores[4] = 150;
        scores[5] = 30;

        // TODO: შექმენი ცვლადი highestScore და მიეცი მას საწყის მნიშვნელობა 0
        // TODO: დაწერე for ციკლი, რომელიც შეამოწმებს მასივის თითოეულ ელემენტს
        // ციკლის შიგნით: თუ მიმდინარე ქულა > highestScore, განაახლე highestScore

        System.out.println("==== ქულების რეკორდი ====");
        // დაწერე კოდი აქ

        // TODO: ციკლის შემდეგ დაბეჭდა: "ყველაზე მაღალი ქულა: " + highestScore
    }
}
