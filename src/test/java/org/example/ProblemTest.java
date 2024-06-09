package org.example;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {
    @Test
        public void NumberCountTest(){
        Problem pr1 = new Problem(5, 1, 10, 10);
        Assert.assertEquals(5, pr1.n);
    }

    //Sprawdzenie, czy jeśli co najmniej jeden przedmiot spełnia ograniczenia, to zwrócono co najmniej jeden element.
    @Test
        public void AtLeastOneItemTest(){
            Problem pr2 = new Problem(5, 1, 10, 10);
            Result res2 = pr2.Solve(15);
            Assert.assertTrue(res2.getTaken().size() > 0);
        }
    //Sprawdzenie, czy jeśli żaden przedmiot nie spełnia ograniczeń, to zwrócono puste rozwiązanie.
    @Test
        public void NoItemTest(){
            Problem pr3 = new Problem(5, 1, 10, 10);
            Result res3 = pr3.Solve(0);
            Assert.assertTrue(res3.getTaken().size() == 0);
        }
    //Sprawdzenie, czy waga i wartość wszystkich przedmiotów z listy mieści się w założonym przedziale.
    @Test
        public void WeightandValueIsInRange(){
            Problem pr4 = new Problem(5, 1, 10, 10);
            for (int i = 0; i < pr4.n; i++){
                Assert.assertFalse(pr4.weights.get(i) < pr4.lowerBound && pr4.weights.get(i) > pr4.upperBound);
                Assert.assertFalse(pr4.values.get(i) < pr4.lowerBound && pr4.values.get(i) > pr4.upperBound);
            }
        }

    //Sprawdzenie poprawności wyniku (sumy wag i wartości w plecaku) dla konkretnej instancji.
    @Test
        public void CorrectResultTest(){
            Problem pr5 = new Problem(5, 1, 10, 10);
            Result res5 = pr5.Solve(15);
            int sumWeight = 0;
            int sumValue = 0;
            for (int i = 0; i < res5.getTaken().size(); i++){
                sumWeight += pr5.weights.get(res5.getTaken().get(i));
                sumValue += pr5.values.get(res5.getTaken().get(i));
            }
            Assert.assertEquals(res5.getWeight(), sumWeight);
            Assert.assertEquals(res5.getValue(), sumValue);
        }



}