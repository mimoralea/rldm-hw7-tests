import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mimoralea on 10/3/15.
 */
public class BarBrawlTest {

    @Test
    public void test1() {
        int testCase = 1;
        int numOfPatrons = 2;
        int maxIDontKnows = 1;
        boolean[][] atEstablishment = {
                {true,true},
                {true,false},
                {false,true},
                {true,true},
                {false,false},
                {true,false},
                {true,true}
        };
        boolean[] fightOccurred = {
                false,
                true,
                false,
                false,
                false,
                true,
                false
        };
        this.generalTests(testCase, numOfPatrons, maxIDontKnows, atEstablishment, fightOccurred);
    }

    @Test
    public void test2() {
        int testCase = 2;
        int numOfPatrons = 3;
        int maxIDontKnows = 5;
        boolean[][] atEstablishment = {
                {true,true,true},
                {true,true,false},
                {true,false,true},
                {false,true,true},
                {true,false,false},
                {false,true,false},
                {false,false,true},
                {false,false,false},
                {true,false,true},
                {false,true,true},
                {true,false,false}
        };
        boolean[] fightOccurred = {
                false,
                false,
                false,
                true,
                false,
                false,
                true,
                false,
                false,
                true,
                false
        };
        this.generalTests(testCase, numOfPatrons, maxIDontKnows, atEstablishment, fightOccurred);
    }

    @Test
    public void test3() {
        int testCase = 3;
        int numOfPatrons = 5;
        int maxIDontKnows = 19;
        boolean[][] atEstablishment = {
                {false,false,true,true,false},
                {true,true,false,false,false},
                {true,false,true,false,false},
                {false,true,true,false,false},
                {true,false,true,false,false},
                {false,false,false,true,true},
                {false,true,false,true,false},
                {true,false,false,true,false},
                {true,false,false,false,true},
                {false,true,false,false,true},
                {false,false,true,false,true},
                {true,false,true,false,true},
                {true,true,true,false,true},
                {false,true,false,false,false},
                {true,true,true,true,true},
                {true,false,false,false,false},
                {false,false,false,true,true},
                {true,true,false,true,true},
                {false,false,false,true,false},
                {true,true,true,true,false}
        };
        boolean[] fightOccurred = {
                false,
                true,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                true,
                false,
                false,
                true,
                true,
                false,
                false,
                false,
                false,
                false,
                false
        };
        this.generalTests(testCase, numOfPatrons, maxIDontKnows, atEstablishment, fightOccurred);
    }

    private void generalTests(int testCase, int numOfPatrons, int maxIDontKnows, boolean[][] atEstablishment, boolean[] fightOccurred)
    {
        System.out.println("Test case " + testCase);
        System.out.println("\n");
        System.out.println("The parameter for the constructor of the BarBrawl object is:");
        System.out.println("int numPatrons = " + numOfPatrons);
        System.out.println();
        BarBrawl bb = new BarBrawl(numOfPatrons);

        String[] outputs = new String[atEstablishment.length];
        int incorrectCounter = 0;
        int iDontKnowCounter = 0;
        for(int i = 0; i < atEstablishment.length; i++)
        {
            System.out.println("Calling predictOutcome with argument:");
            System.out.print("boolean[] atEstablishment = {");
            for(int j = 0; j < atEstablishment[i].length; j++)
            {
                System.out.print(atEstablishment[i][j]);
                if(j < atEstablishment[i].length - 1) System.out.print(",");
                else System.out.println("};");
            }
            outputs[i] = bb.predictOutcome(atEstablishment[i]);
            System.out.println("Your code's output was: " + outputs[i]);
            System.out.println();
            if(outputs[i].equals("FIGHT") && !fightOccurred[i] || outputs[i].equals("NO FIGHT") && fightOccurred[i])
                incorrectCounter++;
            if(outputs[i].equals("I DON'T KNOW"))
                iDontKnowCounter++;
            System.out.println("Calling learnObservation with arguments:");
            System.out.print("boolean[] atEstablishment = {");
            for(int j = 0; j < atEstablishment[i].length; j++)
            {
                System.out.print(atEstablishment[i][j]);
                if(j < atEstablishment[i].length - 1) System.out.print(",");
                else System.out.println("};");
            }
            System.out.println("boolean fightOccurred = " + fightOccurred[i]);
            bb.learnObservation(atEstablishment[i], fightOccurred[i]);
            System.out.println();
        }

        System.out.println("Your code output " + incorrectCounter + " incorrect answers.");
        if(incorrectCounter != 0) System.out.println("It should not output any incorrect answers.");
        System.out.println("Your code output " + iDontKnowCounter + " \"I DON'T KNOW\"s.");
        if(iDontKnowCounter > maxIDontKnows) System.out.println("It should output \"I DON'T KNOW\" at most " +
                maxIDontKnows + " time.");
        Assert.assertTrue(incorrectCounter == 0 && iDontKnowCounter <= maxIDontKnows);
    }
}
