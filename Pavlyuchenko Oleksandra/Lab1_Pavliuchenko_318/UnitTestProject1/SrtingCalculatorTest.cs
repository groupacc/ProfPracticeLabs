using System;

using NUnit.Framework;

namespace UnitTestProject1
{
    [TestFixture]
    public class UnitTest1
    {

        [Test]
        public void AddEmptyString()
        {
            Calculate("", 0);
        }

        [TestCase("1", 1)]
        [TestCase("2", 2)]
        public void AddOneNumber(String numbers, int expectedNumber)
        {
            Calculate(numbers, expectedNumber);
        }

        [TestCase("1,2", 3)]
        [TestCase("2,3", 4)]
        public void AddTwoNumbers(String numbers, int expectedNumber)
        {
            Calculate(numbers, expectedNumber);    
        }

        [TestCase("1,2,3", 6)]
        [TestCase("1,2,3,4", 10)]
        [TestCase("1,2,3,4,5", 15)]
        public void AddMultipleNumbers(String numbers, int expectedNumber)
        {
            Calculate(numbers, expectedNumber); 
        }

        [Test]
        public void AddNumbersWithNewLines(String numbers, int expectedNumber)
        {
            Calculate("1\n2,3", expectedNumber);
        }

        [TestCase("//;\n1;2", "1,2")]
        [TestCase("//-\n1-2", "1,2")]
        public void AddNumbersWithSpecificsForMultiple(String numbers, int expectedNumber)
        {
            Calculate(numbers, expectedNumber);
        }

        public void AddNumbersWithSpecificsForMultiple(String numbers, String expectedNumber)
        {
            if (numbers.StartsWith("//"))
            {
                numbers = numbers.Replace(numbers[2], ',');
                String result = numbers.Substring(4);
                Assert.AreEqual(expectedNumber, result);
            }        
        }

        [TestCase("-1,2,4", 6)]
        [TestCase("-1,5,2", 7)]
        public void NoAddNegativeNumbers(String numbers, int expectedNumber)
        {
            Calculate(numbers, expectedNumber);    
        }

        

        private void Calculate(String numbers, int expectedNumber)
        {
            StringCalculator calculator = new StringCalculator();
            int result = calculator.Add(numbers);
            Assert.AreEqual(expectedNumber, result);      
        }

    }

}
