using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestProject1
{
    class StringCalculator
    {
        private int DefaultSum = 0;
        private char DefaultSeparator = ',';

        public int Add(String numbers)
        {
            if(numbers.StartsWith("//"))
            {
                numbers = numbers.Replace(numbers[2], DefaultSeparator);
                numbers = numbers.Substring(4);
            }

            numbers.Replace('\n', DefaultSeparator);

            

            if (numbers == String.Empty)
            {
                return DefaultSum;
            }

            List<String> splitedNumbers = ConvertToList(numbers);

            List<int> numb = RemoveNegativeNumbers(splitedNumbers);

            return CalculateSumOfNumbers(numb);
        }

        private int CalculateSumOfNumbers(List<int> numbers)
        {
            return numbers.Sum();
        }

        private int ConvertNumbers(String numbers)
        {
            String[] splitedNums = numbers.Split(DefaultSeparator);
            int sum = 0;
            foreach (String num in splitedNums)
            {
                sum += Int32.Parse(num);           
            }
            return sum;
        }

        private List<String> ConvertToList(String numbers)
        {
            var splitedNums = numbers.Split(';');
            return splitedNums.ToList();
        }

        private List<int> RemoveNegativeNumbers(List<String> splitedNumbers)
        {
            List<int> numbers = new List<int>();
            foreach (String num in splitedNumbers)
            {
                numbers.Add(Int32.Parse(num));           
            }
            return numbers.Where(x => x >= 0 ).ToList();
        }
    }
}
