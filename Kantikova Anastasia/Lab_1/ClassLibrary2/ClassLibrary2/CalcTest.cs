using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace TDD_KATA
{
    [TestFixture]
    [Category("StringCalculation")]

    public class CalcTest
    {
        [Test]
        public void Add_EmptyStr_ReturnZERO()
        {
            var result = Calculator.Add("");
            Assert.AreEqual(0, result);
        }


        [Test]
        public void Add_OneNumb_ReturnNUMB()
        {
            var result = Calculator.Add("1");
            Assert.AreEqual(1, result);
        }


        [Test]
        public void Add_SeparNumb_ReturnSUM()
        {
            var result = Calculator.Add("1, 2");
            Assert.AreEqual(3, result);
        }


        [TestCase(3, "1, 2")]
        [TestCase(10, "1, 2, 3, 4")]
        public void Add_MultipleSeparNumb_ReturnSUM(int expected, string value)
        {
            var result = Calculator.Add(value);
            Assert.AreEqual(expected, result);
        }


        [Test]
        public void Add_SeparNumbByNewLine_ReturnSUM()
        {
            var result = Calculator.Add("1\n2");
            Assert.AreEqual(3, result);
        }


        [Test]
        public void Add_ChangeDelimiter_ReturnSUM()
        {
            var result = Calculator.Add("//;\n1;2");
            Assert.AreEqual(3, result);
        }

        [Test]
        public void Add_LessThanZero_TrowsExcept()
        {
            TestDelegate add = () => Calculator.Add("-1");
            Assert.Throws<Exception>(add);
        }

        public class Calculator
        {
            private static List<char> delimiters = new List<char> { ',', '\n' };
            public static int Add(string value)
            {
                var sum = 0;
                if (value == "")
                    return 0;

                ParseForValues(ParseForDelimiter(value))
                    .ForEach(s => sum += s);
                return sum;
            }

            private static List<int> ParseForValues(string value)
            {
                var values = new List<int>();
                ParseForValue(value, values);
                return values;
            }

            private static void ParseForValue(string value, List<int> values)
            {
                Array.ForEach(value.Split(delimiters.ToArray()), s =>
                {
                    var number = int.Parse(s);
                    HandleNegative(number);
                    values.Add(number);
                });
            }

            private static void HandleNegative(int number)
            {
                if (number < 0)
                    throw new Exception("Negative number is here");
            }

            private static string ParseForDelimiter(string value)
            {
                if (value.StartsWith("//"))
                {
                    delimiters.Add(value[2]);
                    value = value.Substring(4);
                }
                return value;
            }
        }
    }
}
